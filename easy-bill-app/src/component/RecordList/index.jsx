import {InfiniteScroll, List} from "antd-mobile";
import {useState} from "react";


const records = [
    {id: 1, name: 1, time: '2022-07-16 14:11:00', amount: 10.3, description: '中饭', type: '衣'},
    {id: 2, name: 1, time: '2022-07-13 12:11:00', amount: 130.3, description: '中饭', type: '食'},
    {id: 3, name: 1, time: '2022-07-12 14:11:00', amount: 12.3, description: '中饭', type: '住'},
    {id: 4, name: 1, time: '2022-07-13 15:11:00', amount: 105, description: '中饭', type: '行'},
    {id: 5, name: 1, time: '2022-07-16 14:11:00', amount: 10.34, description: '中饭', type: '其他'},
    {id: 6, name: 1, time: '2022-07-12 17:11:00', amount: 10.34, description: '中饭', type: '住'},
    {id: 7, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
    {id: 7, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
    {id: 7, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
    {id: 7, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
    {id: 7, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
    {id: 7, name: 1, time: '2022-07-13 18:11:00', amount: 10.53, description: '中饭', type: '衣'},
]

export default () => {
    return (
        <List mode={"card"} header='历史记录'>
            {records.map(record => (
                <List.Item
                    key={record.id}
                    prefix={record.type}
                    description={record.description}
                >
                    {record.amount}
                </List.Item>
            ))}
        </List>
    )
}