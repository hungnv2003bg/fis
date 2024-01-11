import React, {BaseSyntheticEvent, useState} from "react";

export interface Step3Data {
  idPassport: FileList;
  diploma: FileList;
  certificates: FileList;
}

interface IProps {
  endStep: (data: Step3Data) => void;
  visible: boolean;
}

const Step3 = ({endStep, visible}: IProps) => {

  const [idPassport, setIdPassport] = useState<FileList>();
  const [diploma, setDiploma] = useState<FileList>();
  const [certificates, setCertificates] = useState<FileList>();

  const onIdPassportChange = (e: BaseSyntheticEvent) => {
    setIdPassport(e.target.files);
  }

  const onDiplomaChange = (e: BaseSyntheticEvent) => {
    setDiploma(e.target.files);
  }

  const onCertificatesChange = (e: BaseSyntheticEvent) => {
    setCertificates(e.target.files);
  }

  const validateData = (data: Step3Data) => {
    return true;
  }

  const end = () => {
    const data: Step3Data = {
      certificates: certificates,
      diploma: diploma,
      idPassport: idPassport
    }

    if (validateData(data)) {
      endStep(data);
    }
  }

  return (
    <div className={`step${visible ? "" : " hidden"}`}>
      <div className="left">
        <div className="row">
          <div className="title">
            If you wish to become a verified instructor (with blue ticket), please upload your ID and certificates (in
            jpg, pfd format)
          </div>
        </div>
        <div className="row">
          <div className="col">
            <label>Your ID / Passport</label>
            <input/><input type="file" onChange={onIdPassportChange} multiple={true}/>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <label>Your post-secondary degree / diploma</label>
            <input/><input type="file" onChange={onDiplomaChange} multiple={true}/>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <label>Your training certificates (music, arts, tech, etc)</label>
            <input/><input type="file" onChange={onCertificatesChange} multiple={true}/>
          </div>
        </div>
        <div className="row">
          <button className="btn-next" onClick={() => end()}>Next</button>
        </div>
      </div>
    </div>
  );
}

export default Step3;