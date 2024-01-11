import {AxiosInstance} from "axios";
import {getCookie} from "./cookies";
import {JWT_TOKEN_KEY} from "../configs/common.config";
import {parseError} from "./response";

export const setupRequest = (http: AxiosInstance) => {
  http.interceptors.request.use(config => {
    const jwt = getCookie(JWT_TOKEN_KEY);
    if (jwt) {
      config.headers['X-AUTH-TOKEN'] = jwt;
    }

    return config;
  }, error => {
    return Promise.reject(error);
  });

  http.interceptors.response.use(response => {
    return response;
  }, error => {
    parseError(error);
    return Promise.reject(error);
  });
}