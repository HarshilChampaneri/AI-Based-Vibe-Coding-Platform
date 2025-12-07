package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.dto.subscription.PlanLimitsResponse;
import com.harshilInfotech.vibeCoding.dto.subscription.UsageTodayResponse;
import com.harshilInfotech.vibeCoding.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsageServiceImpl implements UsageService {



    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getPlanLimitsOfUser(Long userId) {
        return null;
    }
}
