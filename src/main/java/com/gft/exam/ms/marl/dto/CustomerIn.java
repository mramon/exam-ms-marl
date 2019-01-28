package com.gft.exam.ms.marl.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerIn {

	@ApiParam(value = "Customer ID")
	private String customerId;
	@ApiParam(value = "Document Number")
	private String documentNumber;
	@ApiParam(value = "Company Name")
	private String companyName;
	@ApiParam(value = "Account Number")
	private String accountNumber;
	@ApiParam(value = "Name")
	private String name;
	@ApiParam(value = "Paternal Name") 
	private String paternalName;
	@ApiParam(value = "Maternal Name") 
	private String maternalName;
}
