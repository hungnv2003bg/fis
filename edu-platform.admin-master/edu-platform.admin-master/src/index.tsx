import React from 'react';
import ReactDOM from 'react-dom/client';
import {Routes, Route, BrowserRouter, Navigate} from "react-router-dom";
import 'antd/dist/antd.css';
import "./styles/main.scss";
import App from "./containers/App";
import Login from "./containers/Login";
import Page404 from "./containers/Page404";
import appRoutes from "./routes/appRoutes";
import RequireAuth from "./routes/RequireAuth";

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(
  <BrowserRouter>
    <Routes>
      <Route
        path="/"
        element={<Navigate to="/dashboard" replace/>}
      />
      <Route
        path="/login" element={<Login/>}
      />
      <Route
        path="*"
        element={<Page404/>}
      />
      <Route element={<App/>}>
        {
          appRoutes.map((route, index) => (
            <Route path={route.path} element={<RequireAuth>{route.component}</RequireAuth>} key={index}/>
          ))
        }
      </Route>
    </Routes>
  </BrowserRouter>
);
