package com.yoidukigembu.apisample.builder.impl;

import com.yoidukigembu.apisample.builder.SqlBuilder;
import com.yoidukigembu.apisample.condition.SearchCondition;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PeopleSearchSqlBuilder implements SqlBuilder {

    private final SearchCondition condition;

    @Override
    public SqlCondition build() {

        StringBuilder sql = new StringBuilder("SELECT * FROM person ");

        List<String> queries = new ArrayList<>();
        List<Object> params = new ArrayList<>();

        if (StringUtils.isNotBlank(condition.getName())) {
            queries.add(" (first_name LIKE ? OR last_name LIKE ?) ");
            final String name = String.format("%%%s%%", condition.getName());
            params.add(name);
            params.add(name);
        }

        if (condition.getLowerAge() != null) {
            queries.add(" age >= ? ");
            params.add(condition.getLowerAge());
        }

        if (condition.getUpperAge() != null) {
            queries.add(" age <= ? ");
            params.add(condition.getUpperAge());
        }

        if (queries.isEmpty()) {
            return new SqlCondition(sql, params);
        }

        StringBuilder where = new StringBuilder();

        queries.forEach(q -> {
            if (where.length() > 0) {
                where.append(" AND ");
            }
            where.append(q);
        });

        sql.append(" WHERE ")
                .append(where);
        return new SqlCondition(sql, params);
    }
}
