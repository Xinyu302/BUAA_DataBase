package com.yxy.market1.entity.dto.response;

//import lombok.Getter;
//import lombok.Setter;

/**
 * 登录返回 Json
 *
 * @author James
 */
//@Setter
//@Getter
public class RedirectResponse extends GlobalResponse {

  private String redirectURL;

  public RedirectResponse(int resultCode, boolean hasError, String redirectURL) {
    super(resultCode, hasError);
    setRedirectURL(redirectURL);
  }

  public String getRedirectURL() {
    return redirectURL;
  }

  public void setRedirectURL(String redirectURL) {
    this.redirectURL = redirectURL;
  }
}
