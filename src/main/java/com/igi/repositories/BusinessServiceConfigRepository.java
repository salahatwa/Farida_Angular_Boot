package com.igi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.igi.entities.BusinessServiceConfig;
import com.igi.entities.ServiceConfigMap;

@Repository
public interface BusinessServiceConfigRepository extends JpaRepository<BusinessServiceConfig, Long> {
	public BusinessServiceConfig findByBusinessServiceType(ServiceConfigMap businessServiceType);

//	@Query(value="SELECT * FROM Business_Service_Config  WHERE Business_Service_Type = :businessServiceType",nativeQuery=true)
//	public BusinessServiceConfig findServiceByBusinessServiceType(@Param("businessServiceType") Integer businessServiceType);
}
