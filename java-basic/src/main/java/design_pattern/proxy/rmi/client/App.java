// 4단계 - RMI 기술을 사용하여 C/S 계산기 어플리케이션 만들기
// => RMI Registry 서버에 등록된 스텁을 받아서 원격의 CalculatorImpl 
//  
package design_pattern.proxy.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import design_pattern.proxy.rmi.server.Calculator;

public class App {

  public static void main(String[] args) throws Exception{
    Scanner keyboard = new Scanner(System.in);

     
    // RMI 기술을 사용하면 개발자가 skeleton이나 stub 객체를 직접 작성할 필요가 없다.
    // RMI Registry
     // 
    
    Registry registry = LocateRegistry.getRegistry("study.bitcamp.co.kr");
    // 2) 이 도구를 사용하여 RMI Registry 서버에 등록된 스텝을 등록된
    Calculator calc = (Calculator) registry.lookup("calc");
    
    while(true) {
      System.out.println("계산 식 >(예: 100 + 200) ");
      String input = keyboard.nextLine();
      if(input.equalsIgnoreCase("quit"))
        break;

      String[] values= input.split(" ");
      try {
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[2]);
        String op=values[1]; 
        switch(op) {
          case"+" : System.out.println(calc.plus(a,b)); break;
          case"-" : System.out.println(calc.minus(a,b)); break;
          default:
            System.out.println("해당 연산자를 지원하지 않습니다");
        }

      }catch (Exception e) {
        System.out.println("식 또는 계산 오류 " + e.getMessage());
      }
    }



  }

}
