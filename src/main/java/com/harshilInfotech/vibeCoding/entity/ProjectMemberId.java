package com.harshilInfotech.vibeCoding.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberId {

    Long projectId;
    Long userId;

}
