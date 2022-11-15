package com.yolshin.ytask.service;

import com.yolshin.ytask.exception.CustomException;
import com.yolshin.ytask.model.entity.AppUser;
import com.yolshin.ytask.security.JwtTokenProvider;
import com.yolshin.ytask.service.entity.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserEntityService userEntityService;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;

  public String signin(String username, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      return jwtTokenProvider.createToken(username, userEntityService.findByUsername(username).getAppRoles());
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public String signup(AppUser appUser) {
    if (!userEntityService.existsByUsername(appUser.getUsername())) {
      appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
      userEntityService.save(appUser);
      return jwtTokenProvider.createToken(appUser.getUsername(), appUser.getAppRoles());
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public void delete(String username) {
    userEntityService.deleteByUsername(username);
  }

  public AppUser search(String username) {
    AppUser appUser = userEntityService.findByUsername(username);
    if (appUser == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    }
    return appUser;
  }

  public AppUser whoami(HttpServletRequest req) {
    return userEntityService.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

  public String refresh(String username) {
    return jwtTokenProvider.createToken(username, userEntityService.findByUsername(username).getAppRoles());
  }

}
