import http from "./course.api";
import {CourseGroupsResponse} from "./response/CourseGroupsResponse";
import {CourseCategoriesResponse} from "./response/CourseCategoriesResponse";

const getCourseGroups = () => {
  return http.get<CourseGroupsResponse>(`/courses/groups`);
}

const getCourseCategories = (courseGroupId: number) => {
  return http.get<CourseCategoriesResponse>(`/courses/categories`, {
    params: {
      'course_group_id': courseGroupId
    }
  });
}

export const CourseService = {
  getCourseGroups,
  getCourseCategories
}