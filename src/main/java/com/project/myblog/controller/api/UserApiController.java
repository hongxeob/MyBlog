package com.project.myblog.controller.api;

import com.project.myblog.dto.ResponseDto;
import com.project.myblog.dto.request.UserSaveRequestDto;
import com.project.myblog.dto.request.UserUpdateDto;
import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import com.project.myblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody @Valid UserSaveRequestDto userSaveRequestDto) {
        userSaveRequestDto.setRole(RoleType.USER);
        userService.join(userSaveRequestDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바 오브젝트를 JSON으로 변환하여 전송 (JACKSON)
    }


    @PutMapping("/user")
    public ResponseDto<Integer> update( @RequestBody UserUpdateDto userUpdateDto) {
        User user = userUpdateDto.toEntity();
        userService.update(user);
        // 세션등록
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}