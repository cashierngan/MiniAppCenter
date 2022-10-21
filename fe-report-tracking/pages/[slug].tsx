import type { GetServerSidePropsContext, NextPage } from 'next';
import { GetServerSideProps } from 'next';
import DetailReportComponent from '../components/detail-result';

export interface DetailReportType {
  reportId: string;
}

const DetailReport: NextPage<DetailReportType> = ({ reportId }) => {

  return (
    <DetailReportComponent reportId={reportId}/>
  )
}

export const getServerSideProps: GetServerSideProps = async (context: GetServerSidePropsContext) => {

  const reportId = context?.params?.slug

  return {
    props: {
      reportId: reportId
    },
  }
}

export default DetailReport