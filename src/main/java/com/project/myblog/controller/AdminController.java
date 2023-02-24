package com.project.myblog.controller;

import com.project.myblog.config.auth.PrincipalDetails;
import com.project.myblog.model.Board;
import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import com.project.myblog.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    //어드민 페이지
    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        User user = principalDetails.getUser();
        if (user.getRole() == RoleType.ADMIN) {
            return "/admin/adminPage";
        } else {
            return "redirect:/";
        }
    }
    //멤버 관리 페이지
    @GetMapping("/admin/manage/member")
    public String manageMember(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        User user = principalDetails.getUser();
        if (user.getRole() == RoleType.ADMIN) {
            List<User> allUsers = adminService.findAllUser();
            model.addAttribute("allUsers", allUsers);
            return "/admin/manageAllMember";
        }
        return "redirect:/";
    }

    //멤버 상세 관리 페이지
    @GetMapping("/admin/manage/member/{id}")
    public String manageMemberDetail(@PathVariable("id") Long id,
                                     @AuthenticationPrincipal PrincipalDetails principalDetails,
                                     Model model) {
        User user = principalDetails.getUser();
        if (user.getRole() == RoleType.ADMIN) {
            User findUser = adminService.findUserById(id);
            List<Board> allBoardByUser = adminService.findAllBoardByUser(findUser);
            model.addAttribute("user", findUser);
            model.addAttribute("boards", allBoardByUser);
            return "/admin/manageMemberDetail";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/admin/manage/visit")
    public String manageVisit(@AuthenticationPrincipal PrincipalDetails principalDetails,
                              Model model) {
        User user = principalDetails.getUser();
        if (user.getRole() == RoleType.ADMIN) {
            int totalViewCount = adminService.getTotalViewCount();
            int totalUserCount = adminService.getTotalUserCount();
            model.addAttribute("totalViewCount", totalViewCount);
            model.addAttribute("totalUserCount", totalUserCount);
            return "/admin/manageVisit";
        } else {
            return "redirect:/";
        }
    }

}
