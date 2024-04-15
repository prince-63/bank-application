package com.learn.accounts.service.client;

import com.learn.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoanFallBack implements LoansFeignClient {
    @Override
    public ResponseEntity<LoansDto> fetchLoansDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
