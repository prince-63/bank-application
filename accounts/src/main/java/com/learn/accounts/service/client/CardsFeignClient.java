package com.learn.accounts.service.client;

import com.learn.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards", fallback = CardFallBack.class)
public interface CardsFeignClient {

    @GetMapping("/api/fetch")
    public ResponseEntity<CardsDto> fetchCardDetails(
            @RequestHeader("yourbank-correlation-id") String correlationId,
            @RequestParam String mobileNumber);
}
