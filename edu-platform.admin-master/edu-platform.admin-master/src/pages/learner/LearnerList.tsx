import React, {useEffect, useState} from "react";
import {LearnerService} from "../../services/learner/learner.service";
import {LearnerGetListResponse} from "../../services/learner/response/LearnerGetListResponse";
import {LearnerGetListRequest} from "../../services/learner/request/LearnerGetListRequest";
import {Divider, Table, Typography} from "antd";

const {Title} = Typography;

const LearnerList = () => {

  const [learners, setLearners] = useState<LearnerGetListResponse>();
  const [loadLearnerLoading, setLoadLearnerLoading] = useState<boolean>(false);
  const [learnerPage, setLearnerPage] = useState<number>(1);
  const [learnerPageSize] = useState<number>(10);

  const loadLearners = () => {
    setLoadLearnerLoading(true);
    const request: LearnerGetListRequest = {
      page: 1,
      size: 10
    }

    LearnerService.getLearners(request).then(res => {
      setLearners(res.data);
      setLoadLearnerLoading(false);
    }).catch(err => {
      setLoadLearnerLoading(false);
    });
  }

  const learnerColumns = [
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
      title: 'Is child account',
      dataIndex: 'isChildAccount',
      key: 'isChildAccount',
      render: (isChildAccount) => isChildAccount ? "True" : "False"
    },
    {
      title: 'Status',
      dataIndex: 'status',
      key: 'status'
    },
  ]

  const onLearnerPageChange = (page: number, pageSize: number) => {
    setLearnerPage(page);
  }

  useEffect(() => {
    loadLearners();
  }, [learnerPage]);

  return (
    <>
      <Title level={4}>Learner list</Title>
      <Divider/>
      <Table dataSource={learners?.data?.list || []} columns={learnerColumns} rowKey="id"
             loading={loadLearnerLoading}
             pagination={{
               total: learners?.data?.total || 0,
               pageSize: learnerPageSize,
               current: learnerPage,
               onChange: onLearnerPageChange
             }}/>
    </>
  );
}

export default LearnerList;