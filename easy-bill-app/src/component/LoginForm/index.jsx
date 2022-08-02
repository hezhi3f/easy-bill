import {Button, Form, Input} from "antd-mobile";


export default () => {

  const onFinish = () => {
  }

  const footer = <Button block size={"large"} type={"submit"} key={"login"} color={"primary"}>注册/登录</Button>

  return (
    <Form onFinish={onFinish} footer={footer} mode={"card"}>
      <Form.Header>登录或者注册账号</Form.Header>
      <Form.Item key={"username"}>
        <Input placeholder={"用户名"}/>
      </Form.Item>
      <Form.Item key={"password"}>
        <Input placeholder={"密码"} type={"password"}/>
      </Form.Item>
      <Form.Item key={"checkcode"} label={"验证码"}
                 layout={"horizontal"}
                 style={{
                   "--prefix-width": "4.0em"
                 }} extra={<a>发送验证码</a>}>
        <Input placeholder={"请输入验证码"}/>
      </Form.Item>
    </Form>

  )
}