package ru.juniorhub.projectapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    private Long id;
    private String projectName;
    private String projectDescription;
    private byte[] logo;
    private LocalDate startDate;
    private LocalDate endDate;

}
