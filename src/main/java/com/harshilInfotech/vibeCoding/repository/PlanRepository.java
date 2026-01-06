package com.harshilInfotech.vibeCoding.repository;

import com.harshilInfotech.vibeCoding.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {



}
