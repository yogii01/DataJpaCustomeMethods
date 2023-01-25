package com.csi.service;

import com.csi.dao.CustomerDao;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDaoImpl;


    public Customer signUp(Customer customer){
        return customerDaoImpl.signUp(customer);
    }

    public Boolean signIn(String custEmailId, String custPassword){
        return customerDaoImpl.signIn(custEmailId, custPassword);
    }

    public List<Customer> getAllData(){
        return customerDaoImpl.getAllData();
    }

    public List<Customer> getDataByCustName(String custName){
        return customerDaoImpl.getDataByCustName(custName);
    }

    public Optional<Customer> getDataById(int custId){
        return customerDaoImpl.getDataById(custId);
    }

    public List<Customer> getDataByCustDOB(String custDOB) throws ParseException {
        return customerDaoImpl.getDataByCustDOB(custDOB);
    }

    public Customer getDataByCustContactNumber(long custContactNumber){
        return customerDaoImpl.getDataByCustContactNumber(custContactNumber);
    }

    public Customer getDataByCustEmailId(String custEmailId){
        return customerDaoImpl.getDataByCustEmailId(custEmailId);
    }

    public List<Customer> getDataByCustAnyInput(String input){
        return customerDaoImpl.getDataByCustAnyInput(input);
    }

    public List<Customer> sortByCustName(){
        return customerDaoImpl.sortByCustName();
    }

    public List<Customer> sortByCustId(){
        return customerDaoImpl.sortByCustId();
    }

    public List<Customer> sortByCustSalary(){
        return customerDaoImpl.sortByCustSalary();
    }

    public List<Customer> sortByCustDOB(){
        return customerDaoImpl.sortByCustDOB();
    }

    public List<Customer> sortByCustAge(){
        return customerDaoImpl.sortByCustAge();
    }

    public List<Customer> filterDataByCustSalary(double custSalary){
        return customerDaoImpl.filterDataByCustSalary(custSalary);
    }

    public boolean isEligibleForLoan(int custId){
       return customerDaoImpl.isEligibleForLoan(custId);
    }

    public List<Customer> sortNameByDescendingOrder(){
        return customerDaoImpl.sortNameByDescendingOrder();
    }

    public List<Customer> sortSalaryByDescendingOrder(){
        return customerDaoImpl.sortSalaryByDescendingOrder();
    }

    public boolean isEligibleForPromotion(int custId){
        return customerDaoImpl.isEligibleForPromotion(custId);
    }

    public Customer updateData(Customer customer){
        return customerDaoImpl.updateData(customer);
    }

    public void  deleteDataById(int custId){
        customerDaoImpl.deleteDataById(custId);
    }

    public void deleteAllData(){
        customerDaoImpl.deleteAllData();
    }
}
