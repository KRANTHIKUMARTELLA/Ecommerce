package com.ecommerce.controller;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.requestwrapper.UserRegistrationRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private final UserService userService;

    public AdminController(UserService userService){
        this.userService=userService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        userService.registerUser(request, "ROLE_ADMIN");
        return ResponseEntity.ok("Admin registered successfully!");
    }

    @GetMapping("/get")
    public void getAdmin(){
        System.out.println("This is admin");
    }

}
