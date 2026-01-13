package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.subscription.CheckoutRequest;
import com.harshilInfotech.vibeCoding.dto.subscription.CheckoutResponse;
import com.harshilInfotech.vibeCoding.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcessor {

    CheckoutResponse createCheckoutSession(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);

}
