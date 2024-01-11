import {BaseResponse} from "../../BaseResponse";

export interface CourseCategory {
  id: number;
  courseCategoryName: string;
  courseCategoryDescription: string;
}

export interface CourseCategoriesResponse extends BaseResponse {
  data: Array<CourseCategory>
}