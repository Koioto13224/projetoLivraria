import React from 'react';
import ReactDOM from 'react-dom/client';
import Tabela from 'Pages/Home/Tabela/Tabela';
import NavBar from 'Pages/Navbar/Navbar';
import Login from 'Pages/Home/Login/Login';
import { BrowserRouter as Router, Routes, Route, createBrowserRouter, RouterProvider } from "react-router-dom";
const root = ReactDOM.createRoot(document.getElementById('root'));

  const router = createBrowserRouter([
    {
      path: "/",
      element: <Login/>
    },
    {
      path:"/tabela",
      element: <Tabela/>
    }
  ]);

  root.render(
    <React.StrictMode>
      <RouterProvider router={router}/>
    </React.StrictMode>
  );

