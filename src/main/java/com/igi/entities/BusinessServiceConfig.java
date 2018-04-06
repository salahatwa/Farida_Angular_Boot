package com.igi.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.igi.utils.BusinessServiceCategory;


@Entity
@Table(name = "Business_Service_Config")
public class BusinessServiceConfig implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;

	@Column(name = "banking_agent", nullable = false)
	private boolean bankingAgent = false;

	
	@Enumerated
	@Column(name="BUSINESSSERVICECATEGORY")
	private BusinessServiceCategory businessServiceCategory;

	@ManyToOne
	@JoinColumn(name = "Business_Service_Type")
	private ServiceConfigMap businessServiceType;


	@Column(name = "ISDEFAULTSERVICE")
	private boolean isDefaultService = false;

	@Column(name = "is_exposable", nullable = true)
	private boolean isExposable = false;

	@Column(name = "is_multi_wallet")
	private boolean isMultiWallet = false;

	@Column(name = "Name")
	private String name;

	@OneToOne
	@JoinColumn(name = "SEGMENTATIONTYPE_ID")
	private OfferedServiceType segmentationType;

	@OneToMany(fetch=FetchType.EAGER,mappedBy="businessServiceConfig")
//	@JoinColumn(name = "BUSINESS_SERVICE_CONFIG_ID", referencedColumnName = "Id")
	@OrderBy(value = "stepOrder")
	private Set<BusinessServiceStep> steps;
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "service_organization", joinColumns = @JoinColumn(name = "Business_Service_Config_Id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Business_Entity_ID", referencedColumnName = "Business_Entity_ID"))
//	private Set<BusinessEntity> walletList;
//	@OneToOne
//	@JoinColumn(name = "organization_id")
//	private BusinessEntity walletOwner;

	public BusinessServiceCategory getBusinessServiceCategory() {
		return businessServiceCategory;
	}

	public ServiceConfigMap getBusinessServiceType() {
		return businessServiceType;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public OfferedServiceType getSegmentationType() {
		return segmentationType;
	}

	@JsonManagedReference
	public Set<BusinessServiceStep> getSteps() {
		return steps;
	}

	

	public boolean isBankingAgent() {
		return bankingAgent;
	}

	public boolean isDefaultService() {
		return isDefaultService;
	}

	public boolean isExposable() {
		return isExposable;
	}

	public boolean isMultiWallet() {
		return isMultiWallet;
	}

	public void setBankingAgent(boolean bankingAgent) {
		this.bankingAgent = bankingAgent;
	}

	public void setBusinessServiceCategory(BusinessServiceCategory businessServiceCategory) {
		this.businessServiceCategory = businessServiceCategory;
	}

	public void setBusinessServiceType(ServiceConfigMap businessServiceType) {
		this.businessServiceType = businessServiceType;
	}

	public void setDefaultService(boolean isDefaultService) {
		this.isDefaultService = isDefaultService;
	}

	public void setExposable(boolean isExposable) {
		this.isExposable = isExposable;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMultiWallet(boolean isMultiWallet) {
		this.isMultiWallet = isMultiWallet;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSegmentationType(OfferedServiceType segmentationType) {
		this.segmentationType = segmentationType;
	}

	public void setSteps(Set<BusinessServiceStep> steps) {
		this.steps = steps;
	}
/*
	public Set<BusinessEntity> getWalletList() {
		return walletList;
	}

	public BusinessEntity getWalletOwner() {
		return walletOwner;
	}
	
	public void setWalletList(Set<BusinessEntity> walletList) {
		this.walletList = walletList;
	}

	public void setWalletOwner(BusinessEntity walletOwner) {
		this.walletOwner = walletOwner;
	}
*/
	@Override
	public String toString() {
		return "BusinessServiceConfig [id=" + id + ", name=" + name + ", businessServiceType=" + businessServiceType
				+ ", isDefaultService=" + isDefaultService + ", segmentationType=" + segmentationType
				+ ", bankingAgent=" + bankingAgent + ", isExposable=" + isExposable + ", isMultiWallet=" + isMultiWallet
				+ "]";
	}

}
