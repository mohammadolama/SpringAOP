package com.example.springaopspring.controllers;

import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.dto.ResponseBodyDto;
import com.example.springaopspring.models.entities.RequestBodyEntity;
import com.example.springaopspring.models.entities.ResponseBodyEntity;
import com.example.springaopspring.services.MathService;
import com.example.springaopspring.services.impl.BasicMathServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MathematicsController {

    private final MathService mathService;

    public MathematicsController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping("api/v1/doMath")
    public ResponseBodyDto doMath(@RequestBody RequestBodyDto requestBodyDto){
        return mathService.doMath(requestBodyDto);
    }

    @GetMapping("api/v1/getResultWithId")
    public ResponseBodyDto getWithId(int id){
        return mathService.getWithId(id);
    }
}
