package bitcamp.ex05;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MyHttpServlet 클래스를 
//serive(HttpServletRequest request, HttpServletResponse response) 를 추가하였다
// 따라서 GenericServlet을 상속 받아 서블릿을 만들기 보다
// 이 클래스를 상속 받아 서블릿을 만든다면,
// 훨씬 편하게 service()를 구현할 수 있다
@SuppressWarnings("serial")
public abstract class MyHttpServlet extends GenericServlet{

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    
   HttpServletRequest request = (HttpServletRequest) req;
   HttpServletResponse response =(HttpServletResponse) res;
   
   // 오버로딩한 service()를 호출한다.
   this.service(request, response);
  }
  protected void service(HttpServletRequest request, HttpServletResponse response) 
  throws ServletException, IOException{
    // 웹 브라우저가 요청하면
    // => 서블릿 컨테이너가 service(HttpServletRequest , HttpServletResponse)를 호출한다.
    // => 이 메서드는 다시 오버로딩한(HttpServletRequest , HttpServletResponse)는
    //    다시 오버로딩한 이 메서드를 호출한다.
    //   현재 아무런 일을 하지 않는다.
    //   이 클래스를 상속 받는 서브 클래스 쪽에서 이 메서드를 오버라이딩 하면 된다.
    
  }
}