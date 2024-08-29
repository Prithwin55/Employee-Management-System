import React from 'react'
import { NavLink } from 'react-router-dom'

function HeaderComponent() {
  return (
    <div>
    <header>
        
        <nav className='navbar navbar-expand-lg navbar-dark bg-dark' >
            <a className='navbar-brand pos' href='#'>Employee Management System</a>
            <div className="collapse " id="navbarNav">
              <ul className="navbar-nav">
                  <li className="nav-item active" style={{color:"red"}}>
                      <NavLink className='nav-link'to={'/employees'}>Employees</NavLink>
                  </li>
                  <li className="nav-item active">
                      <NavLink className='nav-link'to={'/Department'}>Department</NavLink>
                  </li>
              </ul>
          </div>
           
        </nav>
    </header>
</div>
  )
}

export default HeaderComponent