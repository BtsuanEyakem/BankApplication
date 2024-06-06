package bank.service.DTO.CustomerDTO;

import bank.domain.Customer;

public class CustomerAdaptor {
    public static CustomerDTO custotomerDTOfromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO(customer.getName());
        return customerDTO;
    }

    public static Customer customerFromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer(customerDTO.getName());
        return customer;
    }
}
