package com.igi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.igi.utils.ServiceLevel;
import com.igi.utils.ServiceStack;

@Entity(name = "Service")
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "category_id", nullable = true)
	private ServiceCategory category;

	private String description;

	@Column(name = "is_migrated")
	private boolean isMigrated = false;

	@Enumerated
	@Column(name = "service_level")
	private ServiceLevel level;

	@Column(name = "Name")
	private String name;

	@Column(name = "Owner_Service")
	private String ownerService;

	@Column(name = "Service_Reversal_Id")
	private String serviceReversal;

	@Column(name = "Service_Stack_Id")
	private String serviceStackId;

	@Column(name = "Service_Stack_Type")
	@Enumerated(EnumType.ORDINAL)
	private ServiceStack serviceStackType;

	public Service() {

	}

	public Service(Long id, String name, String owner) {
		this.id = id;
		this.name = name;
	}

	public ServiceCategory getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return this.id;
	}

	public ServiceLevel getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	/**
	 * @deprecated This field is useless now
	 */
	@Deprecated
	public String getOwnerService() {
		return ownerService;
	}

	public String getServiceReversal() {
		return serviceReversal;
	}

	public String getServiceStackId() {
		return serviceStackId;
	}

	public ServiceStack getServiceStackType() {
		return serviceStackType;
	}

	public boolean isMigrated() {
		return isMigrated;
	}

	public void setCategory(ServiceCategory category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLevel(ServiceLevel level) {
		this.level = level;
	}

	public void setMigrated(boolean isMigrated) {
		this.isMigrated = isMigrated;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @deprecated This field is useless now
	 */
	@Deprecated
	public void setOwnerService(String ownerService) {
		this.ownerService = ownerService;
	}

	public void setServiceReversal(String serviceReversal) {
		this.serviceReversal = serviceReversal;
	}

	public void setServiceStackId(String serviceStackId) {
		this.serviceStackId = serviceStackId;
	}

	public void setServiceStackType(ServiceStack serviceStackType) {
		this.serviceStackType = serviceStackType;
	}

	@Override
	public String toString() {
		
		Integer catId = (this.category != null && !this.category.equals(null))
				? category.getId()
				: null;
				
		return "insert into Service (Id,Service_Stack_Id,Service_Stack_Type,Name,description,Owner_Service,is_migrated,category_id,service_level,Service_Reversal_Id)  values("
				+ id + ", " + serviceStackId + "," + serviceStackType + "," + name + "," + description + ", "
				+ ownerService + "," + isMigrated + ", " + catId + "," + level + ", " + serviceReversal + ")";
	}

}
