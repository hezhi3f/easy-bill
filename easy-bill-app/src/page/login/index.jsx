import LoginForm from "../../component/LoginForm";
import {FloatingBubble, NavBar} from "antd-mobile";
import {useNavigate} from "react-router-dom";

export default () => {
  const navigate = useNavigate()
  return (
    <div className={"app"}>
      <div className={".top"}>
        <NavBar onBack={() => navigate(-1)}>注册/登录</NavBar>
      </div>
      <div className={"body"}>
        <LoginForm/>
      </div>
      <div className={"bottom"}>
      </div>
    </div>
  )
}
