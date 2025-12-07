package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.dto.subscription.CheckoutRequest;
import com.harshilInfotech.vibeCoding.dto.subscription.CheckoutResponse;
import com.harshilInfotech.vibeCoding.dto.subscription.PortalResponse;
import com.harshilInfotech.vibeCoding.dto.subscription.SubscriptionResponse;
import com.harshilInfotech.vibeCoding.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {



    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSession(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
