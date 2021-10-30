package com.yefferson.taskmanagerback.util;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;
import com.yefferson.taskmanagerback.util.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class Health {
    @GetMapping
    private ResponseEntity<Response<String>> health() {
        return new ResponseEntity<>(Response.<String>builder()
                .data(ConstanstApiRest.HEALTH_MSG).build(), HttpStatus.OK);
    }
}
