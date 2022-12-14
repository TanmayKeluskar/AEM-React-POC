import React from 'react'
import { Link } from 'react-router-dom';
import './Header.css'

function Header() {
  return (
    <header className='Header'>
      <div className="header-container">
        <Link to="/content/wknd-spa-react/us/en/home.html">
          <h1>WKND</h1>
        </Link>
      </div>
    </header>
  )
}

export default Header