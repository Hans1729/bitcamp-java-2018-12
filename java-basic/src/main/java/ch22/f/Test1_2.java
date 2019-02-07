// Serialize - Serialize
package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_2 {
  public static void main(String[] args) {
    try(ObjectOutputStream out = new ObjectOutputStream(
              new FileOutputStream("score2.data"))) {
      
         // 인스턴스 출력하기
       
       // Score2 클래스는 java.io.Serialize을 구현하였다.
         // 즉 serialize가 허락된 클래스이다.
         // 이제 writeObect()를 사용하여 객체를 serialize 할수 있다.
      out.writeObject(new Score2("홍길동",100,100,100));
      
      System.out.println("출력 완료!");
       
    }catch (Exception e) {
      e.printStackTrace();
    }

  }
}
