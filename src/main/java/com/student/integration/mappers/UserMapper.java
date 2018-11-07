package com.student.integration.mappers;

import com.student.integration.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User getUser(@Param("id")Long id);

    void insertUser(@Param("user")User user);

    void updateUser(@Param("user")User user);

    void deleteUser(@Param("id")Long id);
}
