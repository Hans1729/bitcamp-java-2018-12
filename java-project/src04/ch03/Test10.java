// 키보드로 입력한 값을 받기 V - 토근 단위로 문자열 읽기
package ch03;

public class Test10 {
  public static void main(String[] args) {

    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    System.out.println("나이 :");
    int age = keyboard.nextInt();
    System.out.println("이름? ");
    java.lang.String name = keyboard.next();
    // next()는 토근 단위로 문자열을 읽는다.
    // nextInt()를 호출한 후 엔터 코드(LF)를 읽는다.
    // next()는 공백을 버리기 때문에 영향을 받지 않는다.
    
    System.out.printf("%d(%s)\n", age, name);
  }
}