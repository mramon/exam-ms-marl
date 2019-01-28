package com.gft.exam.ms.marl.model;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

/**
 * CustomersData
 */
@JsonTypeName("customersData")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-21T18:18:25.922-06:00")
@Data
public class CustomersData {

	@JsonProperty("customerDetail")
	private List<CustomerDetail> customerDetail;

}

