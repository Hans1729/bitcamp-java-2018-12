// load on startup - 서블릿 객체 자동 생성하기(애노테이션으로 설정하기)
package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 클라이언트가 실행을 요청하지 않아도 서블릿을 미리 생성하고 싶다면,
// loadOnStartup 프로퍼티 값을 지정하라.
//      loadOnStartup=실행순서
// 미리 생성할 서블릿이 여러 개 있다면, loadOnStartup에 지정한 순서대로 생성한다.
// 언제 서블릿을 미리 생성하는가?
// => 서블릿이 작업할 때 사용할 자원을 준비하는데 시간이 오래 걸리는 경우
//    웹 애플리케이션을 시작시킬 때 미리 서블릿 객체를 준비한다.
// => 예) DB 연결, 소켓 연결, 필요한 환경 변수 로딩, 스프링 IoC 컨테이너 준비 등
// 
@SuppressWarnings("serial")
@WebServlet("/ex11/s21")
public class Servlet21 extends HttpServlet {
  

 @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   HttpSession session = request.getSession();
   
   session.setMaxInactiveInterval(10);
   
   session.setAttribute("v1", "aaa");
  
  response.setContentType("text/plain;charset=UTF-8");
  PrintWriter out = response.getWriter();
  out.println("/ex11/s21 실행함");

  
 
  }
}

