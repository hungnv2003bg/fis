import React from "react";
import {useNavigate} from "react-router-dom";
import {LogoutOutlined, KeyOutlined, UserOutlined, CaretDownOutlined} from '@ant-design/icons';
import {Dropdown, Menu} from 'antd';
import {StaffService} from "../services/staff/staff.service";
import {parseJwt} from "../utils/jwt";
import {getCookie} from "../utils/cookies";
import {JWT_TOKEN_KEY} from "../configs/common.config";

const ProfileMenu = () => {

  const jwt = parseJwt(getCookie(JWT_TOKEN_KEY));

  const navigate = useNavigate();

  const logout = () => {
    StaffService.logout(() => navigate("/login"));
  }

  const menu = (
    <Menu
      items={[
        {
          label: 'Profile',
          icon: <UserOutlined/>,
          key: '0',
          onClick: () => navigate("/profile")
        },
        {
          label: 'Change password',
          icon: <KeyOutlined/>,
          key: '1',
          onClick: () => navigate("/change-password")
        },
        {
          type: 'divider',
        },
        {
          label: 'Logout',
          icon: <LogoutOutlined/>,
          key: '2',
          danger: true,
          onClick: logout
        },
      ]}
    />
  );

  return (
    <Dropdown overlay={menu} trigger={['click']}>
      <a onClick={e => e.preventDefault()} style={{marginRight: 20}}>
        Hello {jwt?.account}! <CaretDownOutlined/>
      </a>
    </Dropdown>
  );
}

export default ProfileMenu;