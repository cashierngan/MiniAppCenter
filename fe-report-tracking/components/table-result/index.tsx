import React, { useEffect, useState } from "react";
import styles from './table-result.module.scss';
import { Space, Table, Tag } from 'antd';
import type { ColumnsType, TableProps, TablePaginationConfig } from 'antd/es/table';
import Link from 'next/link';
import axios from "axios";

interface DataType {
    key: string;
    id: string;
    time: string;
    description: string;
    status: string;
}

interface TableParams {
  pagination?: TablePaginationConfig;
}

const columns: ColumnsType<DataType> = [
    {
      title: 'ID',
      dataIndex: 'id',
      key: 'id',
      render: id => <Link href={`/${id}`}><a>{id}</a></Link>,
    },
    {
      title: 'Time',
      dataIndex: 'time',
      key: 'time',
    },
    {
      title: 'Description',
      dataIndex: 'description',
      key: 'description',
    },
    {
      title: 'Status',
      key: 'status',
      dataIndex: 'status',
      render: status => (
        <Tag color={status === 'Fail' ? 'volcano' : 'green'} >
            {status.toUpperCase()}
        </Tag>
      ),
    },
    {
      title: 'Action',
      key: 'action',
      dataIndex: 'id',
      render: id => (
        <Link href={`/${id}`}>
          <a>View</a>
        </Link>
      ),
    },
];

const TableResult = () => {

  const [loading, setLoading] = useState<boolean>(false);
  const [listReports, setListReports] = useState<DataType[]>([])
  const [tableParams, setTableParams] = useState<TableParams>({
    pagination: {
      current: 1,
      pageSize: 10,
    },
  });

  const getListReports = async () => {
    setLoading(true)
    const dataReport = await axios.get(`http://localhost:4000/list-reports?pageIndex=${tableParams.pagination?.current}&pageSize=${tableParams.pagination?.pageSize}`)
    if(dataReport?.data) {
      setListReports(dataReport.data.data)
      setLoading(false)
      setTableParams({
        ...tableParams,
        pagination: {
          ...tableParams.pagination,
          total: dataReport.data.total,
        },
      });
    }
  }

  useEffect(() => {
    getListReports()
  }, [JSON.stringify(tableParams)])

  const handleTableChange = (pagination: TablePaginationConfig) => {
    setLoading(true);
    setTableParams({pagination});
  };

  const tableProps: TableProps<DataType> = {
    loading,
    bordered: true
  };

    return(
        <div className={styles.table}>
            <Table 
              {...tableProps} 
              columns={columns} 
              dataSource={listReports ? listReports : []}
              pagination={tableParams.pagination}
              onChange={handleTableChange}
            />
        </div>
    )
}

export default TableResult