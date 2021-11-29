package com.defaultIMPL.input;

import java.util.Objects;

public final class Parser {
  private String[] args = null;

  public Parser(String... args) {
    this.args = args;
  }

  public String[] args() {
    return args;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Parser) obj;
    return Objects.equals(this.args, that.args);
  }

  @Override
  public int hashCode() {
    return Objects.hash(args);
  }

  @Override
  public String toString() {
    return "Parser[" +
            "args=" + args + ']';
  }

  public Parser() {
    validate(args);
  }

  void validate(String... args) {
    if (args.length != 3 || ("0".equals(args[2]) && ("/".equals(args[1]) || "%".equals(args[1])))) {
      throw new ArithmeticException();
    }
  }

  public Number getLeft() {
    return Long.valueOf(args[0]);
  }

  public Number getRight() {
    return Long.valueOf(args[2]);
  }

  public String getOps() {
    return args[1];
  }
}
