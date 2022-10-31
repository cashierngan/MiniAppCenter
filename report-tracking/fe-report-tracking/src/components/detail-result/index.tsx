import { Link, useParams } from 'react-router-dom';
import styles from './detail-result.module.scss';

const DetailReportComponent: React.FC = () => {

  const reportId = useParams()?.reportId || 10000

  return (
    <div className={styles.container}>
      <div className={styles.back}>
        <Link to={'/'}>Back</Link>
      </div>
      <iframe title={reportId.toString()} src={`https://api.mservice.com.vn:8001/automation-test/report-detail/${reportId}`} className={styles.iframe}></iframe>
    </div>
  )
}

export default DetailReportComponent