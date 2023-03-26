package ru.juniorhub.projectapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.dto.TeamResponse;
import ru.juniorhub.projectapp.model.Team;
import ru.juniorhub.projectapp.sevice.TeamService;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Team> createTeam(@RequestBody Team team) {
        return teamService.save(team);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Team> findTeamById(@PathVariable("id") Long id) {
        return teamService.findTeamById(id);
    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TeamResponse> findByTeamName(@RequestParam String teamName) {
        return teamService.findTeamByTeamName(teamName);
    }

    @GetMapping("/find-by-description")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Team> findByDescription(@RequestParam String description) {
        return teamService.findTeamByDescription(description);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Team> updateTeam(@PathVariable("id") Long id, @RequestBody Team team) {
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTeamById(@PathVariable("id") Long id) {
        return teamService.delete(id);
    }
}
