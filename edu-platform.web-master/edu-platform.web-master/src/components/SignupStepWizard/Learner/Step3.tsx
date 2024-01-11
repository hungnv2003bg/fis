import React, {BaseSyntheticEvent, useState} from "react";

export interface Step3Data {
  activeCode: string
}

interface IProps {
  endStep: (data: Step3Data) => void;
  visible: boolean;
}

const Step3 = ({endStep, visible}: IProps) => {

  const [otp1, setOtp1] = useState<string>();
  const [otp2, setOtp2] = useState<string>();
  const [otp3, setOtp3] = useState<string>();
  const [otp4, setOtp4] = useState<string>();

  const onOtp1Change = (e: BaseSyntheticEvent) => {
    setOtp1(e.target.value);
  }

  const onOtp2Change = (e: BaseSyntheticEvent) => {
    setOtp2(e.target.value);
  }

  const onOtp3Change = (e: BaseSyntheticEvent) => {
    setOtp3(e.target.value);
  }

  const onOtp4Change = (e: BaseSyntheticEvent) => {
    setOtp4(e.target.value);
  }

  const end = () => {
    const data: Step3Data = {
      activeCode: `${otp1}${otp2}${otp3}${otp4}`
    }

    if (!otp1 || !otp2 || !otp3 || !otp4) {
      return;
    }

    endStep(data);
  }

  return (
    <div className={`step${visible ? "" : " hidden"}`}>
      <div className="left">
        <div className="row">
          <div className="title">We have sent a verification code to your email to make sure it's you</div>
        </div>
        <hr/>
        <div className="row">
          <div className="col otp">
            <label>Please enter it here</label>
            <input value={otp1} maxLength={1} onChange={onOtp1Change}/>
            <input value={otp2} maxLength={1} onChange={onOtp2Change}/>
            <input value={otp3} maxLength={1} onChange={onOtp3Change}/>
            <input value={otp4} maxLength={1} onChange={onOtp4Change}/>
            <button className="btn-next" onClick={() => end()}>Confirm</button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Step3;