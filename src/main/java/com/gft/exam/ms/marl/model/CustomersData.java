package com.gft.exam.ms.marl.model;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * CustomersData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-21T18:18:25.922-06:00")
@Data
public class CustomersData {

	@JsonProperty("customerDetail")
	private List<CustomerDetail> customerDetail;

}

