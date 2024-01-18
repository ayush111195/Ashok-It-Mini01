package com.ayush.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.entity.Plan;
import com.ayush.entity.PlanCateogry;
import com.ayush.repo.PlanRepo;
import com.ayush.repo.PlaneCategoryRepo;

@Service
public class ServiceImpl implements PlanService{
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlaneCategoryRepo plancategoryRepo ;

	@Override
	public Map<Integer, String> getPlanCategories() {
    List<PlanCateogry> cateogries= plancategoryRepo.findAll();
    Map<Integer,String>cateogryMap=new HashMap<Integer, String>();
    
    cateogries.forEach(category ->{
    	cateogryMap.put(category.getCategoryId(),category.getCategoryName());
    });
		return cateogryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		
	Plan saved=	planRepo.save(plan);
	
	/*if(saved.getPlanid()!=null) {
		return  true;
	}else {
		return false;
	}*/
	
   	return saved.getPlanid()!=null ? true :false;
	
	//return saved.getPlanid()!= null;
	
	}
	

	@Override
	public List<Plan> getAllPlans() {	
		return planRepo.findAll();

	}

	@Override
	public Plan getPlanById(Integer planId) {
	Optional<Plan>findById=planRepo.findById(planId);
	
	//optional is the cantinner jo ki java 1.8 introduse  kiya gya h planid mil bhi ksti h aur nhi bhi mil skti h 
	if(findById.isPresent()) {
		return findById.get();
	}else {
		return null;
	}
	
	}

	@Override
	public boolean updatePlan(Plan plan) {
		planRepo.save(plan);
	
		return plan.getPlanid()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		
		Boolean status=false;
		try {
			planRepo.deleteById(planId);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
			}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> findById=planRepo.findById(planId);
		if(findById.isPresent()) {
		Plan plan=new Plan();
		plan.setActiveSw(status);
		planRepo.save(plan);
		return true;
		
	}
		return false;

}
}
