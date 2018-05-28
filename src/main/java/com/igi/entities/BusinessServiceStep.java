package com.igi.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.igi.utils.BusinessStepType;

@Entity
@Table(name = "Business_Service_Step")
public class BusinessServiceStep implements Serializable, Comparable<BusinessServiceStep> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@org.hibernate.annotations.GenericGenerator(name = "incrementGenerator", strategy = "org.hibernate.id.IncrementGenerator")
	@GeneratedValue(generator = "incrementGenerator")
	@Column(name = "Id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "BUSINESS_SERVICE_CONFIG_ID")
	private BusinessServiceConfig businessServiceConfig;

	@Column(name = "Description")
	private String description;

	@Column(name = "is_migrated")
	private boolean isMigrated = false;

	@OneToOne
	@JoinColumn(name = "Service", nullable = true)
	private Service service;

	@Column(name = "Step_Order")
	private int stepOrder;

	// @OneToOne
	// @JoinColumn(name = "Transaction_Def", nullable = true)
	// private TransactionDefinitionSummary transaction;

	@Enumerated
	private BusinessStepType type;

	public int compareTo(BusinessServiceStep o) {
		return this.stepOrder > o.stepOrder ? 1 : -1;
	}

	@JsonBackReference
	public BusinessServiceConfig getBusinessServiceConfig() {
		return businessServiceConfig;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return this.id;
	}

	public Service getService() {
		return service;
	}

	public int getStepOrder() {
		return stepOrder;
	}

	/*
	 * public TransactionDefinitionSummary getTransaction() { return transaction; }
	 * 
	 * public void setTransaction(TransactionDefinitionSummary transaction) {
	 * this.transaction = transaction; }
	 */
	public BusinessStepType getType() {
		return type;
	}

	public boolean isMigrated() {
		return isMigrated;
	}

	public void setBusinessServiceConfig(BusinessServiceConfig businessServiceConfig) {
		this.businessServiceConfig = businessServiceConfig;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMigrated(boolean isMigrated) {
		this.isMigrated = isMigrated;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public void setStepOrder(int stepOrder) {
		this.stepOrder = stepOrder;
	}

	public void setType(BusinessStepType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "insert into Business_Service_Step(Id,BUSINESS_SERVICE_CONFIG_ID,Description,is_migrated,Service,Step_Order,type) values( "
				+ id + ", " + businessServiceConfig.getId() + ", " + description + ", " + isMigrated + ", "
				+ service.getId() + ", " + stepOrder + ", " + type.getBusinessStepTypeString() + ")";
	}
}
