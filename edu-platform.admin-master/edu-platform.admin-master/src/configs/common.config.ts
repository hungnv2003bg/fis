export const JWT_TOKEN_KEY = "X-AUTH-TOKEN";

export const COOKIE_OPTION = {
  path: '/',
  domain: window.location.host.includes("admin.clazzi.xyz") ? 'admin.clazzi.xyz' : '',
  secure: window.location.protocol === 'https:',
  expires: new Date(Date.now() + (3600 * 1000 * 8))
};