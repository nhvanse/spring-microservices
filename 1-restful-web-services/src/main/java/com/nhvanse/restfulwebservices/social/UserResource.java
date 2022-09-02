package com.nhvanse.restfulwebservices.social;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    private final UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/{id}")
    public User findOneUser(@PathVariable long id) {
        return userDaoService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        // location will appear in response 's header
        return ResponseEntity.created(location).build();
    }
}
