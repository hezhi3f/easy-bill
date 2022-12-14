import {Button, DatePicker, Dialog, Form, Input, Selector, TextArea, Toast} from "antd-mobile";
import {useState} from "react";
import dayjs from "dayjs";
import {sleep} from "antd-mobile/es/utils/sleep";
import {useLocation, useNavigate} from "react-router-dom";

export default (props) => {
  const location = useLocation()
  console.log("location", location)
  const record = location.state || {
    time: new Date(),
    amount: 0.00,
    description: '',
    type: '其他'
  }

  console.log("record", record)

  // todo location 中取出 state
  const {title, options} = props
  const navigate = useNavigate()
  const [visible, setVisible] = useState(false)


  const [type, setType] = useState(record.type);

  const submitButton = <Button block type='submit' color='primary' size='large'> 提交</Button>

  const onFinish = value => {
    console.log('value', value)

    Dialog.confirm({
      content: '是否提交本次记录',
      onConfirm: async () => {
        await sleep(3000)
        Toast.show({
          icon: 'success',
          content: '记录成功',
          position: 'center',
        })
        navigate(-1)
      },
    })
  }
  return (
    <Form mode={"default"} layout={"horizontal"} onFinish={onFinish} footer={submitButton}
          initialValues={record}>
      <Form.Header>{`${title}记录`}</Form.Header>
      <Form.Item name='time' label={`${title}时间`} trigger='onConfirm' onClick={() => setVisible(true)}>
        <DatePicker visible={visible} precision={"minute"} onClose={() => setVisible(false)}>
          {value => dayjs(value).format('YYYY-MM-DD HH:mm')}
        </DatePicker>
      </Form.Item>
      <Form.Item name='amount' label={`${title}金额`}>
        <Input placeholder={`请输入${title}金额`}/>
      </Form.Item>
      <Form.Item name='description' label={`${title}详情`}>
        <TextArea/>
      </Form.Item>
      <Form.Item name='type' label={`${title}类型`} valuePropName={''}>
        <Selector options={options} value={[type]} onChange={v => setType([...v, type][0])}/>
      </Form.Item>
    </Form>
  )
}