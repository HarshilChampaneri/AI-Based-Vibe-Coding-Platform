package com.harshilInfotech.vibeCoding.repository;

import com.harshilInfotech.vibeCoding.entity.Subscription;
import com.harshilInfotech.vibeCoding.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    /*
    * Get the current active subscription.
    * */
    Optional<Subscription> findByUserIdAndStatusIn(Long userId, Set<SubscriptionStatus> statusSet);

    boolean existsByStripeSubscriptionId(String gatewaySubscriptionId);

    Optional<Subscription> findByStripeSubscriptionId(String gatewaySubscriptionId);

}
