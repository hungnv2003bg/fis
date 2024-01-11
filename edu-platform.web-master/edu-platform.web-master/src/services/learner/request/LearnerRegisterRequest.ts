export interface LearnerRegisterRequest {
  familyName: string;
  firstName: string;
  yearOfBirth: number;
  password: string;
  provinceId: number;
  districtId: number;
  wardId: number;
  email: string;
  avatar: FileList;
  inPersonCourseInterest: boolean;
  onlineCourseInterest: boolean;
  courseCategoryIds: string;
}