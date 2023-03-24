package ru.juniorhub.projectapp.repository;

import lombok.NonNull;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.model.Project;

@Repository
public interface ProjectRepository extends ReactiveCrudRepository<Project, Long> {

    Mono<Project> findByProjectName(String projectName);

    Mono<Project> findByProjectDescription(String description);

    @Transactional
    @NonNull
    Mono<Void> deleteById(@NonNull Long id);
}
