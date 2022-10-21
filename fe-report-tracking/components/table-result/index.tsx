import React, { useEffect, useState } from "react";
import styles from './table-result.module.scss';
import { Space, Table, Tag } from 'antd';
import type { ColumnsType, TableProps } from 'antd/es/table';
import Link from 'next/link';
import axios from "axios";

interface DataType {
    key: string;
    id: string;
    time: string;
    description: string;
    status: string;
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

  const [loading, setLoading] = useState<boolean>(true);
  const [listReports, setListReports] = useState<DataType[]>([])

  const handleLoadingChange = (enable: boolean) => {
    setLoading(enable);
  };

  useEffect(() => {
    const getListReports = async () => {
      const dataReport = await axios.get('http://localhost:4000/list-reports')
      console.log("===>", dataReport)
      if(dataReport?.data) {
        setListReports(dataReport.data)
        setLoading(false)
      }
    }
    getListReports()
  }, [])

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
            />
        </div>
    )
}

export default TableResult