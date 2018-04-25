package com.zeal.shiyulin.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ZealExceptionErrorInfo {

  private String message;
  private String exception;

  public ZealExceptionErrorInfo(String message, Exception ex) {
      this.message = message;
      if (ex != null) {
        this.exception = ex.getLocalizedMessage();
      }
  }

  public String getMessage() {
      return message;
  }

  public void setMessage(String message) {
      this.message = message;
  }
  
  public void setException(String exception) {
      this.exception = exception;
  }
  
  @JsonInclude(Include.NON_NULL)
  public String getException() {
      return exception;
  }
}
