import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import SignupStepWizard from "../components/SignupStepWizard";
import Step1, {Step1Data} from "../components/SignupStepWizard/Instructor/Step1";
import Step2, {Step2Data} from "../components/SignupStepWizard/Instructor/Step2";
import Step3, {Step3Data} from "../components/SignupStepWizard/Instructor/Step3";
import Step4, {Step4Data} from "../components/SignupStepWizard/Instructor/Step4";
import Step5, {Step5Data} from "../components/SignupStepWizard/Instructor/Step5";
import {InstructorService} from "../services/instructor/instructor.service";
import {InstructorRegisterRequest} from "../services/instructor/request/InstructorRegisterRequest";
import LoadingScreen from "../components/LoadingScreen";

const InstructorSignup = () => {

  const [stepSignUp, setStepSignup] = useState<number>(1);
  const [registerRequest, setRegisterRequest] = useState<InstructorRegisterRequest>({
    address: "",
    courseCategoryIds: "",
    districtId: 0,
    email: "",
    familyName: "",
    firstName: "",
    gender: "",
    inPersonCourseDeliver: false,
    onlineCourseDeliver: false,
    password: "",
    provinceId: 0,
    wardId: 0,
    yearOfBirth: 0,
    idPassport: undefined,
    diploma: undefined,
    certificates: undefined,
    avatar: undefined
  });
  const [loading, setLoading] = useState<boolean>(false);

  const navigate = useNavigate();

  const handleNextStep = () => {
    setStepSignup(stepSignUp + 1);
  }

  const endStep = (data: Step1Data | Step2Data | Step3Data | Step4Data | Step5Data) => {
    const request = registerRequest;
    switch (stepSignUp) {
      case 1:
        request.familyName = (data as Step1Data).familyName;
        request.firstName = (data as Step1Data).firstName;
        request.gender = (data as Step1Data).gender;
        request.yearOfBirth = (data as Step1Data).yearOfBirth;
        request.password = (data as Step1Data).password;
        request.address = (data as Step1Data).address;
        request.provinceId = (data as Step1Data).provinceId;
        request.districtId = (data as Step1Data).districtId;
        request.wardId = (data as Step1Data).wardId;
        request.inPersonCourseDeliver = (data as Step1Data).inPersonCourseDeliver;
        request.onlineCourseDeliver = (data as Step1Data).onlineCourseDeliver;
        request.email = (data as Step1Data).email;
        request.avatar = (data as Step1Data).avatar;

        setRegisterRequest(request);
        handleNextStep();
        break;
      case 2:
        request.courseCategoryIds = (data as Step2Data).courseCategoryIds;

        setRegisterRequest(request);
        handleNextStep();
        break;
      case 3:
        request.diploma = (data as Step3Data).diploma;
        request.idPassport = (data as Step3Data).idPassport;
        request.certificates = (data as Step3Data).certificates;

        setRegisterRequest(request);
        setLoading(true);
        InstructorService.signup(registerRequest).then(res => {
          localStorage.setItem("instructor-id", res.data.data.id.toString());
          handleNextStep();
          setLoading(false);
        });
        break;
      case 4:
        const step4Data = data as Step4Data;
        const instructorId: number = Number(localStorage.getItem("instructor-id"));

        setLoading(true);
        InstructorService.active(instructorId, {activeCode: step4Data.activeCode}).then(res => {
          handleNextStep();
          setLoading(false);
        });
        break;
      case 5:
        navigate("/login");
        break;
      default:
        break;
    }
  }

  const stepTitles = ["Basic information", "Your subjects", "Certificates", "Confirm", "Complete!"];

  const stepElements = <>
    <Step1 key={1} endStep={(data) => endStep(data)} visible={stepSignUp === 1}/>
    <Step2 key={2} endStep={(data) => endStep(data)} visible={stepSignUp === 2}/>
    <Step3 key={3} endStep={(data) => endStep(data)} visible={stepSignUp === 3}/>
    <Step4 key={4} endStep={(data) => endStep(data)} visible={stepSignUp === 4}/>
    <Step5 key={5} endStep={(data) => endStep(data)} visible={stepSignUp === 5}/>
  </>

  return (
    <>
      <SignupStepWizard titles={stepTitles}
                        elements={stepElements}
                        currentStep={stepSignUp}
                        handleNextStep={handleNextStep}/>
      {
        loading && <LoadingScreen/>
      }
    </>
  );
}

export default InstructorSignup;