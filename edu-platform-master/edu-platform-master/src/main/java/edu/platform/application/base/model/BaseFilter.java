package edu.platform.application.base.model;

import lombok.Data;

@Data
public class BaseFilter {
    private int page = 0;
    private int size = 10;
}
