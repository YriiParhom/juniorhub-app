package ru.juniorhub.projectapp.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.dto.TeamResponse;
import ru.juniorhub.projectapp.exceptions.TeamNotFoundException;
import ru.juniorhub.projectapp.exceptions.UserNotFoundException;
import ru.juniorhub.projectapp.model.Team;
import ru.juniorhub.projectapp.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final String EXCEPTION_MSG = "Team does not exist";
    private final TeamRepository teamRepository;

    public Mono<Team> save(Team team) {
        return teamRepository.save(team);
    }

    public Mono<Team> findTeamById(Long id) {
        return teamRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new TeamNotFoundException(EXCEPTION_MSG)));
    }

    public Mono<TeamResponse> findTeamByTeamName(String teamName) {
        return teamRepository.findByTeamName(teamName)
                .switchIfEmpty(Mono.error(() -> new TeamNotFoundException(EXCEPTION_MSG)));
    }

    public Mono<Team> findTeamByDescription(String description) {
        return teamRepository.findByTeamDescription(description)
                .switchIfEmpty(Mono.error(() -> new TeamNotFoundException(EXCEPTION_MSG)));
    }

    public Mono<Team> updateTeam(Long id, Team team) {
        return teamRepository.findById(id)
                .map(t -> team)
                .flatMap(teamRepository::save)
                .switchIfEmpty(Mono.error(() -> new UserNotFoundException(EXCEPTION_MSG)));
    }

    public Mono<Void> delete(Long id) {
        return teamRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new UserNotFoundException(EXCEPTION_MSG)))
                .flatMap(teamRepository::delete);
    }
}
