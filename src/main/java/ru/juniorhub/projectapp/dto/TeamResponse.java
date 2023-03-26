package ru.juniorhub.projectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {

    private Long id;
    private String teamName;
    private String teamDescription;
    private byte[] logo;
    private LocalDate creationDate;
    private Integer totalNumberOfMembers;
    private Long projectId;
}
