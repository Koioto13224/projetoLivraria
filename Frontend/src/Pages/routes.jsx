import { createBrowserRouter } from "react-router-dom";

import SignIn from "Pages/Home/SignIn"; 
import Table from "Pages/Home/Table"

const routes = createBrowserRouter([
  {
    element: <SignIn />,
    path: "/",
    index: true 
  },
  {
    element: <Table />,
    path: "/table"
  }
])

export default routes