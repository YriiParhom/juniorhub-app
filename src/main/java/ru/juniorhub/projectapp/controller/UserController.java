package ru.juniorhub.projectapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.dto.UserResponse;
import ru.juniorhub.projectapp.model.Users;
import ru.juniorhub.projectapp.sevice.UserService;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Users> addUser(@RequestBody Users users) {
        return userService.save(users);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserResponse> findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserResponse> findUserByUsername(@RequestParam String username) {
        return userService.findByName(username);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Users> updateUser(@PathVariable("id") Long id,
                                  @RequestBody Users user) {
        return userService.update(id, user);
    }
}
