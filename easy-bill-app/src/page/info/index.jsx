import {NavBar} from "antd-mobile";
import InfoList from "../../component/InfoList"
import {useNavigate} from "react-router-dom";

export default () => {
  const navigate = useNavigate()
  return (
    <div>
      <NavBar onBack={() => navigate(-1)}>个人信息</NavBar>
      <InfoList/>
    </div>
  )
}