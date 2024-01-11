package edu.platform.domains.staff.model.response;

import lombok.Data;

import java.util.List;

@Data
public class StaffGetListResponse {
    private Long total;
    private List<StaffResponse> list;
}
