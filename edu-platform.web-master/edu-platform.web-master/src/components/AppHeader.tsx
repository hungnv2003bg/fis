import React from "react";
import {Link} from "react-router-dom";

const AppHeader = () => {

  return (
    <header>
      <Link to="/">Home</Link>
      <Link to="/">Top courses</Link>
      <Link to="/">Best deal</Link>
      <Link to="/">My classes</Link>
      <input className="search-input"/>
      <div className="header-right">
        <Link to="/" className="right">About us</Link>
        <Link to="/" className="right">Cart</Link>
        <Link to="/" className="right">My account</Link>
      </div>
    </header>
  );
}

export default AppHeader;