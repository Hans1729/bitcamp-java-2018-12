// 인스턴스 읽기 - ObjectInputStream
package ch22.e;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import ch15.Student;

public class Test04_2 {

  public static void main(String[] args) {
    

    ArrayList<Score> students = new ArrayList<>();
    
    
    
    try (ObjectInputStream in = new ObjectInputStream(
          new BufferedInputStream(
          new FileInputStream("score.data")))) {
      
      int len = in.readInt();
      
      for (int i = 0; i < len; i++) {
        Score score = (Score) in.readObject();
          // 저장한 인스턴스 필드 값을 그대로 읽을 것이기 때문에
        // sum과 aver 필드 값도 그대로 읽을 것이다.
          // 따라서 compute() 는 따로 호출할 필요가 없다.
        // score.compute()
       
       // score.compute();
        Student.add(score);
      }
     
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // =>   홍길동, 100, 100, 100, 300, 100 
    // 
    
    for (Score s : students) {
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
        s.getName(), s.getKor(), s.getEng(), s.getMath(),
        s.getSum(), s.getAveg());
    }
  }

}
