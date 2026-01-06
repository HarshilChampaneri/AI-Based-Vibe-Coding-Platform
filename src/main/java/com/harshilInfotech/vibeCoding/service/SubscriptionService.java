package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.subscription.CheckoutRequest;
import com.harshilInfotech.vibeCoding.dto.subscription.CheckoutResponse;
import com.harshilInfotech.vibeCoding.dto.subscription.PortalResponse;
import com.harshilInfotech.vibeCoding.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {

    SubscriptionResponse getCurrentSubscription(Long userId);

}
