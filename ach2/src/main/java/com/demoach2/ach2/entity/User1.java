package com.demoach2.ach2.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Table(value = "tabledemoach")
@Data
public class User1 {

    @PrimaryKey
    private int id;
    private String phone;
    private String name;
    private String address;
    private String email;
    private int ciiu;
    private String state;
    private String user_activation_status;
    private LocalDate creation_date;
}
