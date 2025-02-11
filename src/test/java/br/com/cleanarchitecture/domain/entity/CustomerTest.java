package br.com.cleanarchitecture.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void deveLancarExcecaoQuandoIdEstiverVazio(){
        RuntimeException exception = assertThrows(RuntimeException.class, () ->{
            new Customer("","Vinicius");
        });
        assertEquals("Id is required", exception.getMessage());
    }
    @Test
    void deveLancarExcecaoQuandoNameEstiverVazio(){
        RuntimeException exception = assertThrows(RuntimeException.class, () ->{
            new Customer("1","");
        });
        assertEquals("Name is required", exception.getMessage());
    }
    @Test
    void deveLancarExcecaoQuandoChangeNameIsBlank(){
        Customer customer = new Customer("1","Vinicius");
        RuntimeException exception = assertThrows(RuntimeException.class, () ->{
            customer.changeName("");
        });
        assertEquals("Name is required", exception.getMessage());
    }

    @Test
    void deveAlterarNameQuandoChangeNameEstiverPreenchido(){
        Customer customer = new Customer("1","Vinicius");

        customer.changeName("Fran");

        assertEquals("Fran", customer.getName());
    }

    @Test
    void deveAtivarClienteComEnderecoPreenchido(){
        Customer customer = new Customer("1","Vinicius");
        Address address = new Address("Teste rua", 1,"23000-00","Rio de Janeiro");
        customer.setAddress(address);

        customer.activate();

        assertTrue(customer.isActive());
    }

    @Test
    void deveLancarExcemptionQuandoEnderecoNaoForPreenchido(){

        RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
            Customer customer = new Customer("1","Vinicius");
            customer.activate();
        });


        assertEquals("Address is mandatory to activate a customer",exception.getMessage());
    }

    @Test
    void deveDesativarOClienteQuandoSolicitado(){
        Customer customer = new Customer("1","Vinicius");

        customer.deactivate();

        assertFalse(customer.isActive());
    }

}