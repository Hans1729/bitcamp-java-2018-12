// 인스턴스 출력하기
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test01_1 {

  public static void main(String[] args) {

    // 다음 3 학생의 성적 정보를 Score.data에 바이너리 형식으로 저장하라
    // => java.io.BufferedOutputStream 클래스를 사용하라 .
    // => java.io.DataputStream을 사용하라
    try (FileOutputStream out = new FileOutputStream("Score.data");
        // 버퍼 단위로 읽는 데코레이터를 붙인다 => 읽기 속도가 빠르다.
        BufferedOutputStream out1 = new BufferedOutputStream(out);
        // primitive type 데이터를 리턴하는 데코레이터를 붙인다. => 코딩이 간결해진다.
        DataOutputStream out2 = new DataOutputStream(out1)) {
      Score s1 = new Score("홍길동", 100, 100, 100);
      Score s2 = new Score("임꺽정", 90, 90, 90);
      Score s3 = new Score("유관순", 80, 80, 80);
      out2.writeChars(s1.getName());
      out2.writeInt(s1.getKor());
      out2.writeInt(s1.getEng());
      out2.writeInt(s1.getMath());
      out2.writeFloat(s1.getAveg());

      out2.writeChars(s2.getName());
      out2.writeInt(s2.getKor());
      out2.writeInt(s2.getEng());
      out2.writeInt(s2.getMath());
      out2.writeFloat(s2.getAveg());

      out2.writeChars(s3.getName());
      out2.writeInt(s3.getKor());
      out2.writeInt(s3.getEng());
      out2.writeInt(s3.getMath());
      out2.writeFloat(s3.getAveg());



    } catch (Exception e) {

    }
    System.out.println("출력완료!");
  }


}

