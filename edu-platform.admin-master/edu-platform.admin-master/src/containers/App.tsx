import React from 'react';
import {Outlet, useNavigate} from "react-router-dom";
import {Layout, Menu} from 'antd';
import {
  DashboardOutlined,
  UserOutlined,
  SkinOutlined,
  ContainerOutlined,
  DollarOutlined,
  TeamOutlined
} from '@ant-design/icons';
import ProfileMenu from "../components/ProfileMenu";
import {parseJwt} from "../utils/jwt";
import {getCookie} from "../utils/cookies";
import {JWT_TOKEN_KEY} from "../configs/common.config";

const {Header, Sider, Content} = Layout;

function App() {
  const navigate = useNavigate();
  const jwt = parseJwt(getCookie(JWT_TOKEN_KEY));

  const getMenuItems = () => {
    const menuItems = [
      {
        key: '1',
        icon: <DashboardOutlined/>,
        label: 'Dashboard',
        onClick: () => navigate('/dashboard')
      },
      {
        key: '2',
        icon: <SkinOutlined/>,
        label: 'Learner',
        children: [
          {
            key: '2.1',
            label: 'Learner list',
            onClick: () => navigate('/learners'),
          }
        ]
      },
      {
        key: '3',
        icon: <UserOutlined/>,
        label: 'Instructor',
        children: [
          {
            key: '3.1',
            label: 'Instructor list',
            onClick: () => navigate('/instructors'),
          }
        ]
      },
      {
        key: '4',
        icon: <ContainerOutlined/>,
        label: 'Course',
        children: [
          {
            key: '4.1',
            label: 'Course list',
            onClick: () => navigate('/courses'),
          }
        ]
      },
      {
        key: '5',
        icon: <DollarOutlined/>,
        label: 'Booking',
        children: [
          {
            key: '5.1',
            label: 'Booking list',
            onClick: () => navigate('/bookings'),
          }
        ]
      }

    ];

    if (jwt?.role?.includes("ADMIN")) {
      menuItems.push(
        {
          key: '6',
          icon: <TeamOutlined/>,
          label: 'Staff',
          children: [
            {
              key: '6.1',
              label: 'Staff list',
              onClick: () => navigate('/staffs'),
            }
          ]
        }
      );
    }

    return menuItems;
  }

  return (
    <Layout>
      <Sider trigger={null} collapsible
             style={{
               position: 'fixed',
               overflow: 'auto',
               height: '100vh',
               left: 0,
               top: 0,
               bottom: 0,
             }}>
        <div className="logo"/>
        <Menu
          theme="dark"
          mode="inline"
          defaultSelectedKeys={['1']}
          items={getMenuItems()}
        />
      </Sider>
      <Layout className="site-layout" style={{marginLeft: 200}}>
        <Header className="site-layout-background header" style={{
          padding: 0,
          position: 'fixed',
          width: '100vw',
          paddingRight: 220,
          textAlign: "right"
        }}>
          <ProfileMenu/>
        </Header>
        <Content
          className="site-layout-background"
          style={{
            margin: '88px 16px',
            padding: 24,
            overflow: 'initial',
          }}
        >
          <Outlet/>
        </Content>
      </Layout>
    </Layout>
  );
}

export default App;
