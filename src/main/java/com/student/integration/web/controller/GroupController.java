package com.student.integration.web.controller;

import com.student.integration.model.Group;
import com.student.integration.model.GroupInfo;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.group.GroupService;
import com.student.integration.web.request.CreateGroupReq;
import com.student.integration.web.response.GroupEnterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/api/groups/new")
    public void createGroup(@RequestBody CreateGroupReq createGroupReq, @AuthenticationPrincipal SiUserDetails userDetails){
        groupService.createGroup(createGroupReq.getAcademyId(), createGroupReq.getDegreeId(), createGroupReq.getGroupName(), createGroupReq.getSemesterNo(), userDetails);
    }

    @GetMapping("/api/groups")
    public List<GroupInfo> getUsersGroups(@AuthenticationPrincipal SiUserDetails userDetails){
        return groupService.getUsersGroups(userDetails.getId());
    }

    @PostMapping("/api/groups/enter/{actionHash}")
    public GroupEnterResponse enterToGroup(@PathVariable String actionHash, @AuthenticationPrincipal SiUserDetails userDetails){
        Group group = groupService.addUserToGroup(actionHash, userDetails);
        return new GroupEnterResponse(group.getGroupName());
    }
}
