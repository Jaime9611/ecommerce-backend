package com.example.ecommerce.controllers.v1;

import com.example.ecommerce.utils.constants.Endpoints;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.PRODUCT_ENDPOINT)
public class ProductController {
  
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public String getMessage() {
    return "This is a message";
  }
}
