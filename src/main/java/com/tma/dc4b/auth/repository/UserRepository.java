package com.tma.dc4b.auth.repository;

import com.tma.dc4b.auth.domain.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UserRepository extends GraphRepository<User> {

  User findOneByUsername(@Param(value = "username") String username);
}
