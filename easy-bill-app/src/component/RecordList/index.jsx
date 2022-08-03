import {Dialog, Ellipsis, Image, List, SwipeAction, Tag} from "antd-mobile";
import {useNavigate} from "react-router-dom";

const records = [
  {username: 'hezhi3f', nickname: '不只会干饭', time: '2022-07-16 14:11:00', amount: 10.3, description: '中饭', type: '衣'},
  {
    username: 'hezhi3f',
    nickname: '不只会干饭',
    time: '2022-07-13 12:11:00',
    amount: -130.3,
    description: '这是一条长度一般的描述',
    type: '食'
  },
  {
    nickname: '不只会干饭',
    time: '2022-07-12 14:11:00',
    amount: 12.3,
    description: '这是一条特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别特别长的描述',
    type: '住'
  },
  {username: 'hezhi3f', nickname: '不只会干饭', time: '2022-07-13 15:11:00', amount: -105, description: '中饭19.3', type: '行'},
  {
    username: 'hezhi3f',
    nickname: '不只会干饭',
    time: '2022-07-16 14:11:00',
    amount: 10.34,
    description: '晚饭324',
    type: '其他'
  },
  {
    username: 'hezhi3f',
    nickname: '不只会干饭',
    time: '2022-07-12 17:11:00',
    amount: 10.34,
    description: '这是一条描述',
    type: '住'
  },
  {username: 'hezhi3f', nickname: '不只会干饭', time: '2022-07-13 18:11:00', amount: 10.53, description: '', type: '衣'},
  {
    username: 'hezhi3f',
    nickname: '不只会干饭',
    time: '2022-07-13 18:11:00',
    amount: -10.53,
    description: '又一条描述',
    type: '衣'
  },
  {
    username: 'hezhi3f',
    nickname: '不只会干饭',
    time: '2022-07-13 18:11:00',
    amount: 10.53,
    description: '今天早上吃什么',
    type: '衣'
  },
  {
    username: 'hezhi3f',
    nickname: '不只会干饭',
    time: '2022-07-13 18:11:00',
    amount: -10.53,
    description: '明天早上吃什么',
    type: '衣'
  },
  {username: 'hezhi3f', nickname: '不只会干饭', time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {username: 'hezhi3f', nickname: '不只会干饭', time: '2022-07-13 18:11:00', amount: -10.53, description: '中饭', type: '衣'},
]

const showInfo = (record) => {
  return () => {
    Dialog.show({
      image: "https://fc1tn.baidu.com/it/u=3594259389,3922307789&fm=202&mola=new&crop=v1",
      title: record.amount,
      content: (
        <>
          <div>{record.description}</div>
          <div>{record.type}{record.time}</div>
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
      {records.map((record,index) => (
        <SwipeAction
          key={index}
          rightActions={getRightActions(record)}
        >
          <List.Item
            title={Type(record.type)}
            key={index}
            prefix={<Image width={"3.2em"} height={"3.2em"}
                           src={"https://fc1tn.baidu.com/it/u=3594259389,3922307789&fm=202&mola=new&crop=v1"}
                           fit={"cover"}/>}
            description={record.time}
            extra={Amount(record.amount)}
            arrow
            clickable
            onClick={showInfo(record)}
          >
            <Ellipsis direction='end' content={record.description}/>
          </List.Item>
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
