import http from "./staff.api";
import {removeCookie} from "../../utils/cookies";
import {JWT_TOKEN_KEY} from "../../configs/common.config";
import {StaffLoginRequest} from "./request/StaffLoginRequest";
import {StaffLoginResponse} from "./response/StaffLoginResponse";
import {StaffGetListRequest} from "./request/StaffGetListRequest";
import {StaffGetListResponse} from "./response/StaffGetListResponse";
import {StaffSaveRequest} from "./request/StaffSaveRequest";
import {StaffResponse} from "./response/StaffResponse";
import {StaffChangePasswordRequest} from "./request/StaffChangePasswordRequest";
import {StaffResetPasswordRequest} from "./request/StaffResetPasswordRequest";

const login = (request: StaffLoginRequest) => {
  return http.post<StaffLoginResponse>("/staffs/auth", {
    account: request.account,
    password: request.password
  });
}

const getList = (request: StaffGetListRequest) => {
  return http.get<StaffGetListResponse>("/staffs", {
    params: request
  });
}

const save = (request: StaffSaveRequest) => {
  return http.post<StaffResponse>("/staffs", request);
}

const lock = (staffId: number) => {
  return http.post<StaffResponse>(`/staffs/${staffId}/lock`);
}

const unlock = (staffId: number) => {
  return http.post<StaffResponse>(`/staffs/${staffId}/unlock`);
}

const changePassword = (request: StaffChangePasswordRequest) => {
  return http.post<StaffResponse>(`/staffs/changePassword`, request);
}

const resetPassword = (request: StaffResetPasswordRequest) => {
  return http.post<StaffResponse>(`/staffs/${request.id}/reset-password`, request);
}

const getStaff = (staffId: number) => {
  return http.get<StaffResponse>(`/staffs/${staffId}/lock`);
}

const getProfile = () => {
  return http.get<StaffResponse>(`/staffs/profile`);
}

const logout = (callbackFn: () => void) => {
  removeCookie(JWT_TOKEN_KEY);
  callbackFn();
}

export const StaffService = {
  login,
  getList,
  save,
  lock,
  unlock,
  changePassword,
  resetPassword,
  getStaff,
  getProfile,
  logout
}