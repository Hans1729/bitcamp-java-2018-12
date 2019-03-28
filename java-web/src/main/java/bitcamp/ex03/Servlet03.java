// 클라이언트로 출력하기 - HTML 현상 처리 
package bitcamp.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/ex03/s3")
public class Servlet03 extends GenericServlet {
    
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
     // HTML 출력할 때 MIME 타입에 HTML을 지정하지 않으면
       //      일반 텍스트 그래도 출력한다.
    res.setContentType("text/html; charset=UTF-8"); // UTF16 ==> UTF-8
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>Servlet03</title>");
    out.println("<body><h1>안녕하세요</h1></body>");
    out.println("</head></html>");
  }
  
}








