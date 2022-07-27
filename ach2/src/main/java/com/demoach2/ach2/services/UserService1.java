package com.demoach2.ach2.services;

import com.demoach2.ach2.entity.User1;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService1 {

    public Optional<User1> getUserById(Integer id);
    public void createUserACH(User1 user1);
    public void updateUserACH(User1 user1);
    public void deleteById(Integer id);
    public List<User1> getUsersBetweenDates(LocalDate des, LocalDate has);
}
