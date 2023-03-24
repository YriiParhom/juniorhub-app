package ru.juniorhub.projectapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private Long id;
    private String projectName;
    private String projectDescription;
    private byte[] logo;
    private Set<Long> teamId = new HashSet<>();
    private Date startDate;
    private Date endDate;

    public Project(
            Long id,
            String projectName,
            Set<Long> teamId,
            Date startDate,
            Date endDate) {
        this.id = id;
        this.projectName = projectName;
        this.teamId = teamId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
