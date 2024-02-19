package com.example.demo.service.impl;

import com.example.demo.base.BaseResponse;
import com.example.demo.exception.BusinessCode;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.response.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${services.user_service_url}")
    private String userServiceUrl;

//    @Override
//    public BaseResponse<UserDTO> getUserById(Long customerId) {
//        try {
//            ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
//                    userServiceUrl + customerId,
//                    HttpMethod.GET,
//                    null,
//                    UserDTO.class
//            );
//            UserDTO userDTO = responseEntity.getBody();
//            if (responseEntity.getStatusCode() == HttpStatus.OK && userDTO != null) {
//                return BaseResponse.success(userDTO);
//            } else {
//                return BaseResponse.fail(new BusinessException(BusinessCode.NOT_FOUND));
//            }
//        } catch (HttpClientErrorException | HttpServerErrorException e) {
//            return BaseResponse.fail(new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR));
//        }
//    }

    @Override
    public BaseResponse<UserDTO> getUserById(Long customerId) {
        try {
            ResponseEntity<BaseResponse<UserDTO>> responseEntity = restTemplate.exchange(
                    userServiceUrl + customerId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<BaseResponse<UserDTO>>() {
                    }
            );
            BaseResponse<UserDTO> userResponse = responseEntity.getBody();

            if (responseEntity.getStatusCode() == HttpStatus.OK && userResponse != null && userResponse.getData() != null) {
                return BaseResponse.success(userResponse.getData());
            } else {
                return BaseResponse.fail(new BusinessException(BusinessCode.NOT_FOUND));
            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            return BaseResponse.fail(new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR));
        }
    }


}
