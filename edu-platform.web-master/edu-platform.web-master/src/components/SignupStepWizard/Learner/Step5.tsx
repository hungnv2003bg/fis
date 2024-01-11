import React from "react";

export interface Step5Data {

}

interface IProps {
  endStep: (data: Step5Data) => void;
  visible: boolean;
}

const Step5 = ({endStep, visible}: IProps) => {

  const end = () => {
    const data: Step5Data = {}

    endStep(data);
  }

  return (
    <div className={`step${visible ? "" : " hidden"}`}>
      <div className="left">
        <div className="row">
          <div className="title">Welcome!</div>
        </div>
        <hr/>
        <div className="row">
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam rhoncus massa eget mi consectetur egestas.
            Mauris at pharetra metus, nec luctus massa. Etiam ornare, arcu non blandit lacinia, mauris odio maximus
            ante, vitae facilisis dolor neque ac erat. Aenean dictum ac enim quis lacinia. Maecenas lacinia, magna ut
            hendrerit tempor, felis purus hendrerit leo, vel viverra ligula odio in nisi. Vivamus varius quis risus a
            sagittis. Donec sed fermentum tellus, a laoreet orci. Praesent posuere vehicula lacus et finibus. Praesent
            mattis ante quis iaculis vulputate. Morbi volutpat dignissim nunc, vitae iaculis nibh sodales ac. Aenean
            velit lorem, pellentesque a eros id, faucibus viverra nisi. Etiam id turpis at massa mattis varius nec a
            orci.
          </p>
        </div>
        <div className="row">
          <button className="btn-next" onClick={() => end()}>Start learning!</button>
        </div>
      </div>
    </div>
  );
}

export default Step5;