import http from "./learner.api";
import {LearnerGetListResponse} from "./response/LearnerGetListResponse";
import {LearnerGetListRequest} from "./request/LearnerGetListRequest";

const getLearners = (request: LearnerGetListRequest) => {
  return http.get<LearnerGetListResponse>(`/learners`, {
    params: request
  });
}

export const LearnerService = {
  getLearners
}