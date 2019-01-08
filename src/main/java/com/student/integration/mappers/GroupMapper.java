package com.student.integration.mappers;

import com.student.integration.model.Group;
import com.student.integration.model.GroupAction;
import com.student.integration.model.GroupInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupMapper {
    void createGroup(@Param("group") Group group);
    List<GroupInfo> getUsersGroups(@Param("userId") Long userId);
    void addUserToGroup(@Param("userId") Long userId, @Param("groupId") Long groupId);
    void createGroupAction(@Param("action")GroupAction groupAction);
    Group getGroup(@Param("actionHash")String actionHash);
    boolean isActionActive(@Param("actionHash")String actionHash);
    void updateGroup(@Param("group") Group group);
}
