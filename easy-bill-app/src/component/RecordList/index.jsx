import {Dialog, List} from "antd-mobile";
import {BillOutline, CalendarOutline, CouponOutline, HandPayCircleOutline, TruckOutline} from "antd-mobile-icons";

const records = [
  {id: 1, name: 1, time: '2022-07-16 14:11:00', amount: 10.3, description: '中饭', type: '衣'},
  {id: 2, name: 1, time: '2022-07-13 12:11:00', amount: 130.3, description: '中饭', type: '食'},
  {id: 3, name: 1, time: '2022-07-12 14:11:00', amount: 12.3, description: '中饭', type: '住'},
  {id: 4, name: 1, time: '2022-07-13 15:11:00', amount: 105, description: '中饭', type: '行'},
  {id: 5, name: 1, time: '2022-07-16 14:11:00', amount: 10.34, description: '中饭', type: '其他'},
  {id: 6, name: 1, time: '2022-07-12 17:11:00', amount: 10.34, description: '中饭', type: '住'},
  {id: 7, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {id: 8, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {id: 9, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {id: 10, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {id: 11, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
  {id: 12, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
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
  return (
    <List mode={"card"} header='历史记录'>
      {records.map(record => (
        <List.Item
          key={record.id}
          prefix={xxx(record.type)}
          description={record.description}
          onClick={showInfo(record)}
        >
          {record.amount}
        </List.Item>
      ))}
    </List>
  )
}

const xxx = (type) => {
  switch (type) {
    case '衣':
      return <TruckOutline/>
    case '食':
      return <CouponOutline/>
    case '住':
      return <CalendarOutline/>
    case '行':
      return <BillOutline/>
    default:
      return <HandPayCircleOutline/>
  }
}