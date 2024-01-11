import {BaseResponse} from "../../BaseResponse";
import {Staff} from "./Staff";

export interface StaffGetListResponse extends BaseResponse {
  data: {
    total: number;
    list: Array<Staff>;
  }
}