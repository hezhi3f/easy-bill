import {AutoCenter, Button, NavBar, Space} from "antd-mobile";

import ButtonBar from "../../component/BottomBar";

export default () => {
  return (
    <div className={"app"}>
      <div className={"top"}>
        <NavBar back={null}>信息</NavBar>
      </div>
      <div className={"body"}>
        <AutoCenter>
          <Space direction={"vertical"} block>
            <Button color={"success"}>信息</Button>
          </Space>
        </AutoCenter>
      </div>
      <div className={"bottom"}>
        <ButtonBar/>
      </div>
    </div>
  )
}
