package com.nhvanse.restfulwebservices.social;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static long UsersCount = 0;
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(++UsersCount, "Van", LocalDate.now().minusYears(24)));
        users.add(new User(++UsersCount, "Vanh", LocalDate.now().minusYears(20)));
        users.add(new User(++UsersCount, "Vang", LocalDate.now().minusYears(28)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(long id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);

        return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user) {
        user.setId(++UsersCount);
        users.add(user);
        return user;
    }


}
