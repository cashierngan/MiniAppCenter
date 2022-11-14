import { Table, Tag } from "antd";
import type {
  ColumnsType,
  TablePaginationConfig,
  TableProps
} from "antd/es/table";
import { useState } from "react";
import { Link } from 'react-router-dom';
import { useListReports } from "../../hooks";
import styles from "./table-result.module.scss";

interface DataType {
  key: string;
  id: string;
  time: string;
  description: string;
  status: {
    totalIssue: number;
    detail: {
      statusName: string;
      count: number;
    }[];
  };
}

interface TableParams {
  pagination?: TablePaginationConfig;
}

export interface ListReportsProps {
  dataReports?: {
    data?: {
      id: string;
      description: string;
      key: string;
      status: {
        totalIssue: number;
        detail: {
          statusName: string;
          count: number;
        }[];
      };
      time: string;
    }[];
    pageIndex: number;
    pageSize: number;
    total: number;
  };
  isLoading: boolean;
}

const columns: ColumnsType<DataType> = [
  {
    title: "ID",
    dataIndex: "id",
    key: "id",
    render: (id) => (
      <Link to={`/${id}`}>
        {id}
      </Link>
    ),
  },
  {
    title: "Time",
    dataIndex: "time",
    key: "time",
  },
  {
    title: "Description",
    dataIndex: "description",
    key: "description",
  },
  {
    title: "Status",
    key: "status",
    dataIndex: "status",
    render: (_, { status }) => (
      <>
        {status.detail.map((item, index) => {
          if(item.count === status.totalIssue){
            return (
              <div key={index}>
                <Tag color={item.statusName === "Failed" ? "volcano" : "green"}>
                  {item.statusName.toUpperCase()}
                </Tag>
              </div>
            );
          } else {
            if(item.count > 0 && item.statusName === 'Failed') {
              return (
                <div key={index}>
                  <Tag color="volcano">
                    {item.statusName.toUpperCase()}
                    {" "}
                    {item.count !== status.totalIssue && <span>{item.count}/{status.totalIssue}</span>}
                  </Tag>
                </div>
              )
            } else {
              return <></>
            }
          }
        })}
      </>
    ),
  },
  {
    title: "Action",
    key: "action",
    dataIndex: "id",
    render: (id) => (
      <Link to={`/${id}`}>
        View
      </Link>
    ),
  },
];

const TableResult = () => {
  const loading: boolean = true;
  const [tableParams, setTableParams] = useState<TableParams>({
    pagination: {
      current: 1,
      pageSize: 10,
    },
  });

  const { dataReports, isLoading }: ListReportsProps = useListReports(
    tableParams,
    {
      revalidateOnFocus: true,
      // refreshInterval: 1000 * 60 * 60,
      refreshWhenOffline: true,
    }
  );

  const handleTableChange = (pagination: TablePaginationConfig) => {
    setTableParams({ pagination });
  };

  const tableProps: TableProps<DataType> = {
    loading: isLoading && loading,
    bordered: true,
  };

  return (
    <div className={styles.table}>
      <Table
        {...tableProps}
        columns={columns}
        dataSource={dataReports?.data || []}
        pagination={{
          ...tableParams.pagination,
          total: dataReports?.total || 1,
        }}
        onChange={handleTableChange}
      />
    </div>
  );
};

export default TableResult;
