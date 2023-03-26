package ru.juniorhub.projectapp.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.dto.UserResponse;
import ru.juniorhub.projectapp.model.Users;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Users, Long> {

    Flux<UserResponse> findByUsername(String username);

    Mono<UserResponse> findUsersById(Long id);
}
