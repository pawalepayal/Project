package com.cg.ofda.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofda.model.Customer;
import com.cg.ofda.service.ICustomerServiceImpl;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class ICustomerController {
	
	@Autowired
	private ICustomerServiceImpl customerService;
	static final Logger LOGGER = LoggerFactory.getLogger(ICustomerController.class);
	
	@PostMapping("/insert")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		LOGGER.info("Insert Customer");
		Customer cust=customerService.addCustomer(customer);
		if(cust==null){
		return new ResponseEntity("Customer Not Found!!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity <Customer>(cust ,HttpStatus.OK);
	}

}
