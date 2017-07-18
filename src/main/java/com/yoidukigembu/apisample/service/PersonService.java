package com.yoidukigembu.apisample.service;

import com.yoidukigembu.apisample.builder.SqlBuilder;
import com.yoidukigembu.apisample.condition.SearchCondition;
import com.yoidukigembu.apisample.db.entity.PersonEntity;
import com.yoidukigembu.apisample.db.repository.PersonRepository;
import com.yoidukigembu.apisample.json.request.person.ResisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final JdbcTemplate jdbc;

    private final PersonRepository repository;

    public long register(ResisterRequest request) {
        PersonEntity entity = new PersonEntity();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity).getId();
    }

    public List<PersonEntity> search(SearchCondition condition) {
        SqlBuilder.SqlCondition sqlCondition = SqlBuilder.getSearchCondition(condition).build();
        RowMapper<PersonEntity> mapper = new BeanPropertyRowMapper<>(PersonEntity.class);
        return jdbc.query(sqlCondition.getQuery(), sqlCondition.getParams(), mapper);
    }

    public PersonEntity getDetail(long id) {
        return repository.findOne(id);
    }


}
