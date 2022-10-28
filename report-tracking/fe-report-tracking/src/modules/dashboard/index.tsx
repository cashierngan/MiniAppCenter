import { Helmet } from "react-helmet";
import TableResult from "../../components/table-result";

const DashboardReport = () => {
  return (
    <div className="">
      <Helmet>
        <meta charSet="utf-8" />
        <title>Dashboard Report Tracking</title>
      </Helmet>
      <TableResult />
    </div>
  )
}

export default DashboardReport