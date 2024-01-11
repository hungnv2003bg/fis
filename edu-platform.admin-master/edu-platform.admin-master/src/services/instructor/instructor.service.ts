import http from "./instructor.api";
import {InstructorGetListRequest} from "./request/InstructorGetListRequest";
import {InstructorGetListResponse} from "./response/InstructorGetListResponse";

const getInstructors = (request: InstructorGetListRequest) => {
  return http.get<InstructorGetListResponse>('/instructors', {
    params: request
  })
}

export const InstructorService = {
  getInstructors
}