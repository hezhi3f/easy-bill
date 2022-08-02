import {AutoCenter, Button, Space} from "antd-mobile";

import ButtonBar from "../../component/BottomBar";

export default () => {

    return (
        <div className={"app"}>
            {/*<div className={"top"}></div>*/}
            <div className={"body"}>
                <AutoCenter>
                    <Space direction={"vertical"} block>
                        <Button color={"success"}>支出</Button>
                        <Button color={"danger"}>收入</Button>
                    </Space>
                </AutoCenter>
            </div>
            <div className={"bottom"}>
                <ButtonBar/>
            </div>
        </div>
    )
}
