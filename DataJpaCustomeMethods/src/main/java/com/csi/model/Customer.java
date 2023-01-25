package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue

    private int custId;

    private String custName;

    private String custAddress;

    private long custContactNumber;

    private double custSalary;

    private int custAge;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    @Temporal(TemporalType.DATE)
    private Date custDOB;

    private String custEmailId;

    private String custPassword;


}
