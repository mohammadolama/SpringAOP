package com.example.springaopspring.controllers;

import com.example.springaopspring.models.dto.Message;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.Response;
import com.example.springaopspring.models.dto.response.SuccessFulResponseDto;
import com.example.springaopspring.services.DaoService;
import com.example.springaopspring.services.MathService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MathematicsController {

    private final MathService mathService;

    private final DaoService daoService;

    public MathematicsController(MathService mathService, DaoService daoService) {
        this.mathService = mathService;
        this.daoService = daoService;
    }

    @PostMapping("api/v1/doMath")
    public SuccessFulResponseDto doMath(@RequestBody RequestBodyDto requestBodyDto){
        return mathService.doMath(requestBodyDto);
    }

    @GetMapping("api/v1/getResultById")
    public Message getResponseById(int id){
        return daoService.getResponseWithId(id);
    }

    @GetMapping("api/v1/getRequestById")
    public Message getRequestById(int id){
        return daoService.getRequestWithId(id);
    }

    @DeleteMapping("api/v1/deleteRequestById")
    public Message deleteRequestById(int id){
        return daoService.deleteRequestById(id);
    }

    @DeleteMapping("api/v1/deleteResponseById")
    public Message deleteResponseById(int id){
        return daoService.deleteResponseById(id);
    }


}
