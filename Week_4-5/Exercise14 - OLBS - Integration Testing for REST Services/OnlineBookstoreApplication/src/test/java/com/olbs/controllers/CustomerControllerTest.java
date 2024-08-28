package com.olbs.controllers;


import com.olbs.dtos.CustomerDto;
import com.olbs.dtos.CustomerRegistrationDto;
import com.olbs.entities.Customer;
import com.olbs.services.CustomerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer customer;
    @SuppressWarnings("unused")
	private CustomerDto customerDto;
    private CustomerRegistrationDto customerRegistrationDto;

    @BeforeEach
    public void init() {
        customer = Customer.builder().name("Souvik").email("souvikkar009@gmail.com").password("123456").build();
        customerDto = CustomerDto.builder().name("Souvik").email("souvikkar009@gmail.com").password("123456").build();
        customerRegistrationDto = CustomerRegistrationDto.builder().name("Souvik").email("souvikkar009@gmail.com").password("123456").build();
    }

    @Test
    public void CustomerController_CreateCustomer_ReturnCreated() throws Exception {
        given(customerService.registerCustomer(customerRegistrationDto));

        ResultActions response = mockMvc.perform(post("customers/register"));
        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void CustomerController_GetAllCustomer_ReturnResponseDto() throws Exception {
        List<Customer> customers = new ArrayList<>();
        when(customerService.getAllCustomers()).thenReturn(customers);

        ResultActions response = mockMvc.perform(get("/"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void CustomerController_CustomerDetail_ReturnCustomerDto() throws Exception {
        int customerId = 1;
        when(customerService.getCustomerById(customerId)).thenReturn(customer);

        ResultActions response = mockMvc.perform(get("/1"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void CustomerController_UpdateCustomerEmail_ReturnResponse() throws Exception {
        int customerId = 1;
        CustomerDto customerDto2 = CustomerDto.builder().name("Babai").email("souvikkar10@outlook.com").password("123456").build();
        when(customerService.updateCustomerEmail(customerId, customerDto2.getEmail()));

        ResultActions response = mockMvc.perform(put("/1/update/email"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void CustomerController_DeleteCustomer_ReturnString() throws Exception {
        int customerId = 1;
        when(customerService.deleteCustomerById(customerId));

        ResultActions response = mockMvc.perform(delete("/1"));

        response.andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}
