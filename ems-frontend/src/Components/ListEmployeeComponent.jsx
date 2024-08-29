import React, { useEffect, useState } from 'react'
import { listEmployees, removeEmployee } from '../Services/EmployeeServices';
import { useNavigate } from 'react-router-dom';

const ListEmployeeComponent = () => {

    const navigator = useNavigate();

    const [employees, SetEmployees] = useState([]);
    
    useEffect(
        () => {
            getAllEmployee();
        },[]
    )
    
    function getAllEmployee()
    {
        listEmployees().then((response)=>SetEmployees(response.data)).catch(console.error())
    }
    function addnewEmployee()
    {
        navigator('/add-employees')
    }
    function addnewEmployee()
    {
        navigator('/add-employees')
    }

    function updateEmployee(id)
    {
        navigator(`/update-employees/${id}`)
    }

    function deleteEmployee(id)
    {
        removeEmployee(id).then(() => getAllEmployee() ).catch(console.error())
    }

  return (
      <div className='container'>
          <h2 className='text-center'> LIST OF EMPLOYEE</h2>
          <button className='btn btn-primary' onClick={addnewEmployee}>Add Employees</button>
          <table className='table table-striped table-boarderd'>
              <thead>
                  <tr>
                      <th>Emp id</th>
                      <th>First_name</th>
                      <th>Last_name</th>
                      <th>Email</th>
                      <th>Actions</th>
                  </tr>
              </thead>
              <tbody>
                  {
                      employees.map(emp => 
                        
                          <tr key={emp.id}>
                              <td>
                                  {
                                      emp.id
                                  }
                              </td>
                              <td>
                                  {
                                      emp.fname
                                  }
                              </td>
                              <td>
                                  {
                                      emp.lname
                                  }
                              </td>
                              <td>
                                  {
                                      emp.email
                                  }
                              </td>
                              <td>
                                  <button className='btn btn-info' onClick={()=>updateEmployee(emp.id)}>Update</button>
                              </td>
                              <td>
                                  <button className='btn btn-danger' onClick={()=>deleteEmployee(emp.id)}>Delete</button>
                              </td>
                          </tr>
                      )
                  }
              </tbody>
          </table>
    </div>
  )
}

export default ListEmployeeComponent