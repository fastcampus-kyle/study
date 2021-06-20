package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

  @Override
  @PostMapping("")
  public Header<UserApiResponse> create(@RequestBody UserApiRequest userApiRequest) {
    return null;
  }

  @Override
  @GetMapping("{id}")
  public Header<UserApiResponse> read(@PathVariable Long id) {
    return null;
  }

  @Override
  @PutMapping("")
  public Header<UserApiResponse> update(@RequestBody UserApiRequest userApiRequest) {
    return null;
  }

  @Override
  @DeleteMapping("{id}")
  public Header delete(@PathVariable Long id) {
    return null;
  }
}
