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
@Table(name="PLAN_CATEGORY")
public class PlanCateogry {
    
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="ACTIVE_SW")
	private  String activeSw;
	
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
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

	public PlanCateogry(Integer categoryId, String categoryName, String createdBy, String activeSw, String updatedBy,
			LocalDate createDate, LocalDate updateDate) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.createdBy = createdBy;
		this.activeSw = activeSw;
		this.updatedBy = updatedBy;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public PlanCateogry() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PlanCateogry [categoryId=" + categoryId + ", categoryName=" + categoryName + ", createdBy=" + createdBy
				+ ", activeSw=" + activeSw + ", updatedBy=" + updatedBy + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	} 
	
	
}
