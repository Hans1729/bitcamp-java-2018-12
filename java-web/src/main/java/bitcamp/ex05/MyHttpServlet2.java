package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//MyHttpServlet 클래스를 사용하여 서블릿을 만드는 것도 편하지만
//여기에다가 HTTP 요청 방식에 따라 메서드를 구분해 놓는다면
//서브 클래스를 만들기가 더 편리할 것이다.
@SuppressWarnings("serial")
public abstract class MyHttpServlet2 extends GenericServlet{

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
 
    String httpMethod = request.getMethod();
      
    switch (httpMethod) {
      case "GET": doGet(request , response); return;
      case "POST":doPost(request , response); return;
      case "PUT": doPut(request , response); return;
      case "HEAD":doHead(request , response); return;
      default:
        error(request,response);
     
    }
  }
  
    
  protected void doGet(HttpServletRequest request, HttpServletResponse response)    
      throws ServletException, IOException{
    error(request, response);
    
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)   
      throws ServletException, IOException{
    error(request, response);
    
  }
  
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
      error(request, response);
    
  }
    
    protected void doHead(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
          error(request, response);
      
    }
    private void error(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
      request.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.println("해당 요청을 처리 할 수 없습니다.");
      
    }
    
  }

