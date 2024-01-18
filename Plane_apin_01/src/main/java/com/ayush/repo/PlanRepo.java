package com.ayush.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer>{

}
