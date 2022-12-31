package com.example.springaopspring.utils.Loader;

import com.example.springaopspring.dao.mapper.DomainMapper;
import com.example.springaopspring.dao.mapper.RequestMapper;
import com.example.springaopspring.dao.mapper.ResponseMapper;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.example.springaopspring.models.dto.response.SuccessFulResponseDto;
import com.example.springaopspring.models.entities.RequestBodyEntity;
import com.example.springaopspring.models.entities.ResponseBodyEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanProvider {

    @Bean
    public DomainMapper<RequestBodyDto , RequestBodyEntity> requestMapper(){
        return new RequestMapper();
    }

    @Bean
    public DomainMapper<SuccessFulResponseDto, ResponseBodyEntity> responseMapper(){
        return new ResponseMapper();
    }
}
