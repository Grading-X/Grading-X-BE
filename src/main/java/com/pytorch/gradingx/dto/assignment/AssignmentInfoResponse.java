package com.pytorch.gradingx.dto.assignment;

import java.time.LocalDateTime;
import java.util.List;

public class AssignmentInfoResponse {
    public long id;
    public String name;
    public String description;
    public LocalDateTime startTime;
    public LocalDateTime endTime;

    public List<QuestionElement> questions;

    class QuestionElement {
        public long id;
        public int index;
        public String query;
        public int weightage;
    }
}
