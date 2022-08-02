import {AutoCenter, Avatar, Button, Grid, List, Space} from "antd-mobile";

import ButtonBar from "../../component/BottomBar";
import MineNavInfo from "../../component/MineNavInfo";
import {PayCircleOutline, SetOutline, UnorderedListOutline} from "antd-mobile-icons";

export default () => {
  const handle = () => {
  }
  return (
    <div className={"app"}>
      <div className={"top"}>
        <MineNavInfo/>
      </div>
      <div className={"body"}>
        <List mode={"card"}>
          <List.Item prefix={<UnorderedListOutline/>} onClick={handle}>列表1</List.Item>
          <List.Item prefix={<PayCircleOutline/>}>列表2</List.Item>
          <List.Item prefix={<UnorderedListOutline/>}>列表3</List.Item>
          <List.Item prefix={<PayCircleOutline/>}>列表4</List.Item>
          <List.Item prefix={<UnorderedListOutline/>}>列表5</List.Item>
          <List.Item prefix={<PayCircleOutline/>}>列表6</List.Item>
          <List.Item prefix={<SetOutline/>}>列表7</List.Item>
        </List>
      </div>
      <div className={"bottom"}>
        <ButtonBar/>
      </div>
    </div>
  )
}
