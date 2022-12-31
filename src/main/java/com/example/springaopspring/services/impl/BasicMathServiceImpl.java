package com.example.springaopspring.services.impl;

import com.example.springaopspring.models.dto.RequestBodyDto;
import com.example.springaopspring.models.dto.ResponseBodyDto;
import com.example.springaopspring.services.MathService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class BasicMathServiceImpl implements MathService {

    ArrayList<String> possibleOperations = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public ResponseBodyDto doMath(RequestBodyDto requestBodyDto) {
        ResponseBodyDto responseBodyDto = new ResponseBodyDto();

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
        return responseBodyDto;
    }
}
