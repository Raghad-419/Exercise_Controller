package com.example.exercise_controller_bank.Controller;

import com.example.exercise_controller_bank.ApiResponse.ApiResponse;
import com.example.exercise_controller_bank.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new ApiResponse("Customer added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateCustomer(@PathVariable int index ,@RequestBody Customer customer) {
        if(!customers.isEmpty()){
            customers.set(index,customer);
            return new ApiResponse("Customer updated successfully");
        }
        else return new ApiResponse("Customer not found");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index) {
        if(!customers.isEmpty()){
        customers.remove(index);
        return new ApiResponse("Customer deleted successfully");}
        else return new ApiResponse("Customer not found");
    }

@PutMapping("/withdraw/{index}/{amount}")
public ApiResponse Withdraw(@PathVariable int index,@PathVariable double amount) {
if(customers.get(index).getBalance()>=amount){
    customers.get(index).setBalance(customers.get(index).getBalance()-amount);
    return new ApiResponse("Customer withdrawn successfully");
}else return new ApiResponse("Customer balance not enough");
}

@PutMapping("/deposit/{index}/{amount}")
public ApiResponse deposit(@PathVariable int index,@PathVariable double amount) {
        customers.get(index).setBalance(customers.get(index).getBalance()+amount);
        return new ApiResponse("Customer deposited successfully");

}


}
