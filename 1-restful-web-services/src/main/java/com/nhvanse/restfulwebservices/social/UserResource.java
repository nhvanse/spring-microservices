package com.nhvanse.restfulwebservices.social;

import com.nhvanse.restfulwebservices.social.exception.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public EntityModel<User> findOneUser(@PathVariable long id) {
        User user = userDaoService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        // location will appear in response 's header
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userDaoService.deleteById(id);
    }
}
