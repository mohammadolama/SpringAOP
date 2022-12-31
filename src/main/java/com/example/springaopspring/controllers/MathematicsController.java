package com.example.springaopspring.controllers;

import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.dto.Response;
import com.example.springaopspring.models.dto.SuccessFulResponseDto;
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

    @GetMapping("api/v1/getResultWithId")
    public Response getWithId(int id){
        return daoService.getResponseWithId(id);
    }
}
