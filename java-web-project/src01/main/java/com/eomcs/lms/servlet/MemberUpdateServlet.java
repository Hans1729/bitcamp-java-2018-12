package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024  * 5)
@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      Member member = new Member();
       
      MemberService memberService = 
          InitServlet.iocContainer.getBean(MemberService.class);         


    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setTel(request.getParameter("tel"));
    
    member.setPhoto(request.getParameter("photo"));
    response.setContentType("text/html; charset=UTF-8"); 
    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>회원 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=list' method='post'>"
        + "</head>");
    out.println("<body><h1>회원 변경</h1>");
    
    if (memberService.update(member) == 0) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");
    } else { 
      out.println("<p>변경했습니다.</p>");
    }
    
    out.println("</body></html>");
  }
  
  
}
