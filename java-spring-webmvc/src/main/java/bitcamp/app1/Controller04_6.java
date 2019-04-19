// 요청 핸들러의 아규먼트 - @RequestHeader
package bitcamp.app1;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c04_6")
public class Controller04_6 {

  // 클라이언트의 HTTP 요청 헤더를 받고 싶으면
 // Request handler의 아규먼트 앞에 @RequestHeader(헤더명) 애노테이션을 붙여라!
  
  

  // 테스트:
  // http://.../c04_6/h1?model=sonata&capacity=5&auto=true&createdDate=2019-4-19
  @GetMapping("h1")
  @ResponseBody
  public void handler1(PrintWriter out,
      @RequestHeader("Accept") String accpet,
      @RequestHeader("User-Agent") String userAgent
  ) {

    out.printf("Accept=%s\n", accpet);
    out.printf("User-Agent=%s\n", userAgent);
    
    if(userAgent.matches(".*Chrome.*")) {
      out.println("chrome");
    }else if (userAgent.matches(".*Safari.*")) {
      out.println("safari");
    }else if(userAgent.matches(".*Firefox.*")) {
      out.println("Firefox");
    }else {
      out.println("etc");
    }
    

  }
  public static void main(String[] args) {
    String str = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36\n" + 
        "false";
    
    String regex ="...";
    Matcher matcher = Pattern.compile(regex);
    
    if(matcher.find()) {
      for(int i =0 ; i< matcher.groupCount(); i++) {
        System.out.println(matcher.group(i));
      }
    }
    
  }
 
}


