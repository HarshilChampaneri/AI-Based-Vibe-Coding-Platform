package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.dto.subscription.PlanResponse;
import com.harshilInfotech.vibeCoding.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {



    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
