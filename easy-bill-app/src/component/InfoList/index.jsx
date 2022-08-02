import {Avatar, List} from "antd-mobile";
import React from "react";

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

export default () => {
  return (
    <List>
      <List.Item extra={<Avatar src={user.avatar}/>}>头像</List.Item>
      <List.Item extra={user.nickname}>昵称</List.Item>
      <List.Item extra={user.username}>用户名</List.Item>
      <List.Item extra={user.age}>年龄</List.Item>
      <List.Item extra={["未设置", "女", "男"][user.gender]}>性别</List.Item>
      <List.Item extra={user.phoneNumber}>手机号</List.Item>
      <List.Item extra={user.email}>邮箱</List.Item>
    </List>
  )
}