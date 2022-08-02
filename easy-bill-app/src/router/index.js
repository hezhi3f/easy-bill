import {Navigate, useRoutes} from 'react-router'
import Home from "../page/home";
import Todo from "../page/todo";
import Msg from "../page/msg";
import Mine from "../page/mine";
import Info from "../page/info";
import Record from "../page/record";
import Login from "../page/login";

export default () => useRoutes([
  {
    path: "/",
    element: <Navigate to={"/home"}/>
  },
  {
    path: "/home/record/",
    element: <Record/>
  },
  {
    path: "/home",
    element: <Home/>
  },
  {
    path: "/todo",
    element: <Todo/>
  },
  {
    path: "/msg",
    element: <Msg/>
  },
  {
    path: "/mine",
    element: <Mine/>
  },
  {
    path: "/mine/info",
    element: <Info/>
  },
  {
    path: "/login",
    element: <Login/>
  }
])