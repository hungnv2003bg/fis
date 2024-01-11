import React from "react";
import "./style.scss";

interface IProps {
  titles: Array<string>;
  elements: JSX.Element;
  currentStep: number;
  handleNextStep: () => void;
}

const SignupStepWizard = ({titles, elements, currentStep = 1}: IProps) => {

  return (
    <div className="sign-up-step-wizard">
      <div className="step-header">
        {
          titles.map((title, index) => (
            <div key={index}>
              <span className={`step-title${index === currentStep - 1 ? " active" : ""}`}>{title}</span>
              <span>{index !== titles.length - 1 ? "..." : ""}</span>
            </div>
          ))
        }
      </div>
      <div className="step-content">
        {elements}
      </div>
    </div>
  );
}

export default SignupStepWizard;