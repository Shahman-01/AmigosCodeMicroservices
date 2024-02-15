package com.amigoscode.fraud;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

	private final FraudCheckService fraudCheckService;

	@GetMapping("{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
		boolean isFraudulentCustomer =  fraudCheckService.isFraudulentCustomer(customerId);
		return new FraudCheckResponse(isFraudulentCustomer);
	}
}
