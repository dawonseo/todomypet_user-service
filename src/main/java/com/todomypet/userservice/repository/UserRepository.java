package com.todomypet.userservice.repository;

import com.todomypet.userservice.domain.node.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@EnableNeo4jRepositories
@Repository
public interface UserRepository extends Neo4jRepository<User, String> {
    @Query("MATCH (user:User) WHERE user.id = $userId RETURN user")
    Optional<User> getOneUserById(String userId);

    @Query("MATCH (user:User) WHERE user.email = $email RETURN user")
    Optional<User> getOneUserByEmail(String email);

    @Query("MATCH (user:User) WHERE user.email = $checkedEmail RETURN count(user)")
    Integer getUserCountByEmail(String checkedEmail);

    @Query("MATCH (user:User{id:$userId}) SET user.refreshToken = $refreshToken")
    void setRefreshToken(String userId, String refreshToken);

    @Query("MATCH (user:User{personalCode:$personalCode}) RETURN user")
    Optional<User> getOneUserByPersonalCode(@Param("personalCode") String personalCode);

    @Query("MATCH (user:User{id:$userId}) WITH user " +
            "MATCH (user)-[:FRIEND]-(t:User) WITH t ORDER BY t.nickname " +
            "RETURN collect(t)")
    List<User> getFriendListByUserId(String userId);

    @Query("MATCH (user:User{id:$userId}) SET user.friendCount = user.friendCount + 1")
    void increaseFriendCount(String userId);

    @Query("MATCH (user:User{id:$userId}) SET user.friendCount = user.friendCount - 1")
    void decreaseFriendCount(String userId);

    @Query("MATCH (user:User{id:$userId}) SET user.deleted = true, user.deletedAt = $deletedAt")
    void deleteAccount(String userId, LocalDateTime deletedAt);
}
