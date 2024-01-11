import jwt_decode from "jwt-decode";

export interface JWT {
  iss: string;
  sub: string;
  aud: string;
  exp: number;
  nbf: number;
  phoneNumber: string;
  role: string;
  id: number;
  account: string;
  email: number;
}

export const parseJwt = (jwt: string): JWT => {
  if (!jwt) {
    return null;
  }
  return jwt_decode<JWT>(jwt);
}