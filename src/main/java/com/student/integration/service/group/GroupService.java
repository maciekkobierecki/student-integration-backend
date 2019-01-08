package com.student.integration.service.group;

import com.student.integration.model.Group;
import com.student.integration.model.GroupInfo;
import com.student.integration.security.SiUserDetails;

import java.util.List;

public interface GroupService {
    void createGroup(Long academyId, Long degreeId, String groupName, Long semesterNo, SiUserDetails userDetails);
    List<GroupInfo> getUsersGroups(Long userId);
    Group addUserToGroup(String actionHash, SiUserDetails userDetails);
}
