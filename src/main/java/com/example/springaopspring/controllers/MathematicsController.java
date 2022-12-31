package com.example.springaopspring.controllers;

import com.example.springaopspring.models.dto.Message;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.Response;
import com.example.springaopspring.models.dto.response.SuccessFulResponseDto;
import com.example.springaopspring.services.DaoService;
import com.example.springaopspring.services.MathService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class MathematicsController {

    private final MathService mathService;

    private final DaoService daoService;

    public MathematicsController(MathService mathService, DaoService daoService) {
        this.mathService = mathService;
        this.daoService = daoService;
    }

    @PostMapping("doMath")
    public Message doMath(@RequestBody RequestBodyDto requestBodyDto){
        return mathService.doMath(requestBodyDto);
    }

    @GetMapping("getResultById")
    public Message getResponseById(int id){
        return daoService.getResponseWithId(id);
    }

    @GetMapping("getRequestById")
    public Message getRequestById(int id){
        return daoService.getRequestWithId(id);
    }

    @DeleteMapping("deleteRequestById")
    public Message deleteRequestById(int id){
        return daoService.deleteRequestById(id);
    }

    @DeleteMapping("deleteResponseById")
    public Message deleteResponseById(int id){
        return daoService.deleteResponseById(id);
    }


    @PutMapping("updateRequestById")
    public Message updateRequestById(@RequestBody RequestBodyDto requestBodyDto , int id){
        return daoService.updateRequest(requestBodyDto , id);
    }

}
