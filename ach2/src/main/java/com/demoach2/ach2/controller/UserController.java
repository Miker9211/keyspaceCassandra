package com.demoach2.ach2.controller;

import com.demoach2.ach2.entity.User1;
import com.demoach2.ach2.services.UserService1Imp1;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService1Imp1 userServiceImp;

    @GetMapping("/get_user/{id}")
    public ResponseEntity<Optional<User1>> getUserAchById(@PathVariable(name = "id") int id){
          return ResponseEntity.ok(userServiceImp.getUserById(id));
    }

    @PostMapping("/create_user")
    @ResponseStatus(value = HttpStatus.OK)
    public void createUserAch(@RequestBody User1 user1){
        userServiceImp.createUserACH(user1);
    }

    @PatchMapping("/update_user")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateUserAch(@RequestBody User1 user1){
        userServiceImp.updateUserACH(user1);
    }

    @DeleteMapping("/delete_user/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUserAch(@PathVariable(name = "id") Integer id){
        userServiceImp.deleteById(id);
    }

    @GetMapping("/get_users_by_date")
    public ResponseEntity<List<User1>> getUsersAchByDate(
            @RequestParam(name = "since") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate des,
            @RequestParam(name = "until") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate has){
        return ResponseEntity.ok(userServiceImp.getUsersBetweenDates(des,has));
    }

}
