import {Button, Form, Input} from "antd-mobile";
import {useState} from "react";


export default () => {

  const [checkCodeItem, setCheckCodeItem] = useState({name: "验证邮箱", disabled: true})

  const [form] = Form.useForm()


  const onFinish = () => {
  }

  const footer = <Button block size={"large"} type={"submit"} key={"login"} color={"primary"}>注册/登录</Button>

  const countDown = (seconds) => {
    if (seconds === 0) {
      setCheckCodeItem({name: `发送验证码`, disabled: false})
    } else {
      setTimeout(() => {
        setCheckCodeItem({name: `再次发送，${seconds}s`, disabled: true})
        countDown(seconds - 1);
      }, 1000)
    }
  }

  const handleVerifyEmail = () => {
    const email = form.getFieldValue("email");
    // todo axios
    // 开启定时器
    countDown(10)
  }


  const checkCode = (
    <Button color={"primary"} fill={"none"}
            disabled={checkCodeItem.disabled}
            onClick={handleVerifyEmail}>
      {checkCodeItem.name}
    </Button>
  )

  return (
    <Form form={form} onFinish={onFinish} footer={footer} mode={"card"}>
      <Form.Header>登录或者注册账号</Form.Header>
      <Form.Item name={"username"} key={"username"}>
        <Input placeholder={"用户名"}/>
      </Form.Item>
      <Form.Item name={"password"} key={"password"}>
        <Input placeholder={"密码"} type={"password"}/>
      </Form.Item>
      <Form.Item name={"email"} key={"email"}>
        <Input placeholder={"请输入邮箱"}/>
      </Form.Item>
      <Form.Item name={"checkcode"} key={"checkcode"}
                 extra={checkCode}>
        <Input placeholder={"邮箱验证码"}/>
      </Form.Item>
    </Form>

  )
}
