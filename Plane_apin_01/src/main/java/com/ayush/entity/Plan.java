package com.ayush.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="PLAN_MASTER")
public class Plan {

	@Id
	@GeneratedValue
	@Column(name="PLAN_ID")
	private Integer planid;
	
	@Column(name="PLAN_NAME")
	private String planename;
	
	@Column(name="PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name="PLAN_END_DATE")
	private LocalDate planeEndDate;
	
	@Column(name="PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATE_BY")
	private  String updatedBy;
	
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
    private LocalDate createDate; 
	
	@Column(name="UPDATE_DATE",insertable = false)
	@UpdateTimestamp
    private LocalDate updateDate;

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	public String getPlanename() {
		return planename;
	}

	public void setPlanename(String planename) {
		this.planename = planename;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlaneEndDate() {
		return planeEndDate;
	}

	public void setPlaneEndDate(LocalDate planeEndDate) {
		this.planeEndDate = planeEndDate;
	}

	public Integer getPlanCategoryId() {
		return planCategoryId;
	}

	public void setPlanCategoryId(Integer planCategoryId) {
		this.planCategoryId = planCategoryId;
	}

	public String getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}
	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plan(Integer planid, String planename, LocalDate planStartDate, LocalDate planeEndDate,
			Integer planCategoryId, String activeSw, String createdBy, String updatedBy, LocalDate createDate,
			LocalDate updateDate) {
		super();
		this.planid = planid;
		this.planename = planename;
		this.planStartDate = planStartDate;
		this.planeEndDate = planeEndDate;
		this.planCategoryId = planCategoryId;
		this.activeSw = activeSw;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Plan [planid=" + planid + ", planename=" + planename + ", planStartDate=" + planStartDate
				+ ", planeEndDate=" + planeEndDate + ", planCategoryId=" + planCategoryId + ", activeSw=" + activeSw
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

	
	
	
}
