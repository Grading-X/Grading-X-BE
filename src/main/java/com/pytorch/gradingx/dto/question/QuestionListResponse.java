package com.pytorch.gradingx.dto.question;

import java.util.List;

public class QuestionListResponse {
    public List<QuestionElement> questions;

    class QuestionElement {
        public long id;
        public int index;
        public String query;
        public int weightage;
    }
}
