package com.demoach2.ach2.services;

import com.demoach2.ach2.entity.User1;
import com.demoach2.ach2.repository.UserRepository1;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService1Imp1 implements UserService1 {

    private final UserRepository1 userRepository1;

    @Override
    public Optional<User1> getUserById(Integer id) {
        return Optional.ofNullable(userRepository1.findById(id).orElseThrow(() -> new NotFoundException("User1 not Found")));
    }

    @Override
    public void createUserACH(User1 user1) {
        List<User1> user1Find = (List<User1>) userRepository1.findAll();

        var userList = user1Find.stream().map(x -> x.getPhone());
        var repeated = (userList.filter(x -> x.contains(user1.getPhone()))).collect(Collectors.toList());

        if(repeated.size() <= 0){
            userRepository1.save(user1);
        }
    }

    @Override
    public void updateUserACH(User1 user1) {
        Optional<User1> userFound = Optional.ofNullable(userRepository1.findById(user1.getId())
                .orElseThrow(() -> new NotFoundException("User1 not Found")));

        userFound.get().setPhone(user1.getPhone());
        userFound.get().setAddress(user1.getAddress());
        userFound.get().setName(user1.getName());
        userFound.get().setCiiu(user1.getCiiu());
        userFound.get().setEmail(user1.getEmail());
        userFound.get().setState(user1.getState());
        userFound.get().setUser_activation_status(user1.getUser_activation_status());

        userRepository1.save(userFound.get());
    }

    @Override
    public void deleteById(Integer id) {
        Optional<User1> userFind = Optional.ofNullable(userRepository1.findById(id)
                        .orElseThrow(() -> new NotFoundException("User1 not Found.")));

        if(userFind.isPresent()){
            userFind.get().setState("0");
            userRepository1.save(userFind.get());
        }
    }

    @Override
    public List<User1> getUsersBetweenDates(LocalDate des, LocalDate has) {
        List<User1> user1List = userRepository1.findByCreation_dateBetween(des, has);

        if(user1List.isEmpty()){
            throw new NotFoundException("Not Found Exception");
        }

        return user1List;
    }
}
