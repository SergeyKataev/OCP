package com.defaultIMPL.braine;

import java.util.spi.AbstractResourceBundleProvider;

public class Computer {
  public static Number compute(Number left, String ops, Number right) {
    Number res = 0;
    switch (ops) {
      case ("+"):
        res = (long) left + (long) right;
        break;
      case ("-"):
        res = (long) left - (long) right;
        break;
      case ("/"):
        res = (long) left / (long) right;
        break;
      case ("*"):
        res = (long) left * (long) right;
        break;
      case ("%"):
        res = (long) left % (long) right;
        break;
      default:
        throw new IllegalArgumentException();
    }
    return res;
  }
}
