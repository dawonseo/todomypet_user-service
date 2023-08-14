package com.todomypet.userservice.repository;

import com.todomypet.userservice.domain.relationship.Friend;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends Neo4jRepository<Friend, Long> {
    @Query("MATCH (u:User) WITH u " +
            "MATCH (t:User) WHERE u.id = $userId AND t.id = $targetId " +
            "CREATE (u)-[:FRIEND]->(t)")
    void setFriendRelationshipBetweenUserAndUser(String userId, String targetId);

    @Query("MATCH (u:User{id:$userId}) WITH u " +
            "MATCH (u)-[friend:FRIEND]->(t:User{id:$targetId}) " +
            "DELETE friend")
    void deleteFriendRelationshipBetweenUserAndUser(String userId, String targetId);
}
