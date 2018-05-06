 package com.qianhe.controller;
 
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 

 @Controller
 public class ContactController{
 
   @RequestMapping({"/contact"})
   public String contactIndex(){
     return "contact";
   }
   
 }

