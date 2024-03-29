package com.todomypet.userservice.service;

import com.todomypet.userservice.dto.MyPageResDTO;
import com.todomypet.userservice.dto.UserInfoResDTO;
import com.todomypet.userservice.dto.UserProfileResDTO;

public interface UserService {

    MyPageResDTO getMyPage(String userId);

    UserInfoResDTO getUserByPersonalCode(String personalCode);

    UserProfileResDTO getUserProfile(String targetId);
}
