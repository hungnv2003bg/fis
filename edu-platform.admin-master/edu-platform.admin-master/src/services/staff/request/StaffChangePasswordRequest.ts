export interface StaffChangePasswordRequest {
  id: number;
  currentPassword: string;
  newPassword: string;
}