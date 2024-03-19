package com.pytorch.gradingx.dto.objection;

import java.util.List;

public class ObjectionListResponse {
    List<ObjectionElement> objections;

    class ObjectionElement {
        public long id;
        public long questionId;
        public String guestEmail;
        public String title;
        public String content;
    }
}
