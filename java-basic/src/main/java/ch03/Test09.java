// 키보드로 입력한 값을 받기 IV -
package ch03;

public class Test09 {
  public static void main(String[] args) {

    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    System.out.println("나이 :");
    int age = keyboard.nextInt();
    // nextInt()는 한 개의 토근을 읽은 후에 줄 바꿈 코드는 읽기 전 상태로 내비둔다.
     // 따라서 다음에 nextLine()을 호출하면 의도치 않게 빈 문자열을 가진 한줄을
     // 읽는 상황이 된다.
    // nextInt() 다음에 nextLine()을 호출할 때 이런 상황이 발생한다.
    //  해결 방법? nextInt()를 호출한 후 남아있는 엔터 코드를 읽어서 제거하라
    keyboard.nextLine();//남아 있는 빈 문자열의 한 줄(LF 코드)을 읽어서 버린다.
    System.out.println("이름? ");
    java.lang.String name = keyboard.nextLine();// java.lang 패키지의 멤버를 사용할 때는
    // 패키지 이름을 적지 않아도 된다


    System.out.printf("%d(%s)\n", age, name);
  }
}
