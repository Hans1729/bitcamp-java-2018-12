// 인스턴스 출력하기
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test02_1 {

  public static void main(String[] args) {
    Score[]  students = { new Score("홍길동", 100, 100, 100),
    new Score("임꺽정", 90, 90, 90),
    new Score("유관순", 80, 80, 80)};

    // 다음 3 학생의 성적 정보를 Score.data에 바이너리 형식으로 저장하라
    // => java.io.BufferedOutputStream 클래스를 사용하라 .
    // => java.io.DataputStream을 사용하라
    try (FileOutputStream out = new FileOutputStream("Score.data");
        // 버퍼 단위로 읽는 데코레이터를 붙인다 => 읽기 속도가 빠르다.
        BufferedOutputStream out1 = new BufferedOutputStream(out);
        // primitive type 데이터를 리턴하는 데코레이터를 붙인다. => 코딩이 간결해진다.
        DataOutputStream out2 = new DataOutputStream(out1)) {
      
           for(int i= 0; i< students.length; i++) {
             out2.writeUTF(students[i].getName());
             out2.writeUTF(students[i].getName());
           }


    } catch (Exception e) {

    }
    System.out.println("출력완료!");
  }


}

