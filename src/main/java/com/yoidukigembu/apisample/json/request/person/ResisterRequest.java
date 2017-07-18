package com.yoidukigembu.apisample.json.request.person;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResisterRequest implements Serializable {
    private static final long serialVersionUID = -2020834622618495753L;

    private String firstName;

    private String lastName;

    private Integer age;
}
