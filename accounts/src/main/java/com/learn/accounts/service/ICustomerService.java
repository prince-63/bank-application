package com.learn.accounts.service;

import com.learn.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
