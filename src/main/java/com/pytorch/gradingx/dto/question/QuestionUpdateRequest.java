package com.pytorch.gradingx.dto.question;

import java.util.List;

public class QuestionUpdateRequest {
    public String query;
    public int index;
    public int weightage;

    public List<String> answers;
    public List<String> keywords;
}