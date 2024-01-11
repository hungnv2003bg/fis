import {BaseResponse} from "../../BaseResponse";

export interface Province {
  id: number;
  name: string;
}

export interface ProvincesResponse extends BaseResponse {
  data: Array<Province>;
}