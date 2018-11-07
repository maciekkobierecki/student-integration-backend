package com.student.integration.mappers;

import com.student.integration.ApplicationTests;
import com.student.integration.model.Subject;
import com.student.integration.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperIT extends ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void checkValidityOfCrudOperations(){
        User user = new User();
        user.setEmail("email@email.com");
        user.setDisplayName("Macius");
        userMapper.insertUser(user);
        User result = userMapper.getUser(user.getId());
        userMapper.updateUser(result);
        userMapper.deleteUser(result.getId());
    }
}
