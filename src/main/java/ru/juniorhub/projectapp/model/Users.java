package ru.juniorhub.projectapp.model;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private  Long id;
    private String username;
    private String phoneNumber;
    private Long teamId;
}
