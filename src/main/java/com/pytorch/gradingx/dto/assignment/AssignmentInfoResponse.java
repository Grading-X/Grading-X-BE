package com.pytorch.gradingx.dto.assignment;

import java.util.List;

public class AssignmentInfoResponse {
    public String name;
    public String description;
    public String startTime;
    public String endTime;

    public List<QuestionElement> questions;

    class QuestionElement {
        public long id;
        public int index;
        public String query;
        public int weightage;
    }
}
