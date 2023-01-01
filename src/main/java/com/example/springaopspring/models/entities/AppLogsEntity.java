package com.example.springaopspring.models.entities;


import com.example.springaopspring.models.dto.Message;
import com.example.springaopspring.models.dto.request.RequestBodyDto;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class AppLogsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String url;

    @Column(columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private RequestBodyDto requestBody;


    private int httpStatusCode;
    private LocalDateTime localDateTime;

    @Column(columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private Message responseBody;

    private String httpMethod;

    public AppLogsEntity() {
    }
}
