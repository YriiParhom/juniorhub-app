package ru.juniorhub.projectapp.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.dto.TeamResponse;
import ru.juniorhub.projectapp.model.Team;
import ru.juniorhub.projectapp.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Mono<Team> save(Team team) {
        return teamRepository.save(team);
    }

    public Mono<Team> findTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Mono<TeamResponse> findTeamByTeamName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }

    public Mono<Team> findTeamByDescription(String description) {
        return teamRepository.findByTeamDescription(description);
    }

    public Mono<Team> updateTeam(Long id, Team team) {
        return null; //TODO
    }

    public Mono<Void> delete(Long id) {
        return teamRepository.deleteById(id);
    }
}
