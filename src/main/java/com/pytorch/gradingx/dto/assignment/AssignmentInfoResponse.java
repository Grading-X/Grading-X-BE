package com.pytorch.gradingx.dto.assignment;

import java.time.LocalDateTime;
import java.util.List;

public class AssignmentInfoResponse {
    public long id;
    public String name;
    public String description;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
}
