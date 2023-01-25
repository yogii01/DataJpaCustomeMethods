package com.csi.repo;

import com.csi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    public List<Customer> findByCustName(String custName);

    public Customer findByCustContactNumber(long custContactNumber);

    public Customer findByCustEmailId(String custEmailId);


}
