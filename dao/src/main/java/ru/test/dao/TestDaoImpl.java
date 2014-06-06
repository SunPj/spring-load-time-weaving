package ru.test.dao;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

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
    public String showUsers() {
        String users = ArrayUtils.toString(getJdbcTemplate().queryForList("SELECT name FROM TABLE1", String.class));

        return users + ":" + getCachedUsersCount();
    }

    @Override
    @Cacheable(value = "User")
     public int getCachedUsersCount(){
        int cnt = getJdbcTemplate().queryForInt("SELECT count(*)name FROM TABLE1");
        return cnt;
    }

    @Override
    public int getRealUsersCount(){
        int cnt = getJdbcTemplate().queryForInt("SELECT count(*)name FROM TABLE1");
        return cnt;
    }

    @Override
    @CacheEvict(value = "User", allEntries = true)
    public void userCacheEvict(){
    }

    @Override
    @CacheEvict(value = "PermanentData", allEntries = true)
    public void dataCacheEvict(){
    }

    @Override
    @Cacheable(value = "PermanentData")
    public int getRandom() {
        return new Random().nextInt();
    }
}
