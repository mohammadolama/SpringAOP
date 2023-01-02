package com.example.springaopspring.services.impl;

import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.ResponseMessage;
import com.example.springaopspring.services.DaoService;
import com.example.springaopspring.services.MathService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class BasicMathServiceImpl implements MathService {

    private final DaoService daoService;



    final ArrayList<String> possibleOperations = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public BasicMathServiceImpl(DaoService daoService) {
        this.daoService = daoService;
    }

    public ResponseMessage doMath(RequestBodyDto requestBodyDto) {
        ResponseMessage responseBodyDto = new ResponseMessage();

        if (possibleOperations.contains(requestBodyDto.getOperation())) {

            responseBodyDto.setStatus("OK");

            responseBodyDto.setMessage("Your Operation was successful.");
            switch (requestBodyDto.getOperation()) {
                case "+" ->
                        responseBodyDto.setResult(requestBodyDto.getFirstNumber() + requestBodyDto.getSecondNumber());
                case "*" ->
                        responseBodyDto.setResult(requestBodyDto.getFirstNumber() * requestBodyDto.getSecondNumber());
                case "-" ->
                        responseBodyDto.setResult(requestBodyDto.getFirstNumber() - requestBodyDto.getSecondNumber());
                case "/" ->
                        responseBodyDto.setResult(requestBodyDto.getFirstNumber() / requestBodyDto.getSecondNumber());
            }
        } else {
            responseBodyDto.setStatus("ERROR");
            responseBodyDto.setMessage("Some error occurred.");
            responseBodyDto.setResult(Double.MIN_VALUE);
        }
        int i = daoService.saveRequest(requestBodyDto);
        int i1 = daoService.saveResponse(responseBodyDto , i);
        responseBodyDto.setRequestId(i);
        responseBodyDto.setResponseId(i1);
        return responseBodyDto;
    }

}
