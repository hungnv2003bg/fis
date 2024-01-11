import React, {BaseSyntheticEvent, Fragment, useEffect, useState} from "react";
import {CourseService} from "../../../services/course/course.service";
import {CourseGroupsResponse} from "../../../services/course/response/CourseGroupsResponse";

export interface Step2Data {
  courseCategoryIds: string;
}

interface IProps {
  endStep: (data: Step2Data) => void;
  visible: boolean;
}

const Step2 = ({endStep, visible}: IProps) => {

  const [courseGroups, setCourseGroups] = useState<CourseGroupsResponse>();
  const [courseGroupCategories, setCourseGroupCategories] = useState<object>();
  const [courseCategoryIds, setCourseCategoryIds] = useState<string>();

  const loadCourseGroups = () => {
    CourseService.getCourseGroups().then(res => {
      setCourseGroups(res.data);
    });
  }

  const loadCourseGroupCategories = () => {
    const courseGroupCategories = {};

    const promiseArray = [];

    courseGroups.data.forEach((courseGroup) => {
      promiseArray.push(CourseService.getCourseCategories(courseGroup.id));
    });

    Promise.all(promiseArray).then(values => {
      values.forEach((res, index) => {
        courseGroupCategories[`${courseGroups.data[index].id}`] = res.data.data;
      });

      setCourseGroupCategories(courseGroupCategories);
    });
  }

  const onCategoryChange = (e: BaseSyntheticEvent) => {
    let ids = courseCategoryIds ? courseCategoryIds.split(",") : [];
    const id = e.target.name;

    if (e.target.checked) {
      if (!ids.includes(id)) {
        ids.push(id);
      }
    } else {
      ids = ids.filter(i => i !== id);
    }

    setCourseCategoryIds(ids.join(","));
  }

  const validateData = (data: Step2Data) => {
    if (!data.courseCategoryIds) {
      alert("Please choose the interest")
      return false;
    }
    return true;
  }

  const end = () => {
    const data: Step2Data = {
      courseCategoryIds: courseCategoryIds
    }

    if (validateData(data)) {
      endStep(data);
    }
  }

  useEffect(() => {
    if (!courseGroups) {
      loadCourseGroups();
    } else {
      loadCourseGroupCategories();
    }
  }, [courseGroups])

  return (
    <div className={`step${visible ? "" : " hidden"}`}>
      <div className="left">
        <div className="row">
          <div className="title">What you are interested in learning?</div>
        </div>
        {
          courseGroups && courseGroupCategories &&
          courseGroups.data.map((courseGroup, index) => {
            return <Fragment key={index}>
              <div className="row">
                <div className="title">{courseGroup.courseGroupName}</div>
              </div>
              <div className="row">
                {
                  courseGroupCategories[`${courseGroup.id}`].map((courseCategory, index) => {
                    return <div className="col inline" key={index}>
                      <input type="checkbox" name={courseCategory.id} onChange={onCategoryChange}/>
                      <label>{courseCategory.courseCategoryName}</label>
                    </div>
                  })
                }
              </div>
              <hr/>
            </Fragment>
          })
        }
        <div className="row">
          <button className="btn-next" onClick={() => end()}>Next</button>
        </div>
      </div>
    </div>
  );
}

export default Step2;