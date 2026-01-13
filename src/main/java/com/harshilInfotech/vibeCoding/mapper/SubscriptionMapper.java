package com.harshilInfotech.vibeCoding.mapper;


import com.harshilInfotech.vibeCoding.dto.subscription.PlanResponse;
import com.harshilInfotech.vibeCoding.dto.subscription.SubscriptionResponse;
import com.harshilInfotech.vibeCoding.entity.Plan;
import com.harshilInfotech.vibeCoding.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);

}
