package com.gft.exam.ms.marl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gft.exam.ms.marl.model.CustomerDetail;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetail, String>, JpaSpecificationExecutor<CustomerDetail> {

}
