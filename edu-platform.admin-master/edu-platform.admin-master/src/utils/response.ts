import {AxiosError} from "axios";
import {ErrorResponse} from "../services/ErrorResponse";
import {Error} from "./errorMapping";
import {notification} from "antd";

export const parseError = (err: AxiosError): ErrorResponse => {
  let errorResponse: ErrorResponse;
  if (err.code === "ERR_NETWORK") {
    errorResponse = {
      code: 'ERR_NETWORK',
      message: 'ERR_NETWORK',
    };
  } else {
    if (err.response.status === 500) {
      errorResponse = {
        code: 'UNKNOWN_ERROR',
        message: 'Unknown error, please contact administrator for more information',
      };
    } else {
      errorResponse = {
        //@ts-ignore
        code: err.response.data.code,
        //@ts-ignore
        message: Error.getError(err.response.data.code),
      };
    }
  }

  notification.error({
    message: errorResponse.code,
    description: errorResponse.message,
    placement: 'top'
  });

  return errorResponse;
}