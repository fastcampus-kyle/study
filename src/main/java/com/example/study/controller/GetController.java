package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

  @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
  public String getReqeust() {

    return "Hi getMethod";
  }

  @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=1234&password=abcd
  public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
    String password = "bbbb";

    System.out.println("id : " + id);
    System.out.println("password : " + pwd);
    return id + pwd;
  }

  // localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
  @GetMapping("/getMultiParameter")
  public SearchParam getMultiParameter(SearchParam searchParam){
    System.out.println(searchParam.getAccount());
    System.out.println(searchParam.getEmail());
    System.out.println(searchParam.getPage());

    return searchParam;
  }

  @GetMapping("/header")
  public Header getHeader(){
    return Header.builder().resultCode("OK").description("OK").build();
  }

}