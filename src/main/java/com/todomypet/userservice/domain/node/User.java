package com.todomypet.userservice.domain.node;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.time.LocalDateTime;

@Node("User")
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private String id;

    @Property("email")
    private String email;

    @Property("password")
    private String password;

    @Property("nickname")
    private String nickname;

    @Property("bio")
    private String bio;

    @Property("profilePicUrl")
    private String profilePicUrl;

    @Property("oauthKey")
    private String oauth_key;

    @Property("personalCode")
    private String personalCode;

    @Property("petCount")
    private Integer petCount;

    @Property("achCount")
    private Integer achCount;

    @Property("attendCount")
    private Integer attendCount;

    @Property("petEvolveCount")
    private Integer petEvolveCount;

    @Property("petCompleteCount")
    private Integer petCompleteCount;

    @Property("attendContinueCount")
    private Integer attendContinueCount;

    @Property("friendCount")
    private Integer friendCount;

    @Property("protected")
    private Boolean Protected;

    @Property("cratedAt")
    private LocalDateTime createdAt;

    @Property("deletedAt")
    private LocalDateTime deletedAt;

    @Property("refreshToken")
    private String refreshToken;

    @Property("deleted")
    private Boolean deleted;
}
