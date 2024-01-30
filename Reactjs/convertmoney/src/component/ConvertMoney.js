import React, { useState } from 'react';
import '../css/style.css';
export default function ConvertMoney() {
    let [moneyStart, setMoneyStart] = useState();
    let [moneyEnd, setMoneyEnd] = useState()
    let [unit, setUnit] = useState("yen");
    let sumbitConvert = () => {
        let money;
        if (unit == "yen") {
            money = moneyStart * 202.16;
            setMoneyEnd(money)
        } else if (unit == "banganh") {
            money = moneyStart * 30429.17;
        } else if (unit == "euro") {
            money = moneyStart * 25832.33
        } else if (unit == "dola") {
            money = moneyStart * 22982.50
        }
        setMoneyEnd(money)
    }
    const currencyFormat = (num) => {
        return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,') + ' VNĐ'
    }
    return (
        <>
            <div className="convert" >
                <div className="convert__title" >
                    Tiền Tệ
                </div>
                <div>
                    <label>Tôi muốn chuyển đổi:</label>
                    <input value={moneyStart} onChange={e => setMoneyStart(e.target.value)} type="number" min={0} />
                    <select value={unit} onChange={e => setUnit(e.target.value)} >
                        <option value="yen" >Yên Nhật</option>
                        <option value="banganh" >Bảng Anh</option>
                        <option value='euro' >Euro</option>
                        <option value="dola" >Đô la Mỹ</option>
                    </select>
                </div>
                <div>
                    <label>Đến</label>
                    <select>
                        <option>Đồng Việt Nam</option>
                    </select>
                </div>
                <button onClick={sumbitConvert} >Xác nhận</button>
                <label>{currencyFormat(moneyEnd)}</label>
            </div>
        </>
    )
}