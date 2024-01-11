package edu.platform.application.controllers;

import edu.platform.application.constant.RoleConstant;
import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.InstructorCode;
import edu.platform.application.service.UploadService;
import edu.platform.application.validators.InstructorValidator;
import edu.platform.domains.instructor.model.request.*;
import edu.platform.domains.instructor.model.response.InstructorResponse;
import edu.platform.domains.instructor.service.InstructorService;
import edu.platform.security.jwt.TokenProducer;
import edu.platform.security.jwt.payload.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController extends BaseController {

    @Autowired
    private InstructorService instructorService;
    @Autowired
    private TokenProducer tokenProducer;
    @Autowired
    private InstructorValidator instructorValidator;
    @Autowired
    private UploadService uploadService;

    @Value("${upload.avatar.path}")
    private String avatarUploadPath;
    @Value("${upload.idPassport.path}")
    private String idPassportUploadPath;
    @Value("${upload.diploma.path}")
    private String diplomaUploadPath;
    @Value("${upload.certificates.path}")
    private String certificatesUploadPath;

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity save(@ModelAttribute InstructorSaveRequest request) {
        instructorValidator.validateInstructorSaveRequest(request);

        List<String> avatar = uploadService.uploadFile(request.getAvatar(), avatarUploadPath);
        List<String> diploma = uploadService.uploadFile(request.getDiploma(), diplomaUploadPath);
        List<String> idPassport = uploadService.uploadFile(request.getIdPassport(), idPassportUploadPath);
        List<String> certificates = uploadService.uploadFile(request.getCertificates(), certificatesUploadPath);

        String avatarFileName = String.join(",", avatar);
        String diplomaFileName = String.join(",", diploma);
        String idPassportFileName = String.join(",", idPassport);
        String certificatesFileName = String.join(",", certificates);

        request.setAvatarFileName(avatarFileName);
        request.setDiplomaFileName(diplomaFileName);
        request.setIdPassportFileName(idPassportFileName);
        request.setCertificatesFileName(certificatesFileName);

        return success(instructorService.save(request));
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody InstructorAuthRequest request) {
        instructorValidator.validateInstructorAuthRequest(request);

        InstructorResponse auth = instructorService.auth(request);
        Payload payload = buildPayload(auth);
        String jwt = tokenProducer.token(payload);

        return success(jwt);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody InstructorUpdateRequest request) {
        checkId(id);
        instructorValidator.validateInstructorUpdateRequest(request);

        return success(instructorService.update(id, request));
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody InstructorChangePasswordRequest request) {
        checkId(id);
        instructorValidator.validateInstructorChangePasswordRequest(request);

        instructorService.changePassword(id, request);

        return success();
    }

    @PutMapping("/{id}/active")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody InstructorActiveRequest request) {
        instructorValidator.validateInstructorActiveRequest(request);

        instructorService.active(id, request);

        return success();
    }

    @GetMapping
    @PreAuthorize(value = RoleConstant.ROLE_STAFF)
    public ResponseEntity getInstructors(InstructorGetListRequest request) {
        instructorValidator.validateInstructorGetListRequest(request);

        return success(instructorService.getList(request));
    }

    private Payload buildPayload(InstructorResponse instructorResponse) {
        Payload payload = new Payload();
        payload.setId(instructorResponse.getId());
        payload.setPhoneNumber("");
        payload.setEmail(instructorResponse.getEmail());
        payload.setAccount(instructorResponse.getEmail());
        payload.setRole("INSTRUCTOR");

        return payload;
    }

    private void checkId(Long id) {
        if (id != getUserDetail().getUser().getId()) {
            throw new BusinessException(InstructorCode.INSTRUCTOR_NOT_OWN);
        }
    }
}
