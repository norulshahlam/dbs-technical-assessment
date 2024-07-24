package com.dbs.dbs_technical_assessment.response;

import com.dbs.dbs_technical_assessment.enums.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyResponse<T> {


    private ResponseStatus status;
    private T data;
    private String errorMessage;

    public static <T> MyResponse successResponse(T data) {
        return MyResponse.builder()
                .status(ResponseStatus.SUCCESS)
                .data(data)
                .build();
    }

    public static <T> MyResponse failureResponse(T data, String errorMessage) {
        return MyResponse.builder()
                .status(ResponseStatus.FAILURE)
                .data(data)
                .errorMessage(errorMessage)
                .build();
    }

    public static MyResponse failureResponse(String errorMessage) {
        return MyResponse.builder()
                .status(ResponseStatus.FAILURE)
                .errorMessage(errorMessage)
                .build();
    }
}
