package com.harshilInfotech.vibeCoding.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {

    Long id;

    String name;

    String stripePriceId;
    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews; // maximum number of projects a user can preview simultaneously.
    Boolean unlimitedAi; // unlimited access to LLM, Ignore max tokens per day if true.

    Boolean active;

}
