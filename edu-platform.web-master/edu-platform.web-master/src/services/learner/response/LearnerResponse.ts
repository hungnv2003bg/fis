import {BaseResponse} from "../../BaseResponse";

export interface Learner {
  id: number;
  familyName: string;
  firstName: string;
  email: string;
  yearOfBirth: number;
  provinceId: number;
  districtId: number;
  wardId: number;
  onlineCourseInterest: boolean;
  inPersonCourseInterest: boolean;
  status: string;
  isChildAccount: boolean;
}

export interface LearnerResponse extends BaseResponse {
  data: Learner
}