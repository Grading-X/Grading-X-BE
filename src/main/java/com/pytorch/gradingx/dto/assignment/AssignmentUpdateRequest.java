package com.pytorch.gradingx.dto.assignment;

import java.time.LocalDateTime;

public class AssignmentUpdateRequest {
    public long id;
    public String name;
    public String description;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
}
