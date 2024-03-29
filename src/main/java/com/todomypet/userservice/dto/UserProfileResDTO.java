package com.todomypet.userservice.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserProfileResDTO {
    private String id;
    private String nickname;
    private String profilePicUrl;
    private String bio;
    private int collectionCount;
    private int achCount;
    private int friendCount;
}
