package com.baiding;

import com.baiding.model.User;
import com.baiding.service.UserService;
import com.baiding.util.GlobalObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by BaiDing on 2017/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BaiDingTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRedis(){
        User user=userService.queryUserByName("ls");
        System.out.println(user.toString());
    }

    @Test
    public void testJson() throws IOException {
        String value="{\"id\":2,\"name\":\"ls\",\"age\":23}";
        System.out.println(GlobalObject.getJsonMapper().readValue(value,User.class));
    }
}
