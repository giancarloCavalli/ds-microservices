package com.gcavalli.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcavalli.hrpayroll.entities.Payment;
import com.gcavalli.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative") //Alternative method in case of any failure
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable int days) {
		Payment obj = service.getPayment(workerId, days);
		return ResponseEntity.ok(obj);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, int days) {
		Payment obj = new Payment("Brady", 900.0, days);
		return ResponseEntity.ok(obj);
	}
}
