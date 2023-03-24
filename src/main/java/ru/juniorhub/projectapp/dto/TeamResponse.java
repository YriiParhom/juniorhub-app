package ru.juniorhub.projectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {

    private Long id;
    private String teamName;
    private String teamDescription;
    private Byte logo;
    private LocalDate creationDate;
    private Integer totalNumberOfMembers;
    private Set<UserResponse> members = new HashSet<>();
}
