// Serialize - serialVersionUID 
package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test2_1 {
  public static void main(String[] args) {
    
    //deserialize
    //  =>저장할 때 사용한 클래스를 가지고 인스턴스를 만든 후에
    //    바이트 배열을 읽어 인스터스 필드에 그대로 저장한다.
    //   => 생성자는 호출하지 않는다
    try (ObjectOutputStream out =new ObjectOutputStream(
          new FileOutputStream("score2.data"))){
      
      out.writeObject(new Score2("홍길동",100,100,100));
   
      
      //  Score2 클래스를 변경한 후 이 클래스를 이용하여 
      //  serialize 된 데이터를 읽어들이면 예외가 발생한다.
       //    예외 분석:
      //   => java.io.Serializable 구현체는 내부적으로 
      //      serialVersionUID라는 스태틱 변수가 자동으로 생긴다.
      //        serialize 되는 데이터의 파일 버전 역활을 한다.
      //     => serialVersionUID 값을 개발자가 지정하지 않으면
       //           컴파일할 때 자동으로 부여된다.
      //         => Score2 클래스 또한 이 변수가 존재하고,
        //                   
      
    }catch (Exception e) {
     e.printStackTrace();
    }
  }

}
