package com.learn.accounts.service.impl;

import com.learn.accounts.dto.AccountDto;
import com.learn.accounts.dto.CardsDto;
import com.learn.accounts.dto.CustomerDetailsDto;
import com.learn.accounts.dto.LoansDto;
import com.learn.accounts.entity.Account;
import com.learn.accounts.entity.Customer;
import com.learn.accounts.exception.ResourceNotFoundException;
import com.learn.accounts.mapper.AccountMapper;
import com.learn.accounts.mapper.CustomerMapper;
import com.learn.accounts.repository.AccountRepository;
import com.learn.accounts.repository.CustomerRepository;
import com.learn.accounts.service.ICustomerService;
import com.learn.accounts.service.client.CardsFeignClient;
import com.learn.accounts.service.client.LoansFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoansFeignClient loansFeignClient;

    @Autowired
    private CardsFeignClient cardsFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account account = (Account) accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());

        AccountDto accountDto = AccountMapper.mapToAccountsDto(account, new AccountDto());
        customerDetailsDto.setAccountDto(accountDto);

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoansDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }

}
