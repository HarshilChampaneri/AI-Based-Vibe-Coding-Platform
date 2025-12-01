package com.harshilInfotech.vibeCoding.dto.subscription;

import jakarta.persistence.criteria.CriteriaBuilder;

public record PlanResponse(
        Long id,
        String name,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Boolean unlimitedAi,
        String price
) {
}
