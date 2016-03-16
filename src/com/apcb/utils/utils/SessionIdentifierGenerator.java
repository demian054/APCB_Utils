/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;

/**
 *
 * @author Demian
 */
import java.security.SecureRandom;
import java.math.BigInteger;

public class SessionIdentifierGenerator {

  public static String nextSessionId() {
    SecureRandom random = new SecureRandom();
    return new BigInteger(130, random).toString(32);
  }
}
