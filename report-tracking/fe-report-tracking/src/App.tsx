import { Route, Routes } from 'react-router-dom';
import './App.css';
import DashboardReport from './modules/dashboard';
import DetailReport from './modules/report-detail';

function App() {
  return (
    <Routes>
      <Route path='/' element={<DashboardReport />} />
      <Route path='/:reportId' element={<DetailReport />} />
    </Routes>
  );
}

export default App;
