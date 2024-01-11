import {BaseResponse} from "../../BaseResponse";
import {Learner} from "./Learner";

export interface LearnerGetListResponse extends BaseResponse {
  data: {
    total: number;
    list: Array<Learner>;
  }
}