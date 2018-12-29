package com.student.integration.service.group.impl;

import com.student.integration.mappers.GroupMapper;
import com.student.integration.mappers.SemesterMapper;
import com.student.integration.model.Group;
import com.student.integration.model.Semester;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.group.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {
    private final GroupMapper groupMapper;
    private final SemesterMapper semesterMapper;

    @Override
    public void createGroup(Long academyId, Long degreeId, String groupName, Long semesterNo, SiUserDetails siUserDetails) {
        Long semesterId = semesterMapper.getSemesterId(degreeId, semesterNo);
        if(semesterId == null){
            log.error("Error while creating group. Semester with degreeId={} and semesterNo={} does not exists", degreeId, semesterNo);
            //TODO: use custom exception
            throw new IllegalArgumentException();
        }
        groupMapper.createGroup(groupName, semesterId, siUserDetails.getId());
    }

    @Override
    public List<Group> getUsersGroups(Long userId) {
        return groupMapper.getUsersGroups(userId);
    }
}
