package com.example.springaopspring.services.impl;

import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.ErrorMessage;
import com.example.springaopspring.models.dto.response.Message;
import com.example.springaopspring.models.dto.response.ResponseMessage;
import com.example.springaopspring.models.dto.response.UpdateRequestMessage;
import com.example.springaopspring.services.DaoService;
import com.example.springaopspring.services.MathService;
import com.example.springaopspring.utils.JwtExtractor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class BasicMathServiceImpl implements MathService {

    private final DaoService daoService;



    final ArrayList<String> possibleOperations = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public BasicMathServiceImpl(DaoService daoService) {
        this.daoService = daoService;
    }

    public double calculate(double a, double b , String operation){
        return switch (operation) {
            case "+" -> a + b;
            case "*" -> a * b;
            case "/" -> a / b;
            case "-", default -> a - b;
        };
    }

    public ResponseMessage doMath(RequestBodyDto requestBodyDto, String token) {
        ResponseMessage responseBodyDto = new ResponseMessage();
        String username = JwtExtractor.username(token);
        if (possibleOperations.contains(requestBodyDto.getOperation())) {
            responseBodyDto.setStatus("OK");
            responseBodyDto.setMessage("Your Operation was successful.");
            responseBodyDto.setResult(calculate(requestBodyDto.getFirstNumber() , requestBodyDto.getSecondNumber() , requestBodyDto.getOperation()));
        } else {
            responseBodyDto.setStatus("ERROR");
            responseBodyDto.setMessage("Some error occurred.");
            responseBodyDto.setResult(Double.MIN_VALUE);
        }
        int i = daoService.saveRequest(requestBodyDto , username);
        int i1 = daoService.saveResponse(responseBodyDto , i , username);
        responseBodyDto.setRequestId(i);
        responseBodyDto.setResponseId(i1);
        return responseBodyDto;
    }

    @Override
    public Message updateRequest(RequestBodyDto requestBodyDto, String token, int id) {
        final boolean[] updated = {false};
        double calculate = calculate(requestBodyDto.getFirstNumber(), requestBodyDto.getSecondNumber(), requestBodyDto.getOperation());

        Message message = daoService.updateRequest(requestBodyDto, id);
        Message message1 = daoService.updateResponse(calculate, id);
        return message;
    }

}
