import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import {setCookie} from "../utils/cookies";
import {COOKIE_OPTION, JWT_TOKEN_KEY} from "../configs/common.config";
import {Button, Col, Form, Input, Layout, Row} from "antd";
import {StaffService} from "../services/staff/staff.service";
import {StaffLoginRequest} from "../services/staff/request/StaffLoginRequest";

const {Content} = Layout;

const Login = () => {
  const navigate = useNavigate();
  const [form] = Form.useForm();
  const [loading, setLoading] = useState<boolean>(false);

  const login = (values: any) => {
    setLoading(true);
    const loginRequest: StaffLoginRequest = {
      account: values.account,
      password: values.password
    }

    StaffService.login(loginRequest).then(res => {
      setCookie(JWT_TOKEN_KEY, res.data.data, COOKIE_OPTION);
      navigate("/dashboard");
      setLoading(false);
    }).catch(err => {
      setLoading(false);
    });
  }

  return (
    <Layout className="login-page">
      <Content>
        <Row gutter={8}>
          <Col span={16} className="left">
          </Col>
          <Col span={8} className="right">
            <Form layout="vertical" className="frm-login" form={form} onFinish={login}>
              <Form.Item label="Account" name="account" rules={[{required: true, message: 'Account is required'}]}>
                <Input placeholder="Enter your account"/>
              </Form.Item>
              <Form.Item label="Password" name="password" rules={[{required: true, message: 'Password is required'}]}>
                <Input placeholder="Enter your password" type="password"/>
              </Form.Item>
              <Form.Item>
                <Button type="primary" htmlType="submit" loading={loading}>Login</Button>
              </Form.Item>
            </Form>
          </Col>
        </Row>
      </Content>
    </Layout>
  );
}

export default Login;