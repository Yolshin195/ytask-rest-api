package com.yolshin.ytask.controller;

import com.yolshin.ytask.model.dto.LoginRequest;
import com.yolshin.ytask.model.dto.UserDataDTO;
import com.yolshin.ytask.model.dto.UserResponseDTO;
import com.yolshin.ytask.model.entity.AppUser;
import com.yolshin.ytask.model.entity.AppRole;
import com.yolshin.ytask.model.entity.AppUserRole;
import com.yolshin.ytask.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
@Tag(name = "Task REST API operations")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signin")
    public String login(@RequestBody LoginRequest loginRequest) {
        return userService.signin(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserDataDTO user) {
        AppUser appUser = modelMapper.map(user, AppUser.class);
        appUser.setAppRoles(List.of(AppUserRole.builder().appRole(AppRole.ROLE_ADMIN.name()).build()));

        return userService.signup(appUser);
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDTO search(@PathVariable String username) {
        return modelMapper.map(userService.search(username), UserResponseDTO.class);
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public UserResponseDTO whoami(HttpServletRequest req) {
        return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }

}
