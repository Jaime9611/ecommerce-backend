package com.example.ecommerce.utils.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResponseDTO {
  public String status;
  public String message;
  public Object data;

}
