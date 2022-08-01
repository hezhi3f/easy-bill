import {Avatar, List} from "antd-mobile";

export default () => {


    return (
        <List>
            <List.Item extra={<Avatar src={null}/>} clickable>头像</List.Item>
            <List.Item extra={"刚子250"}>昵称</List.Item>
            <List.Item extra={"hezhi3f"}>用户名</List.Item>
            <List.Item extra={"20"}>年龄</List.Item>
            <List.Item extra={"男"}>性别</List.Item>
            <List.Item extra={'18790301801'}>手机号</List.Item>
            <List.Item extra={'hezhi3f@foxmail.com'}>邮箱</List.Item>

        </List>
    )
}