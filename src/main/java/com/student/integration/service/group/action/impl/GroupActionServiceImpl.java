package com.student.integration.service.group.action.impl;

import com.google.common.hash.Hashing;
import com.student.integration.mappers.GroupMapper;
import com.student.integration.model.Group;
import com.student.integration.model.GroupAction;
import com.student.integration.service.group.action.GroupActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class GroupActionServiceImpl implements GroupActionService {
    private final GroupMapper groupMapper;

    @Override
    public GroupAction createRecruitmentAction(Group group) {
        String dataToBeHashed = group.getId().toString() + group.getCreateUserId().toString()+group.getSemesterId().toString();
        String actionHash = Hashing.sha256()
                .hashString(dataToBeHashed, StandardCharsets.UTF_8)
                .toString();
        GroupAction groupAction = GroupAction.builder()
                .groupId(group.getId())
                .isActive(true)
                .validFrom(new Date())
                .actionHash(actionHash)
                .build();
        groupMapper.createGroupAction(groupAction);
        return groupAction;
    }

    @Override
    public Group getGroup(String actionHash) {
        return groupMapper.getGroup(actionHash);
    }
}
