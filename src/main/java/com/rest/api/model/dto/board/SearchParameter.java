package com.rest.api.model.dto.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchParameter {
    private int start;
    private int end;
    private String keyword;

    @Override
    public String toString() {
        return "SearchParameter{" +
                "start=" + start +
                ", end=" + end +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
