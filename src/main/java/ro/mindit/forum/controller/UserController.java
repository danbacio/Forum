package ro.mindit.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.mindit.forum.domain.User;
import ro.mindit.forum.service.UserService;

@Controller
@CrossOrigin
@RequestMapping("forum/user")

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.GET)
    public ResponseEntity<Object> loginUser(@RequestParam String userName, @RequestParam String password) {

        User user = userService.getUserByUserNameAndPassword(userName, password);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }

    }

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@RequestBody User user) {

        String responseMessage = null;
        Boolean isSuccessful = userService.registerUser(user);
        if (isSuccessful) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}