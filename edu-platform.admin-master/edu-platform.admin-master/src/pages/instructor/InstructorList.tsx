import React, {useEffect, useState} from "react";
import {InstructorGetListResponse} from "../../services/instructor/response/InstructorGetListResponse";
import {InstructorService} from "../../services/instructor/instructor.service";
import {InstructorGetListRequest} from "../../services/instructor/request/InstructorGetListRequest";
import {Divider, Table, Typography} from "antd";

const {Title} = Typography;

const InstructorList = () => {

  const [instructor, setInstructor] = useState<InstructorGetListResponse>();
  const [loadInstructorLoading, setLoadInstructorLoading] = useState<boolean>(false);
  const [instructorPage, setInstructorPage] = useState<number>(1);
  const [instructorPageSize] = useState<number>(10);

  const loadInstructors = () => {
    setLoadInstructorLoading(true);
    const request: InstructorGetListRequest = {
      page: 1,
      size: 10
    }

    InstructorService.getInstructors(request).then(res => {
      setInstructor(res.data);
      setLoadInstructorLoading(false);
    }).catch(err => {
      setLoadInstructorLoading(false);
    });
  }

  const instructorColumn = [
    {
      title: 'ID',
      dataIndex: 'id',
      key: 'id'
    },
    {
      title: 'Family name',
      dataIndex: 'familyName',
      key: 'familyName'
    },
    {
      title: 'First name',
      dataIndex: 'firstName',
      key: 'firstName'
    },
    {
      title: 'Email',
      dataIndex: 'email',
      key: 'email'
    },
    {
      title: 'Year of birth',
      dataIndex: 'yearOfBirth',
      key: 'yearOfBirth'
    },
    {
      title: 'Gender',
      dataIndex: 'gender',
      key: 'gender'
    },
    {
      title: 'Is verified',
      dataIndex: 'isVerified',
      key: 'isVerified',
      render: (isVerified) => isVerified ? "True" : "False"
    },
    {
      title: 'Verify status',
      dataIndex: 'verifyStatus',
      key: 'verifyStatus'
    },
  ];

  const onInstructorPageChange = (page: number, pageSize: number) => {
    setInstructorPage(page)
  }

  useEffect(() => {
    loadInstructors();
  }, [instructorPage])

  return (
    <>
      <Title level={4}>Instructor list</Title>
      <Divider/>
      <Table dataSource={instructor?.data?.list || []} columns={instructorColumn} rowKey="id"
             loading={loadInstructorLoading}
             pagination={{
               total: instructor?.data?.total || 0,
               pageSize: instructorPageSize,
               current: instructorPage,
               onChange: onInstructorPageChange
             }}/>
    </>
  );
}

export default InstructorList;