
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import ListEmployeeComponent from './Components/ListEmployeeComponent'
import HeaderComponent from './Components/HeaderComponent'
import FooterComponent from './Components/FooterComponent'
import { BrowserRouter,Routes,Route } from 'react-router-dom'
import EmployeeComponents from './Components/EmployeeComponents'
import ListDepartment from './Components/ListDepartment'

function App() {

  return (
    <>
      <BrowserRouter>
          <HeaderComponent />

            <Routes>
          <Route path='/' element={<ListEmployeeComponent />}></Route>
          <Route path='/employees' element={<ListEmployeeComponent />}></Route>
          <Route path='/department' element={<ListDepartment />}></Route>
          <Route path='/add-employees' element={<EmployeeComponents />}></Route>
          <Route path='/update-employees/:id' element={<EmployeeComponents />}></Route>
            </Routes>
          
          <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
