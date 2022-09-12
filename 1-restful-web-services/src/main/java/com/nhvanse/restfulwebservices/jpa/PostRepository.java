package com.nhvanse.restfulwebservices.jpa;

import com.nhvanse.restfulwebservices.social.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
