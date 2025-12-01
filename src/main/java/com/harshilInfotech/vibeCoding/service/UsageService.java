package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.subscription.PlanLimitsResponse;
import com.harshilInfotech.vibeCoding.dto.subscription.UsageTodayResponse;

public interface UsageService {

    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getPlanLimitsOfUser(Long userId);
}
