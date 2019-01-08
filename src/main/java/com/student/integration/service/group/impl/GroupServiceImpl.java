package com.student.integration.service.group.impl;

import com.student.integration.mappers.GroupMapper;
import com.student.integration.mappers.SemesterMapper;
import com.student.integration.model.Group;
import com.student.integration.model.GroupAction;
import com.student.integration.model.GroupInfo;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.group.GroupService;
import com.student.integration.service.group.action.GroupActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {
    private final GroupActionService groupActionService;
    private final GroupMapper groupMapper;
    private final SemesterMapper semesterMapper;

    @Override
    @Transactional
    public void createGroup(Long academyId, Long degreeId, String groupName, Long semesterNo, SiUserDetails siUserDetails) {
        Long semesterId = semesterMapper.getSemesterId(degreeId, semesterNo);
        if (semesterId == null) {
            log.error("Error while creating group. Semester with degreeId={} and semesterNo={} does not exists", degreeId, semesterNo);
            //TODO: use custom exception
            throw new IllegalArgumentException();
        }
        Group newGroup = Group.builder()
                .groupName(groupName)
                .createUserId(siUserDetails.getId())
                .semesterId(semesterId)
                .build();
        groupMapper.createGroup(newGroup);
        GroupAction groupAction = groupActionService.createRecruitmentAction(newGroup);
        groupMapper.addUserToGroup(siUserDetails.getId(), newGroup.getId());
        newGroup.setRecruitmentActionId(groupAction.getId());
        groupMapper.updateGroup(newGroup);
    }

    @Override
    public List<GroupInfo> getUsersGroups(Long userId) {
        return groupMapper.getUsersGroups(userId);
    }

    @Override
    public Group addUserToGroup(String actionHash, SiUserDetails userDetails) {
        Group group = groupActionService.getGroup(actionHash);
        groupMapper.addUserToGroup(userDetails.getId(), group.getId());
        log.info("User {} added to group with groupId={}, groupName={}", userDetails.getEmail(), group.getId(), group.getGroupName());
        return group;
    }

}
