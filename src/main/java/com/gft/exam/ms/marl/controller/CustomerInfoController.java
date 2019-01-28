package com.gft.exam.ms.marl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.exam.ms.marl.data.specification.CustomerListSpecification;
import com.gft.exam.ms.marl.dto.CustomerIn;
import com.gft.exam.ms.marl.model.CustomerDetail;
import com.gft.exam.ms.marl.model.CustomersData;
import com.gft.exam.ms.marl.repository.CustomerRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerInfoController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerListSpecification customerListSpecification;
	
	
//	@GetMapping(path = "/v1/customers")
//	public Page<CustomerDetail> retrieveAllCustomersV1(@ModelAttribute CustomerIn paramsIn, Pageable pageable) {
//		Page<CustomerDetail> userPage = customerRepository.findAll(customerListSpecification.getFilter(paramsIn), pageable);
//		return userPage;
//	}
//	
//	@GetMapping(path = "/v2/customers")
//	public CustomersData retrieveAllCustomers(@ModelAttribute CustomerIn paramsIn, Pageable pageable) {
//		Page<CustomerDetail> userPage = customerRepository.findAll(customerListSpecification.getFilter(paramsIn), pageable);
//		CustomersData customersData  = new CustomersData();
//		customersData.setCustomerDetail(userPage.getContent());
//		return customersData;
//	}
	
	@ApiOperation(
    		value = "Lookup a list of customers according to the apply", 
    		nickname = "customer")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "successful operation", response = CustomersData.class),
            @ApiResponse(code = 404, message = "customer not found."),
            @ApiResponse(code = 500, message = "Unexpected error.")})  
	@GetMapping(path = "/", consumes = {"application/json; charset=utf-8"},
							produces = {"application/json; charset=utf-8"})
	public ResponseEntity<Object> retrieveListOfCustomers(
			 @ApiParam(value = "Mime type request expected" ,required=true) 
			 @RequestHeader(value="accept", required=true) String accept,
			 @ApiParam(value = "Language expected" ,required=true) 
			 @RequestHeader(value="accept-language", required=true) String acceptLanguage,
			 @ApiParam(value = "Mime type request expected" ,required=true) 
			 @RequestHeader(value="content-type", required=true) String contentType,
			 @ApiParam(value = "IBM client ID" ,required=true) 
			 @RequestHeader(value="x-ibm-client-id", required=true) String xIbmClientId,
			 @ApiParam(value = "Token authorization" ,required=true) 
			 @RequestHeader(value="authorization", required=true) String authorization,
			 @ApiParam(value = "Santander global ID" ,required=true) 
			 @RequestHeader(value="x-santander-global-id", required=true) String xSantanderGlobalId,
			@ModelAttribute CustomerIn paramsIn,
			Pageable pageable) {
		try {
			Page<CustomerDetail> userPage = customerRepository.findAll(customerListSpecification.getFilter(paramsIn), pageable);			
			CustomersData customersData  = new CustomersData();			
			customersData.setCustomerDetail(userPage.getContent());
			if(CollectionUtils.isEmpty(customersData.getCustomerDetail())) {
				return new ResponseEntity<>("customer not found.", HttpStatus.NOT_FOUND);
			}else{
				return ResponseEntity.ok()
									 .body(customersData);
			}
		}catch(Exception e) {
			log.error("Error: ", e);
			return new ResponseEntity<>("Unexpected error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
