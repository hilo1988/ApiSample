package com.yoidukigembu.apisample.condition;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchCondition implements Serializable {

    private static final long serialVersionUID = -2405065196624545618L;

    private String name;

    private Integer lowerAge;

    private Integer upperAge;
}
