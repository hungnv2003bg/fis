package edu.platform.application.controllers;

import edu.platform.application.constant.RoleConstant;
import edu.platform.application.service.UploadService;
import edu.platform.application.validators.LearnerValidator;
import edu.platform.domains.learner.model.request.*;
import edu.platform.domains.learner.model.response.LearnerResponse;
import edu.platform.domains.learner.service.LearnerService;
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
@RequestMapping("/learners")
public class LearnerController extends BaseController {

    @Autowired
    private LearnerService learnerService;
    @Autowired
    private TokenProducer tokenProducer;
    @Autowired
    private LearnerValidator learnerValidator;
    @Autowired
    private UploadService uploadService;

    @Value("${upload.avatar.path}")
    private String avatarUploadPath;

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity save(@ModelAttribute LearnerSaveRequest request) {
        learnerValidator.validateLearnerSaveRequest(request);

        List<String> avatar = uploadService.uploadFile(request.getAvatar(), avatarUploadPath);

        String avatarFileName = String.join(",", avatar);

        request.setAvatarFileName(avatarFileName);

        return success(learnerService.save(request));
    }

    @PutMapping("/{id}/active")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody LearnerActiveRequest request) {
        learnerValidator.validateLearnerActiveRequest(request);

        learnerService.active(id, request);

        return success();
    }

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody LearnerAuthRequest request) {
        learnerValidator.validateLearnerAuthRequest(request);

        LearnerResponse auth = learnerService.auth(request);
        Payload payload = buildPayload(auth);
        String jwt = tokenProducer.token(payload);

        return success(jwt);
    }

    @PostMapping("/mapping")
    public ResponseEntity mapping(@RequestBody LearnerMappingRequest request) {
        learnerValidator.validateMappingRequest(request);
        learnerService.mappingAdultAccount(request);

        return success();
    }

    @PostMapping("/confirm-mapping")
    public ResponseEntity confirmMapping(@RequestBody LearnerConfirmMappingRequest request) {
        learnerValidator.validateConfirmMappingRequest(request);
        learnerService.confirmMappingAdultAccount(request);

        return success();
    }

    @GetMapping
    @PreAuthorize(value = RoleConstant.ROLE_STAFF)
    public ResponseEntity getLearners(LearnerGetListRequest request) {
        learnerValidator.validateLearnerGetListRequest(request);

        return success(learnerService.getList(request));
    }

    private Payload buildPayload(LearnerResponse learnerResponse) {
        Payload payload = new Payload();
        payload.setId(learnerResponse.getId());
        payload.setPhoneNumber("");
        payload.setEmail(learnerResponse.getEmail());
        payload.setAccount(learnerResponse.getEmail());
        payload.setRole("LEARNER");

        return payload;
    }
}
