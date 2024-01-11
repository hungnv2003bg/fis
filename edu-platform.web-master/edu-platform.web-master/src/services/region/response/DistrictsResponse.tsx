import {BaseResponse} from "../../BaseResponse";

export interface District {
  id: number;
  name: string;
}

export interface DistrictsResponse extends BaseResponse {
  data: Array<District>;
}