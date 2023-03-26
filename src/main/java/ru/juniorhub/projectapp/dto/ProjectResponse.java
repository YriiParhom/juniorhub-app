package ru.juniorhub.projectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

    private Long id;
    private String projectName;
    private String projectDescription;
    private byte[] logo;
    private Date startDate;
    private Date endDate;
}
