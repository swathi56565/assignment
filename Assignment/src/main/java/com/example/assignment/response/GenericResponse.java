package com.example.assignment.response;

import java.util.List;


public class GenericResponse<T> extends BaseResponse {
    private List<T> dtoList;
    private T dto;

    private Long count;

    // Getters And Setters
    public List<T> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<T> dtoList) {
        this.dtoList = dtoList;
    }

    public T getDto() {
        return dto;
    }

    public void setDto(T dto) {
        this.dto = dto;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}