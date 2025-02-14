package br.com.cleanarchitecture.infrastructure.api.controller;

import br.com.cleanarchitecture.usecase.customer.create.CreateCustomerUseCase;
import br.com.cleanarchitecture.usecase.customer.create.InputCreateCustomerDto;
import br.com.cleanarchitecture.usecase.customer.create.OutputCreateCustomerDto;
import br.com.cleanarchitecture.usecase.customer.findAll.FindAllCustomerUseCase;
import br.com.cleanarchitecture.usecase.customer.findAll.OutPutFindAllListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase();
    @Autowired
    FindAllCustomerUseCase findAllCustomerUseCase;

    @PostMapping
    private ResponseEntity<OutputCreateCustomerDto> createCustomer(@RequestBody InputCreateCustomerDto inputCreateCustomerDto){
        try {
            return ResponseEntity.ok(createCustomerUseCase.execute(inputCreateCustomerDto));
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("list")
    private ResponseEntity<OutPutFindAllListDto> findAll(){
        try {
           return ResponseEntity.ok(findAllCustomerUseCase.execute());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
