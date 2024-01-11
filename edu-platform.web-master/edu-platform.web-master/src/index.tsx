import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import "./styles/main.scss";
import App from './containers/App';
import appRoutes from "./routes/appRoutes";
import RequireAuth from "./routes/RequireAuth";

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <BrowserRouter>
    <Routes>
      <Route element={<App/>}>
        {
          appRoutes.map((route, index) => (
            route.requireAuth ?
              <Route path={route.path} element={<RequireAuth>{route.component}</RequireAuth>} key={index}/>
              :
              <Route path={route.path} element={route.component} key={index}/>
          ))
        }
      </Route>
    </Routes>
  </BrowserRouter>
);
