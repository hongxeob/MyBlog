package com.project.myblog.controller.api;

import com.project.myblog.config.auth.PrincipalDetails;
import com.project.myblog.dto.request.UserSaveRequestDto;
import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import com.project.myblog.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminApiController {
    private final AdminService adminService;
    @PutMapping("/admin/manage/member/edit/{id}")
    public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody UserSaveRequestDto userSaveRequestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User user = principalDetails.getUser();
        if (user.getRole() == RoleType.ADMIN) {
            adminService.updateRole(id, userSaveRequestDto);
            return new ResponseEntity<>(1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(1, HttpStatus.BAD_REQUEST);
        }
    }
}
