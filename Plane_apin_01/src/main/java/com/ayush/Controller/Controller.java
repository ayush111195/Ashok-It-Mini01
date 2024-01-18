package com.ayush.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.AppConstants.Constants;
import com.ayush.entity.Plan;
import com.ayush.props.AppProperties;
import com.ayush.service.PlanService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class Controller {

//	@Autowired
	private PlanService planService;
	
//	@Autowired
//	private AppProperties appProperties;
	
	private Map<String, String>messages;
	
//	Make the controller class constructor--> to autowired the properties-->>
	public Controller(PlanService planService,AppProperties appProperties) {
		this.planService=planService;
		this.messages=appProperties.getMessages();
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCaegories(){
	Map<Integer,String> categories=	planService.getPlanCategories();
	return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String>savePlan( @RequestBody Plan plan){
		
	String responceMsg=Constants.EMPTY_STR;
		
	boolean isSaved=planService.savePlan(plan);
//	Map<String, String> messages=appProperties.getMessages();
	
	if(isSaved) {
	
	        responceMsg=   messages.get(Constants.PLAN_SAVE_SUCC);
	}else {
		responceMsg=messages.get(Constants.PLAN_SAVE_FAIL);
	}
	return new ResponseEntity<>(responceMsg,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
	List<Plan>allPlans=	planService.getAllPlans();
	return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
	Plan planById=planService.getPlanById(planId);
	return new ResponseEntity<>(planById,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
	boolean  isDeleted= planService.deletePlanById(planId);
	String msg= Constants.EMPTY_STR;

 // Map<String, String>message=appProperties.getMessages();
	if(isDeleted) {
    msg=messages.get(Constants.PLAN_DELETE_SUCC);
	}else {
	    msg=messages.get(Constants.PLAN_DELETE_FAIL);
	}
	return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String>updatePlan( @RequestBody Plan plan){
	boolean isUpdated=planService.updatePlan(plan);
	String msg=Constants.EMPTY_STR;;
 // Map<String, String>message=appProperties.getMessages();

	if(isUpdated) {
	msg=messages.get(Constants.PLAN_UPDATE_SUCC);
	}else {
		msg=messages.get(Constants.PLAN_UPDATE_FAIL);
	}
	return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change")
	public ResponseEntity<String>statusChange( @PathVariable Integer planId,@PathVariable String status){
	boolean isStatusChanged=	planService.planStatusChange( planId, status);
	String msg=Constants.EMPTY_STR;;
//  Map<String, String>message=appProperties.getMessages();

	if(isStatusChanged) {
	msg=messages.get(Constants.PLAN_STATUS_CHANGE);
	}else {
		msg=messages.get(Constants.PLAN_STATUS_CHANGE_FAIL);
	}
	return new ResponseEntity<>(msg,HttpStatus.OK) ;
	}
	
}