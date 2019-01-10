// 레퍼런스와 인스턴스의 관계
package ch07;

public class Test05 {
 
  static class Score {
    String name;  // 설계 도면이기 때문에 변수가 존재하는 상태가 아니다.
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  
  public static void main(String[] args) throws Exception {
    
    Score s1 = new Score();
    // s1에 저장된 주소로 찾아가서 그 메모리의 각 항목 값을 설정한다.
    // => s1에 저장된 주소로 찾아가서 찾아가서 그 인스턴스의 각 변수의 값을 설정한다.
    // => s1이 가리키는 인스턴스의 각 변수의 값을 설정한다.
     //  => s1 인스턴스의 필드 값을 설정한다.
    //  => s1 객체의 필드 값을 설정한다.
    s1.name = "홍길동"; //표현: s1 객체의 name에 "홍길동"을 저장한다.
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;
    Score s2 = s1; //s1에 저장된 인스턴스 주소를 s2에 복사한다.
    
    printScore(s2);
    
  System.out.println(s2.name);
       s1.name ="임꺽정";
   System.out.println(s2.name); 
   // 메서드가 생성한 인스턴스의 주소를 받을수 있다.
   Score s3 =  createScore("유관순", 90, 90, 90);
   System.out.println(s3.name);
   System.out.println(s3.kor);
  }
  //createScore() 성적 데이터를 가지고 Score 객체를 생성하여 리턴한다.
  // ==> Score 인스턴스를 생성하여 리턴한다.
  // ==> Score 인스턴스를 생성한 후 그 주소를 리턴한다.
  static Score createScore(String name, int kor , int eng, int math){
    Score s = new Score();
    s.name = name;
    s.kor = kor;
    s.eng = eng;
    s.math = math;
    s.sum = kor + eng + math;
    s.aver = s.sum / 3f;
    
    return s; //s에 저장된 인스턴스의 주소를 리턴한다.
    
  }
  // 새 데이터 타입의 메모리 주소를 받을 변수를 파라미터로 선언한다.
  static void printScore(Score s) {
    /*
     * s.sum = s.kor + s.eng + s.math; s.aver = s.sum / 3f;
     * System.out.printf("%s: %d, %d, %d, %d, %f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
     */
  }
  
}

/*
 * # 자바 기본 데이터 타입의 변수 선언 vs 클래스의 변수 선언 - 자바 기본 데이터 타입은 변수를 선언하는 순간 메모리에 생성된다. int a; // 바로 int 값을
 * 저장할 메모리가 준비된다. - 클래스의 변수 선언은 주소를 담는 레퍼런스이다. 따라서 주소를 담는 메모리만 준비된다. Score s; // 아직 Score 설계도에 따라
 * 변수들이 준비된 상태가 아니다. - 클래스의 설계도에 따라 메모리를 준비하려면 따로 new 명령을 사용해야 한다. new Score(); - 생성된 메모리를 사용하려면 주소를
 * 잘 보관해 두어야 한다. s = new Score();
 * 
 */


