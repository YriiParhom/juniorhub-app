package ru.juniorhub.projectapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    private Long id;
    private  String teamName;
    private  String teamDescription;
    private  byte[] logo;
    private  LocalDate creationDate;
    private  int totalNumberOfMembers;

}
