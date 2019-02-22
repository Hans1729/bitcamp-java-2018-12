package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class AbstractCommand implements Command {
 
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    execute(new Request(in), new Response(out));
  }
  
  public void execute(Request request, Response response) {
   }
}
