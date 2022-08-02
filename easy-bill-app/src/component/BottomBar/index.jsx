import {TabBar} from "antd-mobile";
import {useNavigate, useLocation} from "react-router-dom";
import {AppOutline, MessageOutline, TextOutline, UserOutline} from "antd-mobile-icons";

export default () => {
  const navigate = useNavigate();
  const location = useLocation();
  const {pathname} = location

  return (
    <TabBar activeKey={pathname} onChange={value => navigate(value)}>
      <TabBar.Item key={"/home"} title={"首页"} icon={<AppOutline/>}/>
      <TabBar.Item key={"/todo"} title={"待办"} icon={<TextOutline/>}/>
      <TabBar.Item key={"/msg"} title={"消息"} icon={<MessageOutline/>}/>
      <TabBar.Item key={"/mine"} title={"个人中心"} icon={<UserOutline/>}/>
    </TabBar>
  );
};