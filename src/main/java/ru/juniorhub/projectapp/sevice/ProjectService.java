package ru.juniorhub.projectapp.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.exceptions.ProjectNotFoundException;
import ru.juniorhub.projectapp.model.Project;
import ru.juniorhub.projectapp.repository.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final String EXCEPTION_MSG = "Project does not exist";
    private final ProjectRepository projectRepository;

    public Mono<Project> save(Project project) {
        return projectRepository.save(project);
    }

    public Mono<Project> findProjectById(Long id) {
        return projectRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ProjectNotFoundException(EXCEPTION_MSG)));
    }

    public Flux<Project> findProjectByName(String name) {
        return projectRepository.findByProjectName(name)
                .switchIfEmpty(Mono.error(() -> new ProjectNotFoundException(EXCEPTION_MSG)));
    }

    public Flux<Project> findProjectByDescription(String description) {
        return projectRepository.findByProjectDescription(description)
                .switchIfEmpty(Mono.error(() -> new ProjectNotFoundException(EXCEPTION_MSG)));
    }

    public Mono<Project> update(Long id, Project project) {
        return projectRepository.findById(id)
                .map(p -> project)
                .flatMap(projectRepository::save)
                .switchIfEmpty(Mono.error(() -> new ProjectNotFoundException(EXCEPTION_MSG)));
    }

    public Mono<Void> deleteProjectById(Long id) {
        return projectRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ProjectNotFoundException(EXCEPTION_MSG)))
                .flatMap(projectRepository::delete);
    }
}
