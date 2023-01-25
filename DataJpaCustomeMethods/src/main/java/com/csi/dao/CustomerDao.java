package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CustomerDao {

    @Autowired
    CustomerRepo customerRepoImpl;

    public Customer signUp(Customer customer) {
        return customerRepoImpl.save(customer);
    }

    public Boolean signIn(String custEmailId, String custPassword) {
        boolean flag = false;
        for (Customer customer : customerRepoImpl.findAll()) {
            if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
                flag = true;
            }
        }
        return flag;
    }

    public List<Customer> getAllData() {
        return customerRepoImpl.findAll();
    }

    public List<Customer> getDataByCustName(String custName) {
        return customerRepoImpl.findByCustName(custName);
    }

    public Optional<Customer> getDataById(int custId) {
        return customerRepoImpl.findById(custId);
    }

    public List<Customer> getDataByCustDOB(String custDOB) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dddUI = new Date();

        try {
            dddUI = simpleDateFormat.parse(custDOB);
        } catch (ParseException ex) {
            //  ex.printStackTrace();
        }
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : getAllData()) {
            Customer customer1 = new Customer();
            if (customer.getCustDOB().compareTo(dddUI) == 0) {
                customer1 = customer;

               customerList.add(customer1);
            }
        }

        return customerList;
    }


    public Customer getDataByCustContactNumber(long custContactNumber){
        return customerRepoImpl.findByCustContactNumber(custContactNumber);
    }

    public Customer getDataByCustEmailId(String custEmailId){
        return customerRepoImpl.findByCustEmailId(custEmailId);
    }

    public List<Customer> getDataByCustAnyInput(String input){


        List<Customer> list = new ArrayList<>();

        for (Customer customer: customerRepoImpl.findAll()){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date custDob1 = new Date();

            try {
                custDob1 = simpleDateFormat.parse(input);
            } catch (ParseException ex) {
                //  ex.printStackTrace();
            }
            if(customer.getCustName().equals(input)
            || String.valueOf(customer.getCustId()).equals(input)
            || customer.getCustEmailId().equals(input)
            || String.valueOf(customer.getCustContactNumber()).equals(input)
            || String.valueOf(customer.getCustAge()).equals(input)
            || customer.getCustDOB().compareTo(custDob1)==0){
                list.add(customer);
            }
        }
        return list;
    }

    public List<Customer> sortByCustName(){
        return getAllData().stream().sorted((e1,e2)-> e1.getCustName().compareTo(e2.getCustName())).collect(Collectors.toList());
    }

    public List<Customer> sortByCustId(){
        return getAllData().stream().sorted(Comparator.comparingInt(Customer :: getCustId)).collect(Collectors.toList());
    }

    public List<Customer> sortByCustSalary(){
        return getAllData().stream().sorted(Comparator.comparingDouble(Customer :: getCustSalary)).collect(Collectors.toList());
    }

    public List<Customer> sortByCustDOB(){
        return getAllData().stream().sorted((e1, e2)-> e1.getCustDOB().compareTo(e2.getCustDOB())).collect(Collectors.toList());
    }

    public List<Customer> sortByCustAge(){
        return getAllData().stream().sorted(Comparator.comparingInt(Customer :: getCustAge)).collect(Collectors.toList());
    }

    public List<Customer> filterDataByCustSalary(double custSalary){
        return getAllData().stream().filter(customer -> customer.getCustSalary() >=custSalary).collect(Collectors.toList());
    }

    public boolean isEligibleForLoan(int custId){
        boolean flag = false;
        for(Customer customer : customerRepoImpl.findAll()){
            if(customer.getCustId() == custId && customer.getCustSalary()>=50000){
                flag = true;
            }
        }
        return flag;
    }

    public List<Customer> sortNameByDescendingOrder(){
        return customerRepoImpl.findAll().stream().sorted((e1,e2)-> e2.getCustName().compareTo(e1.getCustName())).collect(Collectors.toList());
    }

    public List<Customer> sortSalaryByDescendingOrder(){
        return customerRepoImpl.findAll().stream().sorted(Comparator.comparingDouble(Customer :: getCustSalary).reversed().thenComparing(Customer :: getCustName)).collect(Collectors.toList());
    }

    public boolean isEligibleForPromotion(int custId){
        boolean flag = false;
        for (Customer customer: customerRepoImpl.findAll()){
            if(customer.getCustId() == custId && customer.getCustAge()>=20){
                flag = true;
            }
        }
        return flag;
    }

    public Customer updateData(Customer customer){
        return customerRepoImpl.save(customer);
    }

    public void  deleteDataById(int custId){
        customerRepoImpl.deleteById(custId);
    }

    public void deleteAllData(){
        customerRepoImpl.deleteAll();
    }
}
