import React from "react";
import {Navigate, useLocation} from "react-router-dom";
import {getCookie} from "../utils/cookies";
import {JWT_TOKEN_KEY} from "../configs/common.config";

const RequireAuth = ({children}: { children: JSX.Element }) => {
  const location = useLocation();
  const jwt = getCookie(JWT_TOKEN_KEY);

  if (!jwt) {
    return <Navigate to="/login" state={{from: location}} replace/>;
  }

  return children;
}

export default RequireAuth;