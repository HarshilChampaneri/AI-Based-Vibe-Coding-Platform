package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.subscription.PlanResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PlanService {

    List<PlanResponse> getAllActivePlans();

}
