// 1단계 - 데스크톱 용 계산기 애플리케이션 만들기
// 개발자는 
package design_pattern.proxy.before1;

public class App {

  public static void main(String[] args) {
      Calculator calc = new Calculator();
      System.out.println(calc.plus(100, 200));
      System.out.println(calc.minus(100, 200));
      
  }

}
