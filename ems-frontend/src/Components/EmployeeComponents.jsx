import React, { useEffect, useState } from 'react'
import { createEmployee, getEmployee, updateEmployee } from '../Services/EmployeeServices'
import { useNavigate,useParams } from 'react-router-dom'

function EmployeeComponents() {

    const { id } = useParams();
    const [fname, setFname] = useState('')
    const [lname, setLname] = useState('')
    const [email, setEmail] = useState('')
    

    const [errors, setError] = useState({
        fname: '',
        lname: '',
        email:''
    })

    useEffect(() => {
        if (id)
        {
            getEmployee(id).then((response) => {
                setFname(response.data.fname);
                setLname(response.data.lname);
                setEmail(response.data.email);
            }).catch(()=>console.error())
        }
        
    },[id])

    const navigator=useNavigate()

    function handleFname(e)
    {
        setFname(e.target.value)
    }
    function handleLname(e)
    {
        setLname(e.target.value)
    }
    function handleEmail(e)
    {
        setEmail(e.target.value)
    }
    function handleSubmit(e)
    {
        e.preventDefault();
        if (validate())
        {
            const details = { fname, lname, email }
            console.log(details)
            if (id)
            {
                updateEmployee(id, details).then((response) => console.log(response.data)).catch(()=> console.error());
                navigator('/employees')
            }
            else {
                createEmployee(details).then((response) => console.log(response.data)).catch(()=> console.error())
                navigator('/employees') 
            }
        }
    }

    function validate()
    {
        let valid = 1;
        const errorCopy={...errors}
        if (fname.trim())
        {
            errorCopy.fname = '';
        }
        else {
            errorCopy.fname = 'First name is empty';
            valid = 0;
        }

        
        if (lname.trim())
        {
            errorCopy.lname = '';
        }
        else {
            errorCopy.lname = 'Last name is empty';
            valid = 0;
        }


        
        if (email.trim())
        {
            errorCopy.email = '';
        }
        else {
            errorCopy.email = 'Email is empty';
            valid = 0;
        }
        setError(errorCopy);
        return valid;
    }

    function setTitle()
    {
        if (id)
        {
            return <h2 className='text-center'> update Employees</h2>
        }
        else {
            return <h2 className='text-center'> Add Employees</h2>
        }

    }

    return (
      
        <div className='container'>
            <br></br> <br></br>
          <div className='row'>
              <div className='card col-md-6 offset-md-3 offset-md-3'>
                    {
                        setTitle()
                  }
                  <div className='card-body'>
                      <form>  
                            <div className='form-group mb-2'>
                                    <label className='form-label'>FirstName</label>
                                <input className={`form-control ${errors.fname ? 'is-invalid' : ''}`} onChange={handleFname} type='text' placeholder='Enter the first Name' value={fname}></input>
                                <div className='invalid-feedback'>{errors.fname}</div>
                          </div>
                          
                           <div className='form-group mb-2'>
                                    <label className='form-label'>LastName</label>
                                <input className={`form-control ${errors.lname ? 'is-invalid' : ''}`} onChange={handleLname} type='text' placeholder='Enter the last Name' value={lname}></input>
                                <div className='invalid-feedback'>{errors.lname}</div>
                          </div>

                          <div className='form-group mb-2'>
                                    <label className='form-label'>Email</label>
                                <input className={`form-control ${errors.email ? 'is-invalid' : ''}`} onChange={handleEmail} type='text' placeholder='Enter the Email' value={email}></input>
                                <div className='invalid-feedback'>{errors.email}</div>
                          </div>
                          <button className='btn btn-success' onClick={handleSubmit}>Submit</button>
                    </form>
                    </div>
                        
                </div>
          </div>
          
    </div>
  )
}

export default EmployeeComponents