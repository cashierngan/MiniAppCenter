import { useMemo } from 'react';
import { Link, useParams } from 'react-router-dom';
import { useListReports } from '../../hooks';
import { ListReportsProps } from '../table-result';
import styles from './detail-result.module.scss';

const DetailReportComponent: React.FC = () => {

  const tableParams = {
    pagination: {
      current: 1,
      pageSize: 10,
    }
  }

  const { dataReports }: ListReportsProps = useListReports(
    tableParams,
    {
      revalidateOnFocus: true,
      refreshWhenOffline: true,
    }
  );

  const reportId = useParams()?.reportId || 10000
    
  const checkStatus = useMemo(() => {
    if(!dataReports?.data && !reportId) return false
    const getReportById = dataReports?.data?.find(_ => _.id === reportId)
    if(!getReportById) return false 
    const isFalse = getReportById.status.detail?.find(_ => _.statusName === 'Failed')?.count
    if(isFalse !== 0) {
      return false
    }
    return true
  }, [dataReports, reportId])

  return (
    <div className={styles.container}>
      <div>
        <div className={styles.back}>
          <Link to={'/'}>Back</Link>   
        </div>
        <div className={styles.status}>
          <p className={checkStatus ? styles.passed : styles.failed}>{checkStatus ? 'Passed' : 'Failed'}</p>
        </div>
      </div>
      <iframe title={reportId.toString()} src={`https://api.mservice.com.vn:8001/automation-test/report-detail/${reportId}`} className={styles.iframe}></iframe>
    </div>
  )
}

export default DetailReportComponent