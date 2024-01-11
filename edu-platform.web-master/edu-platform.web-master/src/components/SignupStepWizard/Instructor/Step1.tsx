import React, {BaseSyntheticEvent, useEffect, useState} from "react";
import {RegionService} from "../../../services/region/region.service";
import {ProvincesResponse} from "../../../services/region/response/ProvincesResponse";
import {DistrictsResponse} from "../../../services/region/response/DistrictsResponse";
import {WardsResponse} from "../../../services/region/response/WardsResponse";
import {validateEmail, validatePassword} from "../../../utils/textUtils";

export interface Step1Data {
  familyName: string;
  firstName: string;
  gender: string;
  yearOfBirth: number;
  password: string;
  address: string;
  provinceId: number;
  districtId: number;
  wardId: number;
  inPersonCourseDeliver: boolean;
  onlineCourseDeliver: boolean;
  email: string;
  avatar: FileList;
}

interface IProps {
  endStep: (data: Step1Data) => void;
  visible: boolean;
}

const Step1 = ({endStep, visible}: IProps) => {
  const year = new Date().getFullYear();

  const [provinces, setProvinces] = useState<ProvincesResponse>();
  const [districts, setDistricts] = useState<DistrictsResponse>();
  const [wards, setWards] = useState<WardsResponse>();
  const [selectedProvinceId, setSelectedProvinceId] = useState<number>();
  const [selectedDistrictId, setSelectedDistrictId] = useState<number>();
  const [selectedWardId, setSelectedWardId] = useState<number>();
  const [familyName, setFamilyName] = useState<string>();
  const [firstName, setFirstName] = useState<string>();
  const [email, setEmail] = useState<string>();
  const [password, setPassword] = useState<string>();
  const [confirmPassword, setConfirmPassword] = useState<string>();
  const [gender, setGender] = useState<string>("MALE");
  const [yearOfBirth, setYearOfBirth] = useState<number>(year - 22);
  const [address, setAddress] = useState<string>();
  const [inPersonCourseDeliver, setInPersonCourseDeliver] = useState<boolean>(false);
  const [onlineCourseDeliver, setOnlineCourseDeliver] = useState<boolean>(false);
  const [avatar, setAvatar] = useState<FileList>();

  const loadProvinces = () => {
    RegionService.getProvinces().then(res => {
      setProvinces(res.data);
    });
  }

  const loadDistricts = () => {
    RegionService.getDistricts(selectedProvinceId).then(res => {
      setDistricts(res.data);
    });
  }

  const loadWards = () => {
    RegionService.getWards(selectedDistrictId).then(res => {
      setWards(res.data);
    });
  }

  const onFamilyNameChange = (e: BaseSyntheticEvent) => {
    setFamilyName(e.target.value);
  }

  const onFirstNameChange = (e: BaseSyntheticEvent) => {
    setFirstName(e.target.value);
  }

  const onEmailChange = (e: BaseSyntheticEvent) => {
    setEmail(e.target.value);
  }

  const onYearOfBirthChange = (e: BaseSyntheticEvent) => {
    setYearOfBirth(e.target.value)
  }

  const onGenderChange = (e: BaseSyntheticEvent) => {
    setGender(e.target.value);
  }

  const onAddressChange = (e: BaseSyntheticEvent) => {
    setAddress(e.target.value);
  }

  const onPasswordChange = (e: BaseSyntheticEvent) => {
    setPassword(e.target.value);
  }

  const onConfirmPasswordChange = (e: BaseSyntheticEvent) => {
    setConfirmPassword(e.target.value);
  }

  const onInPersonCourseDeliverChange = (e: BaseSyntheticEvent) => {
    setInPersonCourseDeliver(e.target.checked);
  }

  const onOnlineCourseDeliverChange = (e: BaseSyntheticEvent) => {
    setOnlineCourseDeliver(e.target.checked);
  }

  const onProvinceChange = (e: BaseSyntheticEvent) => {
    setSelectedProvinceId(Number(e.target.value));
  }

  const onDistrictChange = (e: BaseSyntheticEvent) => {
    setSelectedDistrictId(Number(e.target.value));
  }

  const onWardChange = (e: BaseSyntheticEvent) => {
    setSelectedWardId(Number(e.target.value));
  }

  const getYearOfBirthSelectOptions = () => {
    const options = [];

    for (let i = year - 100; i <= year; i++) {
      options.push(
        <option value={i} key={i}>{i}</option>
      );
    }

    return options;
  }

  const onAvatarChange = (e: BaseSyntheticEvent) => {
    setAvatar(e.target.files);
  }

  const validateData = (data: Step1Data) => {
    if (!data.familyName) {
      alert("Please input your family name");
      return false;
    }
    if (!data.firstName) {
      alert("Please input your first name");
      return false;
    }
    if (!data.email) {
      alert("Please input your email");
      return false;
    } else {
      if (!validateEmail(data.email)) {
        alert("Email not valid");
        return false;
      }
    }
    if (!data.password) {
      alert("Please input your password");
      return false;
    } else {
      if (!validatePassword(data.password)) {
        alert("Password not match policy");
        return false;
      }
    }
    if (!confirmPassword) {
      alert("Please input your confirm password");
      return false;
    }
    if (confirmPassword !== data.password) {
      alert("Confirm password not match");
      return false;
    }
    if (!data.address) {
      alert("Please input your address");
      return false;
    }
    if (!data.provinceId) {
      alert("Please choose city");
      return false;
    }
    if (!data.districtId) {
      alert("Please choose district");
      return false;
    }
    if (!data.wardId) {
      alert("Please choose ward");
      return false;
    }
    return true;
  }

  const end = () => {
    const data: Step1Data = {
      address: address,
      districtId: selectedDistrictId,
      familyName: familyName,
      firstName: firstName,
      gender: gender,
      inPersonCourseDeliver: inPersonCourseDeliver,
      onlineCourseDeliver: onlineCourseDeliver,
      password: password,
      provinceId: selectedProvinceId,
      wardId: selectedDistrictId,
      yearOfBirth: yearOfBirth,
      email: email,
      avatar: avatar
    }

    if (validateData(data)) {
      endStep(data);
    }
  }

  useEffect(() => {
    if (!provinces) {
      loadProvinces();
    }
  }, [provinces]);

  useEffect(() => {
    if (selectedProvinceId) {
      loadDistricts();
    }
  }, [selectedProvinceId]);

  useEffect(() => {
    if (selectedDistrictId) {
      loadWards();
    }
  }, [selectedDistrictId]);

  return (
    <div className={`step${visible ? "" : " hidden"}`}>
      <div className="left">
        <div className="row">
          <div className="col">
            <label>* Your family name and first name (as in your ID)</label>
            <input maxLength={255} size={20}
                   value={familyName}
                   onChange={onFamilyNameChange}
                   placeholder="Input your family name"/> ,
            <input maxLength={255} size={20}
                   value={firstName}
                   onChange={onFirstNameChange}
                   placeholder="Input your first name"/>
          </div>
          <div className="col">
            <label>* Email</label>
            <input maxLength={255} size={25}
                   value={email} onChange={onEmailChange}
                   placeholder="Input your email"/>
          </div>
          <div className="col">
            <label>Year of birth</label>
            <select value={yearOfBirth} onChange={onYearOfBirthChange}>
              {
                getYearOfBirthSelectOptions()
              }
            </select>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <label>* Password (at least 8 characters, with letters and numbers)</label>
            <input type="password" maxLength={255} size={25}
                   value={password} onChange={onPasswordChange}
                   placeholder="Input your password"/>
          </div>
          <div className="col">
            <label>Password again</label>
            <input type="password" maxLength={255} size={25}
                   value={confirmPassword} onChange={onConfirmPasswordChange}
                   placeholder="Input your password again"/>
          </div>
          <div className="col">
            <label>Gender</label>
            <select value={gender} onChange={onGenderChange}>
              <option value="MALE">Male</option>
              <option value="FEMALE">Female</option>
            </select>
          </div>
        </div>
        <hr/>
        <div className="row">
          <div className="title">Your address</div>
        </div>
        <div className="row">
          <div className="col">
            <label>Street address (house number, street name)</label>
            <input maxLength={255} size={25}
                   value={address} onChange={onAddressChange}
                   placeholder="Input your address"/>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <label>City</label>
            <select value={selectedProvinceId} onChange={onProvinceChange}>
              <option value={0}>Choose city</option>
              {
                provinces && provinces.data.map((province, index) => (
                  <option value={province.id} key={index}>{province.name}</option>
                ))
              }
            </select>
          </div>

          <div className="col">
            <label>District</label>
            <select value={selectedDistrictId} onChange={onDistrictChange}>
              <option value={0}>Choose district</option>
              {
                districts && districts.data.map((district, index) => (
                  <option value={district.id} key={index}>{district.name}</option>
                ))
              }
            </select>
          </div>

          <div className="col">
            <label>Ward</label>
            <select value={selectedWardId} onChange={onWardChange}>
              <option value={0}>Choose ward</option>
              {
                wards && wards.data.map((ward, index) => (
                  <option value={ward.id} key={index}>{ward.name}</option>
                ))
              }
            </select>
          </div>
        </div>
        <hr/>
        <div className="row">
          <div className="title">You can deliver classes in</div>
        </div>
        <div className="row">
          <div className="col inline">
            <input type="checkbox" checked={onlineCourseDeliver} onChange={onOnlineCourseDeliverChange}/>
            <label>Online Courses</label>
          </div>
          <div className="col inline">
            <input type="checkbox" checked={inPersonCourseDeliver} onChange={onInPersonCourseDeliverChange}/>
            <label>In-person Courses</label>
          </div>
          <div className="col">
          </div>
        </div>
        <div className="row">
          <button className="btn-next" onClick={() => end()}>Next</button>
        </div>
      </div>
      <div className="right">
        <div className="row">
          <div className="col">
            <label>Your photo</label>
            <input type="file" onChange={onAvatarChange} multiple={false}/>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Step1;