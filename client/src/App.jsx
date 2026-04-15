import { BrowserRouter, Routes, Route } from 'react-router-dom'

import './App.css'
import AdminLoginPage from './pages/admin/AdminLoginPage'
import AdminDashboard from './pages/admin/AdminDashboard'
import FourOFour from './pages/FourOFour'

function App() {


  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' Component={AdminLoginPage}/>
          <Route path='/admin_dashboard' Component={AdminDashboard}/>
          <Route path='/*' Component={FourOFour}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
