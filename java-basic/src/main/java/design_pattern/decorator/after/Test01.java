package design_pattern.decorator.after;


public class Test01 {
  public static void main(String[] args) {
    // Decorator 패턴이 적용된 자동을 만들어 써보자.
    //
    // Decorator 디자인 패턴의 목표:
    //   => 기능을 플러그인처럼 붙었다 뗏다를 자유롭게 하기 위함이다.
    
    // 전기차 트럭을 만들어 보자!
    Truck c1 = new Truck();
    Hybrid c2 = new Hybrid(c1);
    c2.run();
    
    System.out.println("-------------------");
    // 만약 Hybrid 이면서 Convertiable 기능을 갖는 자동차를 만들고 싶다면?
    // => Hybrid나 Convertible 둘 중 한 개를 상속 받아서 구현해야 한다.
    // => 하위 클래스는 다른 클래스의 기능을 중복해서 개발해야 한다.
    //
    Comvertible c3 = new Comvertible(c2);
    c3.openRoof(true);
    c3.run();
    
    System.out.println("--------------------");
      //Hybird 기능을 빼고 Sedan에 Comvertible
    Sedan s1 = new Sedan();
    Comvertible c4 = new Comvertible(s1);
    c4.openRoof(true);
    c4.run();
    
    System.out.println("---------------------");
    Dump c5 = new Dump(c4);
    c5.run();
   
    System.out.println("---------------------");
    Dump c6 = new Dump(c3);
    c6.run();
   
  }
}






