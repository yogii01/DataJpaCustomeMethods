package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@RequestBody Customer customer){
        return ResponseEntity.ok(customerServiceImpl.signUp(customer));
    }

    @GetMapping("/signIn/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId, @PathVariable String custPassword){
        return ResponseEntity.ok(customerServiceImpl.signIn(custEmailId, custPassword));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>> getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @GetMapping("/getdatabycustname/{custName}")
    public ResponseEntity<List<Customer>> getDataByCustName(@PathVariable String custName){
        return ResponseEntity.ok(customerServiceImpl.getDataByCustName(custName));
    }

    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Optional<Customer>> getDataById(@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/getdatabycustdob/{custDOB}")
    public ResponseEntity<List<Customer>> getDataByCustDOB(@PathVariable String custDOB) throws ParseException {
        return ResponseEntity.ok(customerServiceImpl.getDataByCustDOB(custDOB));
    }

    @GetMapping("/getdatabycustcontactnumber/{custContactNumber}")
    public ResponseEntity<Customer> getDataByCustContactNumber(@PathVariable long custContactNumber){
        return ResponseEntity.ok(customerServiceImpl.getDataByCustContactNumber(custContactNumber));
    }

    @GetMapping("/getdatabycustemailid/{custEmailId}")
    public ResponseEntity<Customer> getDataByCustEmailId(@PathVariable String custEmailId){
        return ResponseEntity.ok(customerServiceImpl.getDataByCustEmailId(custEmailId));
    }

    @GetMapping("/getdatabycustanyinput/{input}")
    public ResponseEntity<List<Customer>> getDataByCustAnyInput(@PathVariable String input){
        return ResponseEntity.ok(customerServiceImpl.getDataByCustAnyInput(input));
    }

    @GetMapping("/sortbycustname")
    public ResponseEntity<List<Customer>> sortByCustName(){
        return ResponseEntity.ok(customerServiceImpl.sortByCustName());
    }

    @GetMapping("/sortbycustid")
    public ResponseEntity<List<Customer>> sortByCustId(){
        return ResponseEntity.ok(customerServiceImpl.sortByCustId());
    }

    @GetMapping("/sortbycustsalary")
    public ResponseEntity<List<Customer>> sortByCustSalary(){
        return ResponseEntity.ok(customerServiceImpl.sortByCustSalary());
    }

    @GetMapping("/sortbycustdob")
    public ResponseEntity<List<Customer>> sortByCustDOB(){
        return ResponseEntity.ok(customerServiceImpl.sortByCustDOB());
    }

    @GetMapping("/sortbycustage")
    public ResponseEntity<List<Customer>> sortByCustAge(){
        return ResponseEntity.ok(customerServiceImpl.sortByCustAge());
    }

    @GetMapping("/filterdatabycustsalary/{custSalary}")
    public ResponseEntity<List<Customer>> filterDataByCustSalary(@PathVariable double custSalary){
        return ResponseEntity.ok(customerServiceImpl.filterDataByCustSalary(custSalary));
    }

    @GetMapping("/iseligibleforloan/{custId}")
    public ResponseEntity<String> isEligibleForLoan(@PathVariable int custId){
        String msg = null;
        if(customerServiceImpl.isEligibleForLoan(custId)){
            msg ="Yes! Eligible For Loan";
        } else {
            msg = "Not Eligible For Loan";
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/sortnamebydescendingOrder")
    public ResponseEntity<List<Customer>> sortNameByDescendingOrder(){
        return ResponseEntity.ok(customerServiceImpl.sortNameByDescendingOrder());
    }

    @GetMapping("/sortsalarybydecendingorder")
    public ResponseEntity<List<Customer>> sortSalaryByDescendingOrder(){
        return ResponseEntity.ok(customerServiceImpl.sortSalaryByDescendingOrder());
    }

    @GetMapping("/iseligibleforpromotion/{custId}")
    public ResponseEntity<String> isEligibleForPromotion(@PathVariable int custId){
        String msg = null;
        if(customerServiceImpl.isEligibleForPromotion(custId)){
            msg = "Yes! Eligible For Promotion";
        }else {
            msg = "Not Eligible For Promotion";
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer> updateData(@PathVariable int custId, @RequestBody Customer customer){
        Customer customer1 = customerServiceImpl.getDataById(custId).orElseThrow(() -> new RecordNotFoundException("Record Not Found"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustSalary(customer.getCustSalary());
        customer1.setCustAge(customer.getCustAge());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());

        return ResponseEntity.ok(customerServiceImpl.updateData(customer1));
    }

    @DeleteMapping("/deletedatabyid/{custId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int custId){
        customerServiceImpl.deleteDataById(custId);
        return ResponseEntity.ok("Delete Data");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        customerServiceImpl.deleteAllData();
        return ResponseEntity.ok("Delete All Data" );
    }




}
