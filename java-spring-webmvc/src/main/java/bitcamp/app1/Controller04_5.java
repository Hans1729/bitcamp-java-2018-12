// 요청 핸들러의 아규먼트 - 프로퍼티 에디터 사용하기
package bitcamp.app1;

import java.io.PrintWriter;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c04_5")
public class Controller04_5 {

  // 다른 페이지 컨트롤러에서 등록한 프로퍼티 에디터는 사용할 수 없다.
  // 각 페이지 컨트롤러 마다 자신이 사용할 프로퍼티 에디터를 등록해야 한다.
  // 따라서 만약 여러 페이지 컨트롤러에서 공통으로 사용하는 프로퍼티 에디터라면
  // 글로벌 프로퍼티 에디터로 등록하는 것이 편하다.
  
  // 글로벌 프로퍼티 에디터 등록하기
  // @ControllerAdvice 애노테이션이 붙은 클래스에서 
  //  @InitBinder 메서드를 정의하면 된다.
  //  => GlobalControllerAdvice 클래스를 참고하라

  // 테스트:
  // http://.../c04_5/h1?model=sonata&capacity=5&auto=true&createdDate=2019-4-19
  @GetMapping("h1")
  @ResponseBody
  public void handler1(PrintWriter out, String model, int capacity, // String ===> int :
                                                                    // Integer.parseInt(String)
      boolean auto, // String ===> boolean : Boolean.parseBoolean(String)
      Date createdDate // 프로퍼티 에디터를 설정하지 않으면 변환 오류 발생
  ) {

    out.printf("model=%s\n", model);
    out.printf("capacity=%s\n", capacity);
    out.printf("auto=%s\n", auto);
    out.printf("createdDate=%s\n", createdDate);
  }

  // 테스트:
  // http://.../c04_5/h2?car=sonata,5,true,2019-4-19
  @GetMapping("h2")
  @ResponseBody
  public void handler2(PrintWriter out,
      // 콤마(,)로 구분된 문자열을 Car 객체로 변환하기?
      // => String ===> Car 프로퍼티 에디터를 등록하면 된다.
      @RequestParam("car") Car car) {

    out.println(car);
  }
  
  // 테스트:
  // http://.../c04_5/h3?engine=bitengine,3500,16
  @GetMapping("h3")
  @ResponseBody
  public void handler3(PrintWriter out,
      // 콤마(,)로 구분된 문자열을 Car 객체로 변환하기?
      // => String ===> Car 프로퍼티 에디터를 등록하면 된다.
      @RequestParam("engine") Engine engine) {

    out.println(engine);
  }
}

