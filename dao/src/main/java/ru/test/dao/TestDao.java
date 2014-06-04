package ru.test.dao;

import java.util.List;

/**
 * Created by Denis on 04.06.2014.
 */
public interface TestDao {
    void removeUser(int id);
    List<String> showUsers();
}
