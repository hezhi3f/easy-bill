import {AutoCenter, Button, NavBar, Space} from "antd-mobile";

import ButtonBar from "../../component/ButtonBar";

export default () => {

    return (
        <div className={"app"}>
            <div className={"top"}>
                <NavBar back={null}>待办</NavBar>
            </div>
            <div className={"body"}>
                <AutoCenter>
                    <Space direction={"vertical"} block>
                        <Button color={"success"}>待办</Button>
                    </Space>
                </AutoCenter>
            </div>
            <div className={"bottom"}>
                <ButtonBar/>
            </div>
        </div>
    )
}
