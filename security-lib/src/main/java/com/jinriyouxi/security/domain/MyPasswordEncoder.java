package com.jinriyouxi.security.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class MyPasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(CharSequence charSequence) {
    return charSequence.toString();
  }

  @Override
  public boolean matches(CharSequence charSequence, String encodedPassword) {
    if (encodedPassword != null && encodedPassword.length() != 0) {
      if (charSequence.toString().equals(encodedPassword)) {
        return true;
      } else {
        return false;
      }
    } else {
      log.warn("Empty encoded password");
      return false;
    }
  }
}
