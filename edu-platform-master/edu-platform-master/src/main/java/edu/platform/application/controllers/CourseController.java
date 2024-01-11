package edu.platform.application.controllers;

import edu.platform.domains.course.model.response.CourseCategoryResponse;
import edu.platform.domains.course.model.response.CourseGroupResponse;
import edu.platform.domains.course.service.CourseCategoryService;
import edu.platform.domains.course.service.CourseGroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController extends BaseController {

    private CourseGroupService courseGroupService;
    private CourseCategoryService courseCategoryService;

    @GetMapping("/groups")
    public ResponseEntity getAllCourseGroup() {
        List<CourseGroupResponse> response = courseGroupService.getAllCourseGroupResponses();

        return success(response);
    }

    @GetMapping("/categories")
    public ResponseEntity getCourseCategories(@RequestParam(name = "course_group_id") Long courseGroupId) {
        List<CourseCategoryResponse> response = courseCategoryService.getCourseCategories(courseGroupId);

        return success(response);
    }
}
