const ErrorCode = {}

const getError = (errorCode: string) => {
  if (!ErrorCode[errorCode]) {
    return errorCode;
  }

  return ErrorCode[errorCode];
}

export const Error = {
  getError
}
