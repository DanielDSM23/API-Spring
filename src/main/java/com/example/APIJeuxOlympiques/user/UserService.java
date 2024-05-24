package com.example.APIJeuxOlympiques.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;
    @Autowired
    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    public boolean addNewUser(User user){
        if(userRepo.findUserByEmail(user.getEmail()).isEmpty()){
            userRepo.save(user);
            return true;
        }
       else{
            return false;
        }
    }

    public boolean deleteAccount(User user){
        Optional<User> userToDelete = userRepo.findUserByEmail(user.getEmail());
        if(userToDelete.isEmpty()){
           return false;
        }
        userRepo.deleteById(userToDelete.get().getId());
        return true; //manage purchases : TODO
    }


    public boolean editAccount(User user){
        Optional<User> userToEdit = userRepo.findUserByEmail(user.getEmail());
        if(userToEdit.isEmpty()){
            return false;
        }
        if(user.getFullName()!=null){
            userToEdit.get().setFullName(user.getFullName());
        }
        // replace password : TODO
        userRepo.save(userToEdit.get());
        return true;
    }

}
