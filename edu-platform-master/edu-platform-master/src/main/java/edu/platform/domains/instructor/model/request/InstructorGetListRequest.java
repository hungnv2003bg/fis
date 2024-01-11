package edu.platform.domains.instructor.model.request;

import lombok.Data;

@Data
public class InstructorGetListRequest {
    private int page;
    private int size;
}
