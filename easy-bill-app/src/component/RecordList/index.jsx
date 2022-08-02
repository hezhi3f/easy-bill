import {Dialog, Image, List, SwipeAction, Tag} from "antd-mobile";
import {BillOutline, CalendarOutline, CouponOutline, HandPayCircleOutline, TruckOutline} from "antd-mobile-icons";
import {useRef} from "react";
import {useNavigate} from "react-router-dom";

const records = [
  {id: 1, name: 1, time: '2022-07-16 14:11:00', amount: 10.3, description: '中饭', type: '衣'},
  {id: 2, name: 1, time: '2022-07-13 12:11:00', amount: -130.3, description: '中饭', type: '食'},
  {id: 3, name: 1, time: '2022-07-12 14:11:00', amount: 12.3, description: '中饭', type: '住'},
  {id: 4, name: 1, time: '2022-07-13 15:11:00', amount: -105, description: '中饭', type: '行'},
  {id: 5, name: 1, time: '2022-07-16 14:11:00', amount: 10.34, description: '中饭', type: '其他'},
  {id: 6, name: 1, time: '2022-07-12 17:11:00', amount: 10.34, description: '中饭', type: '住'},
  {id: 7, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {id: 8, name: 1, time: '2022-07-13 18:11:00', amount: -10.53, description: '中饭', type: '衣'},
  {id: 9, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {id: 10, name: 1, time: '2022-07-13 18:11:00', amount: -10.53, description: '中饭', type: '衣'},
  {id: 11, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {id: 12, name: 1, time: '2022-07-13 18:11:00', amount: -10.53, description: '中饭', type: '衣'},
]

const showInfo = (record) => {
  return () => {
    Dialog.show({
      header: (record.time),
      title: record.amount,
      content: (
        <>
          <div>{record.type}</div>
          <div>{record.description}</div>
        </>
      ),
      closeOnMaskClick: true,
      closeOnAction: true,
      actions: [
        [
          {
            key: 'cancel',
            text: '取消'
          },
          {
            key: 'delete',
            text: '删除',
            bold: true,
            danger: true
          },
        ]
      ],
      onAction: (action, index) => {
        console.log("action", action)
        console.log("index", index)
      }
    })
  }
}


export default () => {

  const navigate = useNavigate()

  const getRightActions = (record) => [
    {
      key: 'copy',
      text: '复制',
      color: 'light',
      onClick: () => {
        navigate("/home/record", {state: record})
      }
    },
    {
      key: 'delete',
      text: '删除',
      color: 'danger',
      onClick: () => {
        console.log('todo -> delete', record.id)
      }
    },
  ]

  return (
    <List mode={"card"} header='历史记录'>
      {records.map(record => (
        <SwipeAction
          key={record.id}
          rightActions={getRightActions(record)}
        >
          <List.Item
            title={Type(record.type)}
            children={record.description}
            key={record.id}
            prefix={<Image width={"3.2em"} height={"3.2em"}
                           src={"https://fc1tn.baidu.com/it/u=3594259389,3922307789&fm=202&mola=new&crop=v1"}
                           fit={"cover"}/>}
            description={record.time}
            extra={Amount(record.amount)}
            arrow
            clickable
            onClick={showInfo(record)}
          />
        </SwipeAction>

      ))}
    </List>
  )
}

const Type = (type) => <Tag color='primary' fill='outline'>{type}</Tag>

const Amount = (amount) => {
  if (amount < 0) {
    return <div style={{color: "#ff3141"}}>{amount}</div>
  } else {
    return <div style={{color: "#00b578"}}>{`+${amount}`}</div>
  }

}
