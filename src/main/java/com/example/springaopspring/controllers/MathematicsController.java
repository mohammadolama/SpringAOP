package com.example.springaopspring.controllers;

import com.example.springaopspring.models.dto.response.Message;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.services.DaoService;
import com.example.springaopspring.services.MathService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@SecurityRequirement(name = "javainuseapi")
public class MathematicsController {

    private final MathService mathService;

    private final DaoService daoService;

    public MathematicsController(MathService mathService, DaoService daoService) {
        this.mathService = mathService;
        this.daoService = daoService;
    }

    @PostMapping("postMath")
    public Message postMath(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody RequestBodyDto request) {
        return mathService.doMath(request);
    }

    @GetMapping("getResultById")
    public Message getResponseById(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, int id) {
        return daoService.getResponseWithId(id);
    }

    @GetMapping("getRequestById")
    public Message getRequestById(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, int id) {
        return daoService.getRequestWithId(id);
    }

    @DeleteMapping("deleteRequestById")
    public Message deleteRequestById(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, int id) {
        return daoService.deleteRequestById(id);
    }

    @DeleteMapping("deleteResponseById")
    public Message deleteResponseById(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, int id) {
        return daoService.deleteResponseById(id);
    }


    @PutMapping("updateRequestById")
    public Message updateRequestById(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody RequestBodyDto requestBodyDto, int id) {
        return daoService.updateRequest(requestBodyDto, id);
    }

}
