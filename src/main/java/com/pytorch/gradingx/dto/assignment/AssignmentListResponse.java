package com.pytorch.gradingx.dto.assignment;

import java.time.LocalDateTime;
import java.util.List;

public class AssignmentListResponse {
    public List<AssignmentElement> assignments;

    class AssignmentElement {
        public long id;
        public String name;
        public LocalDateTime startTime;
        public LocalDateTime endTime;
    }
}
