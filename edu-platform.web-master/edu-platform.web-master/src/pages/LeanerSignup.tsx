import React, {useState} from "react";
import SignupStepWizard from "../components/SignupStepWizard";
import Step1, {Step1Data} from "../components/SignupStepWizard/Learner/Step1";
import Step2, {Step2Data} from "../components/SignupStepWizard/Learner/Step2";
import Step3, {Step3Data} from "../components/SignupStepWizard/Learner/Step3";
import Step4, {Step4Data} from "../components/SignupStepWizard/Learner/Step4";
import Step5, {Step5Data} from "../components/SignupStepWizard/Learner/Step5";
import LoadingScreen from "../components/LoadingScreen";
import {LearnerRegisterRequest} from "../services/learner/request/LearnerRegisterRequest";
import {LearnerService} from "../services/learner/learner.service";
import {useNavigate} from "react-router-dom";
import {LearnerMappingRequest} from "../services/learner/request/LearnerMappingRequest";
import {LearnerActiveRequest} from "../services/learner/request/LearnerActiveRequest";
import {LearnerConfirmMappingRequest} from "../services/learner/request/LearnerConfirmMappingRequest";

const LeanerSignup = () => {

  const [stepSignUp, setStepSignup] = useState<number>(1);
  const [loading, setLoading] = useState<boolean>(false);
  const [registerRequest, setRegisterRequest] = useState<LearnerRegisterRequest>({
    avatar: undefined,
    districtId: 0,
    email: "",
    familyName: "",
    firstName: "",
    inPersonCourseInterest: false,
    onlineCourseInterest: false,
    password: "",
    provinceId: 0,
    wardId: 0,
    yearOfBirth: 0,
    courseCategoryIds: ""
  });
  const [isChildAccount, setIsChildAccount] = useState<boolean>(false);
  const [adultEmail, setAdultEmail] = useState<string>();
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
        request.yearOfBirth = (data as Step1Data).yearOfBirth;
        request.password = (data as Step1Data).password;
        request.provinceId = (data as Step1Data).provinceId;
        request.districtId = (data as Step1Data).districtId;
        request.wardId = (data as Step1Data).wardId;
        request.inPersonCourseInterest = (data as Step1Data).inPersonCourseInterest;
        request.onlineCourseInterest = (data as Step1Data).onlineCourseInterest;
        request.email = (data as Step1Data).email;
        request.avatar = (data as Step1Data).avatar;

        setRegisterRequest(request);
        handleNextStep();
        break;
      case 2:
        request.courseCategoryIds = (data as Step2Data).courseCategoryIds;

        setRegisterRequest(request);
        setLoading(true);
        LearnerService.signup(request).then(res => {
          localStorage.setItem("learner-id", res.data.data.id.toString());
          handleNextStep();
          setIsChildAccount(res.data.data.isChildAccount);
          setLoading(false);
        });
        break;
      case 3:
        const step3Data = data as Step3Data;

        const learnerId: number = Number(localStorage.getItem("learner-id"));
        setLoading(true);

        const learnerActiveRequest: LearnerActiveRequest = {
          activeCode: step3Data.activeCode
        };
        LearnerService.active(learnerId, learnerActiveRequest).then(res => {
          handleNextStep();
          setLoading(false);
        });
        break;
      case 4:
        const step4Data = data as Step4Data;
        if (isChildAccount) {
          setLoading(true);

          const learnerConfirmMappingRequest: LearnerConfirmMappingRequest = {
            adultAccountEmail: adultEmail,
            id: Number(localStorage.getItem("learner-id")),
            mappingCode: step4Data.mappingCode
          }
          LearnerService.confirmMapping(learnerConfirmMappingRequest).then(res => {
            handleNextStep();
            setLoading(false);
          });
        } else {
          navigate("/login");
        }
        break;
      case 5:
        navigate("/login");
        break;
      default:
        break;
    }
  }

  const stepTitles = ["Basic information", "What inspires you?", "Confirm", "Complete!"];
  const stepTitlesChildAccount = ["Basic information", "What inspires you?", "Confirm", "Link parent", "Complete!"];

  const stepElements = <>
    <Step1 key={1} endStep={(data) => endStep(data)} visible={stepSignUp === 1}/>
    <Step2 key={2} endStep={(data) => endStep(data)} visible={stepSignUp === 2}/>
    <Step3 key={3} endStep={(data) => endStep(data)} visible={stepSignUp === 3}/>
    <Step5 key={5} endStep={(data) => endStep(data)} visible={stepSignUp === 4}/>
  </>;

  const stepElementsChildAccount = <>
    <Step1 key={1} endStep={(data) => endStep(data)} visible={stepSignUp === 1}/>
    <Step2 key={2} endStep={(data) => endStep(data)} visible={stepSignUp === 2}/>
    <Step3 key={3} endStep={(data) => endStep(data)} visible={stepSignUp === 3}/>
    <Step4 key={4} endStep={(data) => endStep(data)} visible={stepSignUp === 4}
           sendMapping={(email => sendMapping(email))}/>
    <Step5 key={5} endStep={(data) => endStep(data)} visible={stepSignUp === 5}/>
  </>;

  const sendMapping = (email: string) => {
    setAdultEmail(email);
    setLoading(true);

    const learnerMappingRequest: LearnerMappingRequest = {
      adultAccountEmail: email,
      id: Number(localStorage.getItem("learner-id"))
    }

    LearnerService.sendMapping(learnerMappingRequest).then(res => {
      setLoading(false);
    });
  }

  return (
    <>
      <SignupStepWizard titles={isChildAccount ? stepTitlesChildAccount : stepTitles}
                        elements={isChildAccount ? stepElementsChildAccount : stepElements}
                        currentStep={stepSignUp}
                        handleNextStep={handleNextStep}/>
      {loading && <LoadingScreen/>}
    </>
  );
}

export default LeanerSignup;