import {BaseResponse} from "../../BaseResponse";
import {Staff} from "./Staff";

export interface StaffResponse extends BaseResponse {
  data: Staff;
}