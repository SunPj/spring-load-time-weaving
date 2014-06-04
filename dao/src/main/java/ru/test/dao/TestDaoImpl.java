package ru.test.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Denis on 04.06.2014.
 */
@Repository
public class TestDaoImpl extends AbstractDao implements TestDao {

    @Override
    public void removeUser(int id) {
        getJdbcTemplate().execute("DELETE FROM TABLE1 WHERE id = " + id);
    }

    @Override
    public List<String> showUsers() {
        return getJdbcTemplate().queryForList("SELECT name FROM TABLE1", String.class);
    }

}
