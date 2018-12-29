package com.student.integration.mappers;

import com.student.integration.model.Group;
import com.student.integration.model.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupMapper {
    void createGroup(@Param("groupName") String groupName, @Param("semesterId") Long semesterId, @Param("createUserId") Long createUserId);
    List<Group> getUsersGroups(@Param("userId") Long userId);
}
