import React, {BaseSyntheticEvent, useState} from "react";
import {LearnerService} from "../services/learner/learner.service";
import {InstructorService} from "../services/instructor/instructor.service";
import {LearnerLoginRequest} from "../services/learner/request/LearnerLoginRequest";
import {InstructorLoginRequest} from "../services/instructor/request/InstructorLoginRequest";
import {useNavigate} from "react-router-dom";
import {setCookie} from "../utils/cookies";
import {COOKIE_OPTION, JWT_TOKEN_KEY} from "../configs/common.config";

const Login = () => {

  const [loginType, setLoginType] = useState<string>("LEARNER");
  const [account, setAccount] = useState<string>();
  const [password, setPassword] = useState<string>();
  const navigate = useNavigate();

  const onLoginTypeChange = (e: BaseSyntheticEvent) => {
    setLoginType(e.target.value);
  }

  const onAccountChange = (e: BaseSyntheticEvent) => {
    setAccount(e.target.value);
  }

  const onPasswordChange = (e: BaseSyntheticEvent) => {
    setPassword(e.target.value);
  }

  const login = () => {
    if (!account) {
      alert("Please enter your account");
      return;
    }

    if (!password) {
      alert("Please enter your password");
      return;
    }

    const request: LearnerLoginRequest | InstructorLoginRequest = {
      account: account,
      password: password
    }

    if (loginType === "LEARNER") {
      LearnerService.login(request).then(res => {
        setCookie(JWT_TOKEN_KEY, res.data.data, COOKIE_OPTION);
        navigate("/learner-profile")
      }).catch(err => {
        alert("Wrong account or password");
      });
    } else {
      InstructorService.login(request).then(res => {
        setCookie(JWT_TOKEN_KEY, res.data.data, COOKIE_OPTION);
        navigate("/instructor-profile");
      }).catch(err => {
        alert("Wrong account or password");
      });
    }
  }

  return (
    <div className="login">
      <div className="login-form">
        <div className="login-type">
          LOGIN AS:
          <select value={loginType} onChange={onLoginTypeChange}>
            <option value="LEARNER">Learner</option>
            <option value="INSTRUCTOR">Instructor</option>
          </select>
        </div>
        <div className="form">
          <div className="form-item">
            <label>Email</label>
            <input value={account} onChange={onAccountChange}/>
          </div>
          <div className="form-item">
            <label>Password</label>
            <input type="password" value={password} onChange={onPasswordChange}/>
          </div>
          <div className="form-item">
            <button className="btn-login" onClick={() => login()}>LOGIN</button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;