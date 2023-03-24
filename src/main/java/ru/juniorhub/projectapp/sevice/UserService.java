package ru.juniorhub.projectapp.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.dto.UserResponse;
import ru.juniorhub.projectapp.model.Users;
import ru.juniorhub.projectapp.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    public Flux<UserResponse> findByName(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<Users> save(Users user) {
        return userRepository.save(user);
    }

    public Mono<Users> update(Users user, Long id) {
        return userRepository.findById(id)
                .map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalUser -> {
                    if(optionalUser.isPresent()) {
                        user.setPhoneNumber(user.getPhoneNumber());
                        user.setUsername(user.getUsername());
                        return userRepository.save(user);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> delete(Users user) {
        return userRepository.delete(user);
    }
}
