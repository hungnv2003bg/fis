import {BaseResponse} from "../../BaseResponse";

export interface Ward {
  id: number;
  name: string;
}

export interface WardsResponse extends BaseResponse {
  data: Array<Ward>;
}