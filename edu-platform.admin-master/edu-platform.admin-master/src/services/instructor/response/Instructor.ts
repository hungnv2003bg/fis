export interface Instructor {
  id: number;
  familyName: string;
  firstName: string;
  email: string;
  yearOfBirth: number;
  gender: string;
  address: string;
  provinceId: number;
  districtId: number;
  wardId: number;
  onlineCourseDeliver: boolean;
  inPersonCourseDeliver: boolean;
  status: string;
  isVerified: boolean;
  verifyStatus: string;
}