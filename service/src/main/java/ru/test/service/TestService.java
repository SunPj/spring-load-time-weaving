package ru.test.service;

import java.util.List;

/**
 * Created by Denis on 04.06.2014.
 */
public interface TestService {
    String getUsers();
    void removeUser(int userId);
    void removeUserWithException(int userId);
    int getRandom();
    void userCacheEvict();
    void dataCacheEvict();
    int showUsers();
}
