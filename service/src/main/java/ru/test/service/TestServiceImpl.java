package ru.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.dao.TestDao;

import java.util.List;

/**
 * Created by Denis on 04.06.2014.
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<String> getUsers() {
        return testDao.showUsers();
    }

    @Override
    public void removeUser(int userId) {
        testDao.removeUser(userId);
    }

    @Override
    public void removeUserWithException(int userId) {
        testDao.removeUser(userId);
        throw new RuntimeException("ololo");
    }
}
