package com.eomcs.lms.handler;

import java.io.PrintWriter;

public class Response {
  PrintWriter out;
  
   public Response(PrintWriter out) {
     this.out = out;
   }
   
   public void println(String message){
     out.println();
     out.flush();
   }
   
   public void requestValue(String title) {
     out.println(title);
     out.println("!{}!");
     out.flush();
   }
}
