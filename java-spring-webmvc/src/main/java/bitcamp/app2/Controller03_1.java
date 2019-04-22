// 세션 다루기 - HttpSession 직접사용하기
package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 이 애노테이션을 붙인다.
@RequestMapping("/c03_1") // 컨트롤러에 URL을 매핑한다.
public class Controller03_1 {

  // 테스트:
  // http:.../app2/c03_1/h1
  @GetMapping(value = "h1", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String handler1(String name , HttpSession session) {
  // HttpSession 객체를 사용하려면 아규먼트로 받아야 한다.
    // 
    session.setAttribute("name", "홍길동");
    session.setAttribute("age", "20");
    
    return "세션에 값을 보관했음";

  } 
  

  // 테스트:
  // http:.../app2/c03_1/h2
  @GetMapping(value = "h2",produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2(HttpSession session) {
  // HttpSession 객체를 사용하려면 아규먼트로 받아야 한다.
    // 

    return String.format("name=%s, age=%s",
          session.getAttribute("name"),
          session.getAttribute("age"));
  } 
  
  // 테스트:
  // http:.../app2/c03_1/h3
  @GetMapping(value = "h3",produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String handler3(HttpSession session) {
  // HttpSession 객체를 사용하려면 아규먼트로 받아야 한다.
    // 
    
      // 세션을 무효화 시켰음
    session.invalidate();
    
    return "세션을 무효화 시켰음";

  } 
 

}
