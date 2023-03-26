package ru.juniorhub.projectapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.model.Project;
import ru.juniorhub.projectapp.sevice.ProjectService;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Project> createNewTeam(@RequestBody Project project) {
        return projectService.save(project);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Mono<Project> findProjectById(@PathVariable("id") Long id) {
        return projectService.findProjectById(id);
    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.FOUND)
    public Flux<Project> findProjectByName(@RequestParam String name) {
        return projectService.findProjectByName(name);
    }

    @GetMapping("/find-by-description")
    @ResponseStatus(HttpStatus.FOUND)
    public Flux<Project> findProjectByDescription(@RequestParam String description) {
        return projectService.findProjectByDescription(description);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Project> update(@PathVariable("id") Long id, @RequestBody Project project) {
        return projectService.update(id, project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProjectById(@PathVariable("id") Long id) {
        return projectService.deleteProjectById(id);
    }
}
