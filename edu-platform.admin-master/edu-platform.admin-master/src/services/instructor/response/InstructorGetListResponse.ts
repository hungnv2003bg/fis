import {Instructor} from "./Instructor";
import {BaseResponse} from "../../BaseResponse";

export interface InstructorGetListResponse extends BaseResponse {
  data: {
    total: number;
    list: Array<Instructor>
  }
}