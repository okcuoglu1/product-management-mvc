package com.enoca.service;

import com.enoca.exception.BadRequestException;
import com.enoca.exception.NotFoundException;
import com.enoca.model.Customer;
import com.enoca.payload.dto.CustomerDTO;
import com.enoca.payload.request.CustomerRequest;
import com.enoca.payload.response.CustomerResponse;
import com.enoca.payload.response.ResponseMessage;
import com.enoca.repository.CustomerRepository;
import com.enoca.util.FieldControl;
import com.enoca.util.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDTO customerDTO;

    private final FieldControl fieldControl;


    //not save
    public ResponseMessage<CustomerResponse> saveCustomer(CustomerRequest request) {

        //dbde var mı yok mu kontrolü?
        boolean existCustomerInDB = customerRepository.existsByEmail(request.getEmail());

        if(existCustomerInDB){

            throw new BadRequestException(String.format(Messages.ALREADY_REGISTER_MESSAGE_CUSTOMER,request.getEmail()));
        }

        //dto-pojo dnüsümü
        Customer customer =  customerDTO.createCustomer(request);
        Customer savedCustomer = customerRepository.save(customer);

        return ResponseMessage.<CustomerResponse>builder()
                .message("Müşteri Kaydedildi.")
                .object(createCustomerResponse(savedCustomer))
                .httpStatus(HttpStatus.CREATED)
                .build();


    }

    //getById


    //pojo-dto
    private CustomerResponse createCustomerResponse(Customer customer){

    return CustomerResponse.builder().
            firstName(customer.getFirstName()).
            lastName(customer.getLastName()).
            email(customer.getEmail())
            .build();



    }

    //!!! update
    public ResponseMessage<CustomerResponse> updateCustomer(Integer id, CustomerRequest request) {



        Customer customer = customerRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format(Messages.CUSTOMER_NOT_FOUND,id)));


        fieldControl.checkDuplicate(request.getEmail());


        Customer updatedCustomer = createUpdatedCustomer(request,id);

        Customer savedCustomer = customerRepository.save(updatedCustomer);


        return ResponseMessage.<CustomerResponse>builder()
                .message(String.format("%s ID 'li Müşteri Güncellendi.",id))
                .object(createCustomerResponse(savedCustomer))
                .httpStatus(HttpStatus.OK)
                .build();






    }


    //dto-pojo for update method

    public Customer createUpdatedCustomer(CustomerRequest request, Integer id ){

        return Customer.builder().
                id(id).
                firstName(request.getFirstName()).
                lastName(request.getLastName()).
                email(request.getEmail()).
                build();



    }

    //!!! DELETE
    public ResponseMessage<CustomerResponse> deleteCustomer(Integer id) {

       Customer customer =  customerRepository.findById(id).orElseThrow(()->
               new NotFoundException(String.format(Messages.CUSTOMER_NOT_FOUND,id)));

        customerRepository.deleteById(id);

        return ResponseMessage.<CustomerResponse>builder()
                .message(String.format("%s ID 'li müşteri Silindi.",id ))
                .object(createCustomerResponse(customer))
                .build();


    }

    //!!! GETALL
    public ResponseMessage<List<CustomerResponse>> getAllCustomer() {

        return ResponseMessage.<List<CustomerResponse>>builder()
                .object(customerRepository.findAll()
                .stream()
                .map(this::createCustomerResponse)
                .collect(Collectors.toList()))
                .message("Tüm Müşteriler Getirildi.")
                .httpStatus(HttpStatus.OK)
                .build();

    }


    // GetById
    public ResponseMessage<CustomerResponse> getCustomerById(Integer id) {

        Customer customer = customerRepository.findById(id).orElseThrow(()->
                new NotFoundException(String.format(Messages.CUSTOMER_NOT_FOUND,id)));


        return ResponseMessage.<CustomerResponse>builder()
                .object(createCustomerResponse(customer))
                .message(String.format("%s ID 'li Müşteri Getirildi.",id))
                .httpStatus(HttpStatus.OK).build();


    }
}
