export interface InstructorRegisterRequest {
  familyName: string;
  firstName: string;
  email: string;
  yearOfBirth: number;
  password: string;
  gender: string;
  address: string;
  provinceId: number;
  districtId: number;
  wardId: number;
  onlineCourseDeliver: boolean;
  inPersonCourseDeliver: boolean;
  courseCategoryIds: string;
  idPassport: FileList;
  diploma: FileList;
  certificates: FileList;
  avatar: FileList;
}