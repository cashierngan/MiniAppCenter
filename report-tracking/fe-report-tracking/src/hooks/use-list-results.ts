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
	}: SWRResponse = useSWR(`https://api.mservice.com.vn:8001/automation-test/list-reports?pageIndex=${tableParams.pagination?.current}&pageSize=${tableParams.pagination?.pageSize}`, {
		...options,
	})

  return {
		dataReports,
    error,
    isLoading: !error && !dataReports,
	}
}