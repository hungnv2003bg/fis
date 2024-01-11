import {BaseResponse} from "../../BaseResponse";

export interface Instructor {
  id: number;
  familyName: string;
  firstName: string;
  email: string;
  yearOfBirth: number;
  provinceId: number;
  districtId: number;
  wardId: number;
  address: string;
  onlineCourseDeliver: boolean;
  inPersonCourseDeliver: boolean;
  status: string;
}

export interface InstructorResponse extends BaseResponse {
  data: Instructor;
}