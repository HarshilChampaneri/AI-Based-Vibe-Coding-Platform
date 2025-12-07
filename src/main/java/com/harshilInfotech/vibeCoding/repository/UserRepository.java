package com.harshilInfotech.vibeCoding.repository;

import com.harshilInfotech.vibeCoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
