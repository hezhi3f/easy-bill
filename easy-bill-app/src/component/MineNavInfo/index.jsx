import {Avatar, Button, Grid, List, NavBar, Space} from "antd-mobile";
import {useNavigate} from "react-router-dom";

export default () => {
  const navigate = useNavigate()
  const user = null;
  return (
    <List>
      <List.Item
        key={"郭梦强"}
        prefix={<Avatar style={{"--size": "64px"}} src={""}/>}
        description={"18790301801"}
        onClick={() => navigate("info")}
      >
        刚子250
      </List.Item>
    </List>

  )
}
