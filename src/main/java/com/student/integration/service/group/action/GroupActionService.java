package com.student.integration.service.group.action;

import com.student.integration.model.Group;
import com.student.integration.model.GroupAction;

public interface GroupActionService {
    GroupAction createRecruitmentAction(Group group);
    Group getGroup(String actionHash);
}
