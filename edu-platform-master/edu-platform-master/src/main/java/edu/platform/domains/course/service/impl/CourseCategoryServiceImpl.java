package edu.platform.domains.course.service.impl;

import edu.platform.domains.course.mapper.CourseCategoryMapper;
import edu.platform.domains.course.model.response.CourseCategoryResponse;
import edu.platform.domains.course.repository.CourseCategoryRepository;
import edu.platform.domains.course.service.CourseCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseCategoryServiceImpl implements CourseCategoryService {

    private CourseCategoryRepository courseCategoryRepository;
    private CourseCategoryMapper courseCategoryMapper;

    @Override
    public List<CourseCategoryResponse> getCourseCategories(Long courseGroupId) {
        return courseCategoryRepository.findAllByCourseGroupId(courseGroupId)
                .stream()
                .map(courseCategoryMapper::to)
                .collect(Collectors.toList());
    }
}
