import { Helmet } from "react-helmet";
import DetailReportComponent from "../../components/detail-result";

const DetailReport = () => {
  return (
    <div className="">
      <Helmet>
        <meta charSet="utf-8" />
        <title>Report Detail</title>
      </Helmet>
      <DetailReportComponent />
    </div>
  )
}

export default DetailReport