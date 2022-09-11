package com.nhvanse.restfulwebservices.jpa;

import com.nhvanse.restfulwebservices.social.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
