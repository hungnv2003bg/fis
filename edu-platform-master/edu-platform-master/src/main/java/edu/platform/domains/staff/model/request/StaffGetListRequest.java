package edu.platform.domains.staff.model.request;

import lombok.Data;

@Data
public class StaffGetListRequest {
    private int page;
    private int size;
}
