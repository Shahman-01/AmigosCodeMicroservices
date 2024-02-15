package com.amigoscode.fraud;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

	private final FraudCheckHistoryRepo fraudCheckHistoryRepo;

	public boolean isFraudulentCustomer(Integer customerId) {
		fraudCheckHistoryRepo.save(
				FraudCheckHistory.builder()
						.customerId(customerId)
						.isFraudster(false)
						.createdAt(LocalDateTime.now())
						.build()
		);
		return false;
	}
}
