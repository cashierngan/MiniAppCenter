// import '../styles/globals.scss'
import 'antd/dist/antd.css';

import type { AppProps } from 'next/app';
import Layout from '../components/layout';

import { SWRConfig } from 'swr';
import axiosClient from '../api';

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <SWRConfig 
      value={{ 
        fetcher: (url) => axiosClient.get(url), 
        shouldRetryOnError: false 
      }}
    >
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </SWRConfig>
  )
}

export default MyApp
