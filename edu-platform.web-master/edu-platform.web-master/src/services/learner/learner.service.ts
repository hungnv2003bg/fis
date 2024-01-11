import http from "./learner.api";
import {LearnerRegisterRequest} from "./request/LearnerRegisterRequest";
import {LearnerResponse} from "./response/LearnerResponse";
import {LearnerLoginRequest} from "./request/LearnerLoginRequest";
import {LearnerActiveRequest} from "./request/LearnerActiveRequest";
import {LearnerLoginResponse} from "./response/LearnerLoginResponse";
import {LearnerMappingRequest} from "./request/LearnerMappingRequest";
import {LearnerConfirmMappingRequest} from "./request/LearnerConfirmMappingRequest";

const signup = (request: LearnerRegisterRequest) => {
  let formData = new FormData();
  formData.append("familyName", request.familyName);
  formData.append("firstName", request.firstName);
  formData.append("email", request.email);
  formData.append("password", request.password);
  formData.append("provinceId", request.provinceId.toString());
  formData.append("districtId", request.districtId.toString());
  formData.append("wardId", request.wardId.toString());
  formData.append("onlineCourseInterest", request.onlineCourseInterest.toString());
  formData.append("inPersonCourseInterest", request.inPersonCourseInterest.toString());
  formData.append("courseCategoryIds", request.courseCategoryIds);
  formData.append("yearOfBirth", request.yearOfBirth.toString());

  Array.from(request.avatar || []).forEach((item) => {
    formData.append("avatar", item);
  });

  return http.post<LearnerResponse>(`/learners/register`, formData, {
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  });
}

const active = (learnerId: number, request: LearnerActiveRequest) => {
  return http.put(`/learners/${learnerId}/active`, request);
}

const login = (request: LearnerLoginRequest) => {
  return http.post<LearnerLoginResponse>(`/learners/auth`, request);
}

const sendMapping = (request: LearnerMappingRequest) => {
  return http.post(`/learners/mapping`, request);
}

const confirmMapping = (request: LearnerConfirmMappingRequest) => {
  return http.post(`/learners/confirm-mapping`, request);
}

export const LearnerService = {
  signup,
  active,
  login,
  sendMapping,
  confirmMapping
}