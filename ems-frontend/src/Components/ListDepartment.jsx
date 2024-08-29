import React, { useEffect, useState } from 'react'
import { getalldepartment } from '../Services/DepartmentServices';

function ListDepartment() {
    const[data,setData]=useState([]);
    // const data = [{
    //     "id": 1,
    //     "dname": "cs",
    //     "ddesc":"asdasd"
    // },{
    //     "id": 1,
    //     "dname": "cs",
    //     "ddesc":"asdasd"
    // }]
    useEffect(() => {
        getalldepartment().then((response) => {
            setData(response.data);
       }) 
    },[])
  return (
      <div className='container'>
           <h2 className='text-center'> LIST OF DEPARTMENT</h2>
          <table className='table table-striped table-boarderd'>
              <thead>
                  <tr>
                      <th>ID</th>
                      <th>DEPARTMENT NAME</th>
                      <th>DEPARTMENT DESCRIPTION</th>
                  </tr>

              </thead>
              <tbody>
                  {
                      data.map((e) =>
                          <tr>
                              <td>{e.id}</td>
                              <td>{e.dname}</td>
                              <td>{e.ddesc}</td>
                          </tr>
                      )
                  }
              </tbody>
          </table>
          
    </div>
  )
}

export default ListDepartment