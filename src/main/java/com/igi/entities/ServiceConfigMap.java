package com.igi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.igi.utils.ServiceExecutionMode;

@Entity
@Table(name = "Service_Config_Map")
public class ServiceConfigMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "service_Type_ID", unique=true	,nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "category_id", nullable = true)
	private ServiceCategory category;

	@Column(name = "Is_Generic_Service")
	private boolean isGenericService = false;

	@Column(name = "service_Type_Name", nullable = false)
	private String name;

	@Enumerated
	@Column(name = "service_mode")
	private ServiceExecutionMode serviceMode;

	public ServiceConfigMap() {
	}
	
	/*public ServiceConfigMap(ServiceCategory category, boolean isGenericService, String name,
			ServiceExecutionMode serviceMode) {
		super();
		this.category = category;
		this.isGenericService = isGenericService;
		this.name = name;
		this.serviceMode = serviceMode;
	}*/

	public ServiceCategory getCategory() {
		return category;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ServiceExecutionMode getServiceMode() {
		return serviceMode;
	}

	public boolean isGenericService() {
		return isGenericService;
	}

	public void setCategory(ServiceCategory category) {
		this.category = category;
	}

	public void setGenericService(boolean isGenericService) {
		this.isGenericService = isGenericService;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public void setServiceMode(ServiceExecutionMode serviceMode) {
		this.serviceMode = serviceMode;
	}

	@Override
	public String toString() {
		return "ServiceConfigMap [id=" + id + ", name=" + name + ", isGenericService=" + isGenericService;
	}

}
