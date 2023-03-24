package ru.juniorhub.projectapp.repository;

import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.juniorhub.projectapp.dto.TeamResponse;
import ru.juniorhub.projectapp.model.Team;

@Repository
public interface TeamRepository extends ReactiveCrudRepository<Team, Long> {
    @Query("select * from team t left join users u on t.id = u.team_id")
    Mono<TeamResponse> findByTeamName(String teamName);

    @Query("select * from team t left join users u on t.id = u.team_id")
    Mono<Team> findByTeamDescription(String description);

    @Transactional
    @NonNull
    Mono<Void> deleteById(@NonNull Long id);
}
