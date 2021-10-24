package com.taskmanagerback.taskmanagerback.util.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class DefaultResponse<T> {
    @Builder.Default
    private String message = HttpStatus.OK.getReasonPhrase();
    @Builder.Default
    private Integer status = HttpStatus.OK.value();
    private List<String> errors;
}
