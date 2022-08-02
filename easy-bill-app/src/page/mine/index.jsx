import { List, NavBar} from "antd-mobile";

import ButtonBar from "../../component/BottomBar";
import MineNavInfo from "../../component/MineNavInfo";
import {PayCircleOutline, SetOutline, UnorderedListOutline} from "antd-mobile-icons";

export default () => {
  const handle = () => {
  }
  return (
    <div className={"app"}>
      <div className={"top"}>
        <NavBar back={null}>个人中心</NavBar>
      </div>
      <div className={"body"}>
        <MineNavInfo/>
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
