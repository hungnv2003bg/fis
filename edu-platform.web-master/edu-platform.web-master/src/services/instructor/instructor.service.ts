import http from "./instructor.api";
import {InstructorRegisterRequest} from "./request/InstructorRegisterRequest";
import {InstructorLoginRequest} from "./request/InstructorLoginRequest";
import {InstructorActiveRequest} from "./request/InstructorActiveRequest";
import {InstructorResponse} from "./response/InstructorResponse";
import {InstructorLoginResponse} from "./response/InstructorLoginResponse";

const signup = (request: InstructorRegisterRequest) => {
  let formData = new FormData();
  formData.append("familyName", request.familyName);
  formData.append("firstName", request.firstName);
  formData.append("email", request.email);
  formData.append("password", request.password);
  formData.append("gender", request.gender);
  formData.append("address", request.address);
  formData.append("provinceId", request.provinceId.toString());
  formData.append("districtId", request.districtId.toString());
  formData.append("wardId", request.wardId.toString());
  formData.append("onlineCourseDeliver", request.onlineCourseDeliver.toString());
  formData.append("inPersonCourseDeliver", request.inPersonCourseDeliver.toString());
  formData.append("courseCategoryIds", request.courseCategoryIds);
  formData.append("yearOfBirth", request.yearOfBirth.toString());

  Array.from(request.avatar || []).forEach((item) => {
    formData.append("avatar", item);
  });
  Array.from(request.idPassport || []).forEach((item) => {
    formData.append("idPassport", item);
  });
  Array.from(request.diploma || []).forEach((item) => {
    formData.append("diploma", item);
  });
  Array.from(request.certificates || []).forEach((item) => {
    formData.append("certificates", item);
  });

  return http.post<InstructorResponse>(`/instructors/register`, formData, {
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  });
}

const active = (instructorId: number, request: InstructorActiveRequest) => {
  return http.put(`/instructors/${instructorId}/active`, request);
}

const login = (request: InstructorLoginRequest) => {
  return http.post<InstructorLoginResponse>(`/instructors/auth`, request);
}

export const InstructorService = {
  signup,
  active,
  login
}