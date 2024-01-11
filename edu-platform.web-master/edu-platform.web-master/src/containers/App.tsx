import React from 'react';
import {Outlet} from 'react-router-dom';
import AppHeader from "../components/AppHeader";

const App = () => {
  return (
    <div className="app">
      <AppHeader/>
      <Outlet/>
    </div>
  );
}

export default App;
