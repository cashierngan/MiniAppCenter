import type { TablePaginationConfig } from 'antd/es/table';
import useSWR from 'swr';
import { PublicConfiguration, SWRResponse } from 'swr/dist/types';

interface TableParams {
  pagination?: TablePaginationConfig;
}

export function useListReports(tableParams: TableParams, options?: Partial<PublicConfiguration>) {
  const {
		data: dataReports,
		error,
	}: SWRResponse = useSWR(`http://10.40.114.166:4000/list-reports?pageIndex=${tableParams.pagination?.current}&pageSize=${tableParams.pagination?.pageSize}`, {
		...options,
	})

  return {
		dataReports,
    error,
    isLoading: !error && !dataReports,
	}
}