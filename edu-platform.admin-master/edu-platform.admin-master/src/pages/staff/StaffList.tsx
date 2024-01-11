import React, {useEffect, useState} from "react";
import {Button, Divider, Table, Typography, Modal, Form, Input, Checkbox, Tooltip, Popconfirm} from "antd";
import {
  UnlockOutlined,
  LockOutlined,
  KeyOutlined
} from '@ant-design/icons';
import {StaffGetListResponse} from "../../services/staff/response/StaffGetListResponse";
import {StaffService} from "../../services/staff/staff.service";
import {StaffGetListRequest} from "../../services/staff/request/StaffGetListRequest";
import {useForm} from "antd/es/form/Form";
import {StaffSaveRequest} from "../../services/staff/request/StaffSaveRequest";
import {validateEmail, validatePassword} from "../../utils/textUtils";
import {fireNotification} from "../../utils/nofitication";
import {Staff} from "../../services/staff/response/Staff";
import {StaffResetPasswordRequest} from "../../services/staff/request/StaffResetPasswordRequest";
import {parseJwt} from "../../utils/jwt";
import {getCookie} from "../../utils/cookies";
import {JWT_TOKEN_KEY} from "../../configs/common.config";

const {Title} = Typography;

const jwt = parseJwt(getCookie(JWT_TOKEN_KEY));

