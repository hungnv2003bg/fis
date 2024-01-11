import {BaseResponse} from "../../BaseResponse";

export interface CourseGroup {
  id: number;
  courseGroupName: string;
  courseGroupDescription: string;
}

export interface CourseGroupsResponse extends BaseResponse {
  data: Array<CourseGroup>;
}