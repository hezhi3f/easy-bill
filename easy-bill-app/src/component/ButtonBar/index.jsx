import {TabBar} from "antd-mobile";
import {useNavigate, useLocation} from "react-router-dom";

export default () => {
    const navigate = useNavigate();
    const location = useLocation();
    const {pathname} = location

    return (
        <TabBar activeKey={pathname} onChange={value => navigate(value)}>
            <TabBar.Item key={"/home"} title={"首页"}/>
            <TabBar.Item key={"/todo"} title={"待办"}/>
            <TabBar.Item key={"/msg"} title={"消息"}/>
            <TabBar.Item key={"/mine"} title={"个人中心"}/>
        </TabBar>
    );
};