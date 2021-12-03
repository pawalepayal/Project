package com.cg.ofda.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.dao.ICustomerRepository;
import com.cg.ofda.model.Customer;


@Service
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerRepo;


	@Override
	public Customer addCustomer(Customer customer) {
				
			Customer cust=customerRepo.save(customer);
			
			return cust;
	}


}
