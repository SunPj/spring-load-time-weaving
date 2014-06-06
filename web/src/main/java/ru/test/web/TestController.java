package ru.test.web;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.test.service.TestService;

import java.util.Map;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/userlist")
    public String userList(Map<String, Object> model) {
        String st = ArrayUtils.toString(testService.getUsers());
        model.put("text", st);
        return "main";
    }

    @RequestMapping("/remove-user")
    public String removeUser(@RequestParam("userId") int userId, Map<String, Object> model) {
        testService.removeUser(userId);
        model.put("text", "Removed userid = "+userId);
        return "main";
    }

    @RequestMapping("/remove-user-ex")
    public String removeUserEx(@RequestParam("userId") int userId, Map<String, Object> model) {
        try {
            testService.removeUserWithException(userId);
        } catch (RuntimeException e){
            model.put("text", "Exception = "+e.getMessage());
        }

        return "main";
    }

    @RequestMapping("/random")
    public String random(Map<String, Object> model) {
        String s = new String();
        for (int i = 0; i< 100; i++){
            s = s + +testService.getRandom()+",   ";
        }
        model.put("text", "Random = "+s);

        return "main";
    }

    @RequestMapping({"/", "/home"})
    public String index(Map<String, Object> model) {
        model.put("text", "Home page!");
        return "main";
    }

    @RequestMapping("/user-cache-evict")
    public String userCacheEvict(Map<String, Object> model) {
        testService.userCacheEvict();
        model.put("text", "user cache evicted!");
        return "main";
    }

    @RequestMapping("/data-cache-evict")
    public String dataCacheEvict(Map<String, Object> model) {
        testService.dataCacheEvict();
        model.put("text", "data cache evicted!");
        return "main";
    }
}
