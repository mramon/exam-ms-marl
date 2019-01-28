package com.gft.exam.ms.marl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gft.exam.ms.marl.data.specification.CustomerListSpecification;
import com.gft.exam.ms.marl.dto.CustomerIn;
import com.gft.exam.ms.marl.model.CustomerDetail;
import com.gft.exam.ms.marl.model.CustomersData;
import com.gft.exam.ms.marl.repository.CustomerRepository;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustomerInfoController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerListSpecification customerListSpecification;
//	@Autowired
//	private MessageSource messageSource;
	
//	@GetMapping(path = "/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
//
	@GetMapping(path = "/customers/v1")
	public Page<CustomerDetail> retrieveAllCustomersV1(@ModelAttribute CustomerIn paramsIn, Pageable pageable) {
		Page<CustomerDetail> userPage = customerRepository.findAll(customerListSpecification.getFilter(paramsIn), pageable);
		
		return userPage;
	}
	
	@GetMapping(path = "/customers")
	public CustomersData retrieveAllCustomers(@ModelAttribute CustomerIn paramsIn, Pageable pageable) {
		Page<CustomerDetail> userPage = customerRepository.findAll(customerListSpecification.getFilter(paramsIn), pageable);
		
		CustomersData customersData  = new CustomersData();
		
		customersData.setCustomerDetail(userPage.getContent());
		
		return customersData;
	}
	
	@GetMapping(path = "/")
	public CustomersData retrieveListOfCustomers(
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
		
//		customerRepository.
		
		Page<CustomerDetail> userPage = customerRepository.findAll(customerListSpecification.getFilter(paramsIn), pageable);
		
		CustomersData customersData  = new CustomersData();
		
		customersData.setCustomerDetail(userPage.getContent());
		
		return customersData;
//		Specification<CustomerDetail> spec = Specification.where(new CustomerWithCustomerId(paramsIn.getCustomerId()))
//										                .and(new CustomerWithAddress(paramsIn.get))
//										                .and(new CustomerWithCondition(status))
//										                .and(new CustomerWithCustomerCategory(lastName))
//										                .and(new CustomerWithFullName(status))
//														.and(new CustomerWithOriginChannel(lastName))
//												        .and(new CustomerWithSegment(status));
//
		//customerRepository.findAll(spec, pageable);
	}
//
//	@GetMapping(path = "/hello-world/path-variable/{name}")
//	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
//		return new HelloWorldBean(String.format("Hello World, %s", name));
//	}
	
//	@GetMapping(path="/hello-world-internationalized")
//	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
//		return messageSource.getMessage("good.morning.message", null, locale);
//	}

//	@GetMapping(path="/hello-world-internationalized")
//	public String helloWorldInternationalized() {
//		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
//	}
	
}
