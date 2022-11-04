package com.example.bswebdemo.BSController;

import com.example.bswebdemo.BSEntity.User;
import com.example.bswebdemo.BSService.ServiceIm.ImService;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(value = "http://localhost:8080",maxAge = 1800,allowedHeaders = "*")
public class WenPhoneController {

    @Autowired
    ImService service;

    public String Inint(){
        return "PhoneIndex";
    }
    public String index(){
        return "PhoneIndex";
    }

    @GetMapping(value = {"/PhoneIndex.html","/"})
    public String firstInitial(){
        System.out.println("访问了");
        return "PhoneIndex";
    }

    @RequestMapping(value = "/obtainUsers",method = RequestMethod.GET)
    public @ResponseBody List<User> obtainUsers(Model model){
        System.out.println("我被访问了");
        List<User> userList = service.getAllUsers();
        model.addAttribute("userList",userList);
        return userList;
    }

    @GetMapping(value = {"/add"})
    public String add(){
        System.out.println("addye");
        return "add";
    }

    @RequestMapping( value = {"/main"},method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "username") String username,@RequestParam(value = "userphone") String userphone){
        User user = new User();
        user.setUsername(username);
        user.setUserphone(userphone);
        service.addUser(user);
        return "PhoneIndex";
    }

    @PostMapping("/search")
    public @ResponseBody List<User> getUser(Model model,@RequestBody String text){

        String now = text.replace("=","");
        List<User> userList = service.getSomeUsers(now);
        model.addAttribute("userList",userList);
        return userList;
    }

    @PostMapping("/delete")
    public @ResponseBody List<User> deleteUser(@RequestBody User user){
        System.out.println(user);
        service.deleteUser(user);
        return service.getAllUsers();
    }

    @RequestMapping(value = "alter",method = {RequestMethod.GET,RequestMethod.POST})
    public String alterUser(){
        System.out.println("alter");
        return  "alter";
    }

    //获取当前user
    private User temp = new User();
    @PostMapping("/postmsg")
    public @ResponseBody List<User> setMsg(Model model,@RequestBody User user){
        temp = user;
        System.out.println("posted");
        return null;
    }

    @PostMapping("/getAlter")
    public String returnThePage(@RequestParam(value = "username")String username,
                                @RequestParam(value = "userphone") String userphone){

        if(username.equals("") || username==null || userphone.equals("") || userphone==null){
            return "alter";
        }else {
            service.alter(temp,username,userphone);
            return "PhoneIndex";
        }
    }

}
