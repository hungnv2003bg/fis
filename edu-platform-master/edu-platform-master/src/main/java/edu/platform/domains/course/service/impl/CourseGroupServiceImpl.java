package edu.platform.domains.course.service.impl;

import edu.platform.domains.course.mapper.CourseGroupMapper;
import edu.platform.domains.course.model.response.CourseGroupResponse;
import edu.platform.domains.course.repository.CourseGroupRepository;
import edu.platform.domains.course.service.CourseGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseGroupServiceImpl implements CourseGroupService {

    private CourseGroupRepository courseGroupRepository;
    private CourseGroupMapper courseGroupMapper;

    @Override
    public List<CourseGroupResponse> getAllCourseGroupResponses() {
        return courseGroupRepository.findAll()
                .stream()
                .map(courseGroupMapper::to)
                .collect(Collectors.toList());
    }
}
