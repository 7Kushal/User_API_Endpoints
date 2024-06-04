package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestControllerg
@RequestMapping("/v1")
public class controller {

    private static final User USER_NOT_FOUND = new User();
    List<User> userList;
    public controller(){
        userList = new ArrayList<>();
        userList.add(new User("kushal","23134",25,"afsaf@gmail.com"));
        userList.add(new User("Nikhil","43534",26,"asdada@gmail.com"));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User u1){
        userList.add(u1);
        return ResponseEntity.status(HttpStatus.CREATED).body(u1);
    }

    @GetMapping("users/{name}")
    public ResponseEntity<User> userAddByName(@PathVariable String name){
        for (User u : userList){
            if(u.getName().equals(name))
                return ResponseEntity.ok(u);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(USER_NOT_FOUND);
    }

    @PutMapping("users/{name}")
    public ResponseEntity<User> putUser(@PathVariable("name") String name, @RequestBody User u1){
        for(User u : userList){
            if(u.getName().equals(name)) {
//             userList.remove(u);
                u.setAge(u1.getAge());
                u.setEmail(u1.getEmail());
                u.setPassword(u1.getPassword());
            }
        }
//        userList.add(u1);
        return ResponseEntity.status(HttpStatus.CREATED).body(u1);
    }

    @PatchMapping("users/{name}")
    public ResponseEntity<User> patchUser(@PathVariable("name") String name, @RequestParam(required = false) String email){
        for(User u : userList){
            if(u.getName().equals(name)) {
//             userList.remove(u);
                u.setEmail(email);
//                u.setPassword(u1.getPassword());
                return ResponseEntity.ok(u);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(USER_NOT_FOUND);
    }
}
