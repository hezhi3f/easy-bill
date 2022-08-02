import {NavBar, Tabs} from "antd-mobile";
import {useNavigate} from "react-router-dom";
import RecordForm from "../../component/RecordForm";

const income = {
  title: "收入",
  options: [
    {label: '工资', value: '工资'},
    {label: '零花钱', value: '零花钱'},
    {label: '奖金', value: '奖金'},
    {label: '其他', value: '其他'},
  ],
};
const expand = {
  title: "支出",
  options: [
    {label: '衣', value: '衣'},
    {label: '食', value: '食'},
    {label: '住', value: '住'},
    {label: '行', value: '行'},
    {label: '其他', value: '其他'},
  ]
}

export default () => {
  const navigate = useNavigate();

  return (
    <div>
      <NavBar onBack={() => navigate(-1)}>收支记录</NavBar>
      <Tabs>
        <Tabs.Tab title={"支出"} key={"out"}>
          <RecordForm {...expand}/>
        </Tabs.Tab>
        <Tabs.Tab title={"收入"} key={"in"}>
          <RecordForm {...income}/>
        </Tabs.Tab>
      </Tabs>
    </div>
  )
}