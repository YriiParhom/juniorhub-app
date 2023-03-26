package ru.juniorhub.projectapp.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.dto.UserResponse;
import ru.juniorhub.projectapp.exceptions.UserNotFoundException;
import ru.juniorhub.projectapp.model.Users;
import ru.juniorhub.projectapp.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService {

    private final String EXCEPTION_MSG = "User does not exist";
    private final UserRepository userRepository;

    public Mono<UserResponse> findById(Long id) {
        return userRepository.findUsersById(id)
                .switchIfEmpty(Mono.error(() -> new UserNotFoundException(EXCEPTION_MSG)));
    }

    public Flux<UserResponse> findByName(String username) {
        return userRepository.findByUsername(username)
                .switchIfEmpty(Mono.error(() -> new UserNotFoundException(EXCEPTION_MSG)));
    }

    public Mono<Users> save(Users user) {
        return userRepository.save(user);
    }

    public Mono<Users> update(Long id, Users user) {
        return userRepository.findById(id)
                .flatMap(foundUser -> {
                    foundUser.setUsername(user.getUsername());
                    foundUser.setPhoneNumber(user.getPhoneNumber());
                    foundUser.setTeamId(user.getTeamId());
                    return userRepository.save(foundUser);
                })
                .switchIfEmpty(Mono.error(() -> new UserNotFoundException(EXCEPTION_MSG)));
    }

    public Mono<Void> delete(Long id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new UserNotFoundException(EXCEPTION_MSG)))
                .flatMap(userRepository::delete);
    }
}
