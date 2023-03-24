package ru.juniorhub.projectapp.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.model.Project;
import ru.juniorhub.projectapp.repository.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Mono<Project> save(Project project) {
        return projectRepository.save(project);
    }

    public Mono<Project> findProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Mono<Project> findProjectByName(String name) {
        return projectRepository.findByProjectName(name);
    }

    public Mono<Project> findProjectByDescription(String description) {
        return projectRepository.findByProjectDescription(description);
    }

    public Mono<Project> update() {
        return null; //TODO
    }

    public Mono<Void> deleteProjectById(Long id) {
        return projectRepository.deleteById(id);
    }
}
