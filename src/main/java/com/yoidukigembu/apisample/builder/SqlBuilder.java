package com.yoidukigembu.apisample.builder;

import com.yoidukigembu.apisample.builder.impl.PeopleSearchSqlBuilder;
import com.yoidukigembu.apisample.condition.SearchCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

public interface SqlBuilder {

    SqlCondition build();

    @Data
    class SqlCondition implements Serializable {

        private static final long serialVersionUID = -3509420362025846467L;

        private final String query;

        private final Object[] params;

        public SqlCondition(CharSequence sql, Collection<?> params) {
            this.query = sql.toString();
            this.params = params.toArray();
        }
    }

    static SqlBuilder getSearchCondition(SearchCondition condition) {
        return new PeopleSearchSqlBuilder(condition);
    }
}