const StaffList = () => {

  const [staffs, setStaffs] = useState<StaffGetListResponse>();
  const [staffSaveOpen, setStaffSaveOpen] = useState<boolean>(false);
  const [formStaffSave] = useForm();
  const [staffResetPasswordOpen, setStaffResetPasswordOpen] = useState<boolean>(false);
  const [formStaffResetPassword] = useForm();
  const [currentStaff, setCurrentStaff] = useState<Staff>();
  const [lockLoadings, setLockLoadings] = useState<boolean[]>([]);
  const [unlockLoadings, setUnlockLoadings] = useState<boolean[]>([]);
  const [resetPasswordLoading, setResetPasswordLoading] = useState<boolean>(false);
  const [saveStaffLoading, setSaveStaffLoading] = useState<boolean>(false);
  const [loadStaffLoading, setLoadStaffLoading] = useState<boolean>(false);
  const [staffPage, setStaffPage] = useState<number>(1);
  const [staffPageSize] = useState<number>(10);

  const enterLockLoading = (index: number, loading: boolean) => {
    setLockLoadings(prevLoadings => {
      const newLoadings = [...prevLoadings];
      newLoadings[index] = loading;
      return newLoadings;
    });
  };

  const enterUnlockLoading = (index: number, loading: boolean) => {
    setUnlockLoadings(prevLoadings => {
      const newLoadings = [...prevLoadings];
      newLoadings[index] = loading;
      return newLoadings;
    });
  };

  const columns = [
    {
      title: 'ID',
      dataIndex: 'id',
      key: 'id',
    },
    {
      title: 'Full name',
      dataIndex: 'fullName',
      key: 'fullName',
    },
    {
      title: 'Account',
      dataIndex: 'account',
      key: 'account',
    },
    {
      title: 'Email',
      dataIndex: 'email',
      key: 'email',
    },
    {
      title: 'Roles',
      dataIndex: 'roles',
      key: 'roles',
    },
    {
      title: 'Status',
      dataIndex: 'status',
      key: 'status',
    },
    {
      title: 'Action',
      render: (row, record, index) => <>
        {
          jwt.id !== row.id &&
          <Tooltip title="Reset password">
            <Button type="primary" ghost onClick={() => openStaffResetPassword(row)}>
              <KeyOutlined/>
            </Button>
          </Tooltip>
        }
        &nbsp;
        {
          row.status === "ACTIVE" && jwt.id !== row.id &&
          <Popconfirm title={`Are you sure want to lock staff [${row.account}]`}
                      onConfirm={() => lockStaff(row.id, index)}>
            <Tooltip title="Lock">
              <Button danger loading={lockLoadings[index]}>
                <LockOutlined/>
              </Button>
            </Tooltip>
          </Popconfirm>
        }
        {
          row.status === "LOCK" && jwt.id !== row.id &&
          <Popconfirm title={`Are you sure want to unlock staff [${row.account}]`}
                      onConfirm={() => unlockStaff(row.id, index)}>
            <Tooltip title="Unlock">
              <Button type="dashed" danger loading={unlockLoadings[index]}>
                <UnlockOutlined/>
              </Button>
            </Tooltip>
          </Popconfirm>
        }
      </>,
    }
  ];

  const loadStaffs = () => {
    setLoadStaffLoading(true);
    const request: StaffGetListRequest = {
      page: staffPage,
      size: staffPageSize
    }

    StaffService.getList(request).then(res => {
      setStaffs(res.data);
      setLoadStaffLoading(false);
    }).catch(err => {
      setLoadStaffLoading(false);
    });
  }

  const cancelStaffSave = () => {
    setStaffSaveOpen(false);
    formStaffSave.resetFields();
  }

  const validateStaffSaveRequest = (request: StaffSaveRequest) => {
    if (!validateEmail(request.email)) {
      fireNotification("warning", "Email not valid", "");
      return false;
    }
    if (!validatePassword(request.password)) {
      fireNotification("warning", "Password must at least 8 characters, with letters and numbers", "");
      return false;
    }
    return true;
  }

  const saveStaff = (values: any) => {
    let roles = "STAFF";
    if (values.isCustomerSupport) {
      roles += ",CUSTOMER_SUPPORT";
    }
    if (values.isAccounting) {
      roles += ",ACCOUNTING";
    }
    if (values.isAdmin) {
      roles += ",ADMIN";
    }

    const request: StaffSaveRequest = {
      account: values.account,
      email: values.email,
      fullName: values.fullName,
      password: values.password,
      roles: roles
    }

    if (values.confirmPassword !== values.password) {
      fireNotification("warning", "Confirm password not match", "");
      return;
    }

    if (validateStaffSaveRequest(request)) {
      setSaveStaffLoading(true);
      StaffService.save(request).then(res => {
        loadStaffs();
        setStaffSaveOpen(false);
        setSaveStaffLoading(false);
      }).catch(err => {
        setSaveStaffLoading(false);
      });
    }
  }

  const lockStaff = (staffId: number, index: number) => {
    enterLockLoading(index, true);

    StaffService.lock(staffId).then(res => {
      fireNotification('success', 'Lock staff successfully', '');
      loadStaffs();
      enterLockLoading(index, false);
    }).catch(err => {
      enterLockLoading(index, false);
    });
  }

  const unlockStaff = (staffId: number, index: number) => {
    enterUnlockLoading(index, true);

    StaffService.unlock(staffId).then(res => {
      fireNotification('success', 'Unlock staff successfully', '');
      loadStaffs();
      enterUnlockLoading(index, false);
    }).catch(err => {
      enterUnlockLoading(index, false);
    });
  }

  const openStaffResetPassword = (currentStaff: Staff) => {
    setCurrentStaff(currentStaff);
    setStaffResetPasswordOpen(true);
  }

  const cancelStaffResetPassword = () => {
    setCurrentStaff(null);
    formStaffResetPassword.resetFields();
    setStaffResetPasswordOpen(false);
  }

  const resetPassword = (values: any) => {
    if (!validatePassword(values.password)) {
      fireNotification("warning", "Password must at least 8 characters, with letters and numbers", "");
      return false;
    }
    if (values.confirmPassword !== values.password) {
      fireNotification("warning", "Confirm password not match", "");
      return;
    }

    const request: StaffResetPasswordRequest = {
      id: currentStaff.id,
      password: values.password
    }

    setResetPasswordLoading(true);

    StaffService.resetPassword(request).then(res => {
      cancelStaffResetPassword();
      setResetPasswordLoading(false);
    }).catch(err => {
      setResetPasswordLoading(false);
    });
  }

  const onStaffPageChange = (page: number, pageSize: number) => {
    setStaffPage(page);
  }

  useEffect(() => {
    loadStaffs();
  }, [staffPage]);

  return (
    <div className="staff-list">
      <Title level={4}>Staff list</Title>
      <Divider/>
      <Button type="primary" className="btn-add" onClick={() => setStaffSaveOpen(true)}>ADD</Button>
      <Table dataSource={staffs?.data?.list || []} columns={columns} rowKey="id"
             loading={loadStaffLoading}
             pagination={{
               total: staffs?.data?.total || 0,
               pageSize: staffPageSize,
               current: staffPage,
               onChange: onStaffPageChange
             }}/>

      <Modal title="Add staff"
             visible={staffSaveOpen && !saveStaffLoading}
             footer={null}
             onCancel={cancelStaffSave}>
        <Form layout="vertical" form={formStaffSave} onFinish={saveStaff}>
          <Form.Item label="Account" name="account"
                     rules={[
                       {required: true, message: 'Account is required'},
                       {max: 255, message: 'Max length is 255'}
                     ]}>
            <Input placeholder="Enter staff account"/>
          </Form.Item>
          <Form.Item label="Password" name="password"
                     rules={[
                       {required: true, message: 'Password is required'},
                       {max: 255, message: 'Max length is 255'}
                     ]}>
            <Input placeholder="Enter staff password" type="password"/>
          </Form.Item>
          <Form.Item label="Confirm password" name="confirmPassword"
                     rules={[
                       {required: true, message: 'Confirm password is required'},
                       {max: 255, message: 'Max length is 255'}
                     ]}>
            <Input placeholder="Enter staff confirm password" type="password"/>
          </Form.Item>
          <Form.Item label="Email" name="email"
                     rules={[
                       {required: true, message: 'Email is required'},
                       {max: 255, message: 'Max length is 255'}
                     ]}>
            <Input placeholder="Enter staff email"/>
          </Form.Item>
          <Form.Item label="Full name" name="fullName"
                     rules={[
                       {required: true, message: 'Full name is required'},
                       {max: 255, message: 'Max length is 255'}
                     ]}>
            <Input placeholder="Enter staff full name"/>
          </Form.Item>
          <Form.Item noStyle name="isCustomerSupport" valuePropName="checked">
            <Checkbox>CUSTOMER SUPPORT</Checkbox>
          </Form.Item>
          <Form.Item noStyle name="isAccounting" valuePropName="checked">
            <Checkbox>ACCOUNTING</Checkbox>
          </Form.Item>
          <Form.Item noStyle name="isAdmin" valuePropName="checked">
            <Checkbox>ADMIN</Checkbox>
          </Form.Item>
          <Divider/>
          <Form.Item>
            <Button type="default" onClick={() => cancelStaffSave()}>Cancel</Button>
            &nbsp;
            <Button type="primary" htmlType="submit" loading={saveStaffLoading}>Save</Button>
          </Form.Item>
        </Form>
      </Modal>

      <Modal title="Reset password"
             visible={staffResetPasswordOpen && !resetPasswordLoading}
             footer={null}
             onCancel={cancelStaffResetPassword}>
        <Form layout="vertical" form={formStaffResetPassword} onFinish={resetPassword}>
          <Form.Item label="Account">
            <Input value={currentStaff?.account} readOnly disabled/>
          </Form.Item>
          <Form.Item label="Full name">
            <Input value={currentStaff?.fullName} readOnly disabled/>
          </Form.Item>
          <Form.Item label="New password" name="password"
                     rules={[
                       {required: true, message: 'New password is required'},
                       {max: 255, message: 'Max length is 255'}
                     ]}>
            <Input placeholder="Enter staff new password" type="password"/>
          </Form.Item>
          <Form.Item label="Confirm new password" name="confirmPassword"
                     rules={[
                       {required: true, message: 'Confirm new password is required'},
                       {max: 255, message: 'Max length is 255'}
                     ]}>
            <Input placeholder="Enter staff confirm new password" type="password"/>
          </Form.Item>
          <Form.Item>
            <Button type="default" onClick={() => cancelStaffResetPassword()}>Cancel</Button>
            &nbsp;
            <Button type="primary" htmlType="submit" loading={resetPasswordLoading}>Reset</Button>
          </Form.Item>
        </Form>
      </Modal>
    </div>
  );
}

export default StaffList;