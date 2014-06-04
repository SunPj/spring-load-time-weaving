package ru.test.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDao {

    protected static final Log logger = LogFactory.getLog(AbstractDao.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected JdbcTemplate getJdbcTemplate() {
        return (JdbcTemplate)namedParameterJdbcTemplate.getJdbcOperations();
    }

    protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    protected <T extends Number> T generateId(String sequenceName, Class<T> resultType) {
        return getJdbcTemplate().queryForObject("select " + sequenceName + ".nextval from dual", resultType);
    }
}
