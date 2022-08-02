import {Button, Divider, FloatingBubble, NavBar} from "antd-mobile";
import "../index.css"

import ButtonBar from "../../component/BottomBar";
import {useNavigate} from "react-router-dom";
import RecordList from "../../component/RecordList";
import {AddCircleOutline, AddOutline, ChatAddOutline, MessageFill} from "antd-mobile-icons";

export default () => {
  const navigate = useNavigate();

  return (<div className={"app"}>
    <div className={".top"}>
      <NavBar back={null}>首页</NavBar>
    </div>
    <div className={"body"}>
      <RecordList/>
      <FloatingBubble
        style={{
          '--initial-position-bottom': '128px', '--initial-position-right': '24px',
        }}
        onClick={() => {
          navigate('record')
        }}
      >
        <AddOutline fontSize={32}/>
      </FloatingBubble>
    </div>
    <div className={"bottom"}>
      <ButtonBar/>
    </div>
  </div>)
}
