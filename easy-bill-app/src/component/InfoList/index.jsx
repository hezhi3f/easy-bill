import {Avatar, List} from "antd-mobile";

const user = {
  "id": 3,
  "username": "guojq",
  "password": "123456",
  "avatar": null,
  "nickname": "刚子",
  "phoneNumber": null,
  "email": null,
  "gender": 1,
  "age": 16,
  "gmtCreated": "2022-08-01T12:58:46.000+00:00",
  "gmtModified": "2022-08-01T12:59:43.000+00:00",
  "deleted": false
}

const formatAge = v => {
  const gender = ["女", "男"];
  if (v === null) {
    return "未知";
  }
  return gender[v];
}

export default () => {
  return (
    <List>
      <List.Item extra={<Avatar src={user.avatar}/>} clickable>头像</List.Item>
      <List.Item extra={user.nickname}>昵称</List.Item>
      <List.Item extra={user.username}>用户名</List.Item>
      <List.Item extra={user.age}>年龄</List.Item>
      <List.Item extra={formatAge(user.gender)}>性别</List.Item>
      <List.Item extra={user.phoneNumber}>手机号</List.Item>
      <List.Item extra={user.email}>邮箱</List.Item>
    </List>
  )
}