package edu.platform.domains.instructor.model.response;

import lombok.Data;

import java.util.List;

@Data
public class InstructorGetListResponse {
    private Long total;
    private List<InstructorResponse> list;
}
