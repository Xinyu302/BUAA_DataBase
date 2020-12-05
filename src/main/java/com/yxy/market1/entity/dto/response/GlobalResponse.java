package com.yxy.market1.entity.dto.response;

//import lombok.Getter;
//import lombok.Setter;

/**
 * 统一 Json 范围实体类
 *
 * @author James
 */
//@Getter
//@Setter
public class GlobalResponse {

  protected int resultCode;
  protected boolean hasError;

  private GlobalResponse() {

  }

  public GlobalResponse(int resultCode, boolean hasError) {
    this.resultCode = resultCode;
    this.hasError = hasError;
  }

  public int getResultCode() {
    return resultCode;
  }

  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }

  public boolean isHasError() {
    return hasError;
  }

  public void setHasError(boolean hasError) {
    this.hasError = hasError;
  }
}
