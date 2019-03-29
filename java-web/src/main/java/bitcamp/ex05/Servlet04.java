// HTTP 프로토콜 다루기 - MyHttpServlet2 클래스를 활용 하기
package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex05/s4")
public class Servlet04 extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 테스트
    // - http://localhost:8080/java-web/ex05/test02.html 실행
    //
 
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // HttpServletRequest에는 HTTP 프로토콜의 요청 방식을 리턴하는 메서드가 있다.
    // => HttpServletRequest.getMethod()
    
      out.println("GET 요청입니다.");
      

    }
  
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 테스트
    // - http://localhost:8080/java-web/ex05/test02.html 실행
    //
 
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // HttpServletRequest에는 HTTP 프로토콜의 요청 방식을 리턴하는 메서드가 있다.
    // => HttpServletRequest.getMethod()
    
      out.println("Post 요청입니다.");
      

    }
      
  }



