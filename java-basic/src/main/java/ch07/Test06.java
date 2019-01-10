// 가비지와 가비지 컬렉터 그리고 레퍼런스 카운트
package ch07;

public class Test06 {

  static class Score {
    String name; // 설계 도면이기 때문에 변수가 존재하는 상태가 아니다.
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) throws Exception {
    Score s1 = new Score();
    Score s2 = new Score();
    s2 = s1; // s2에 저장되었던 주소는 s1에 저장된 주소로 변경된다.
             // 따라서 s2가 가리키던 원래의 인스턴스는 주소를 잃어 버려 사용할 수 없는 상태가 된다.
             // 이렇게 주소를 잃어 버려 사용할 수 없는 인스턴스를 "가비지(garbage)"라 부른다.
             // 가비지는 가비지 컬렉터에 의해서


    // s1 이 가르키던 인스턴스를 이제 s2도 가리킨다.
    // JVM은 인스턴스 주소를 몇 개의 레퍼런스가 갖고 있는지 따로 관리한다.
    // 이것을 "레퍼런스 카운트(reference count)"라 한다.
    // 다른 레퍼런스가 인스턴스 주소를 가질 때마다 해당 인스턴스의 레퍼런스 카운트는 증가한다.
    // 인스턴스를 주소를 가리키는 레퍼런스가 줄 때마다 해당 인스턴스의 레퍼런스 카운트도 감소한다.
    // 레퍼런스 카운트가 0가 것이 바로 "가비지"이다.
  }


  // createScore() 성적 데이터를 가지고 Score 객체를 생성하여 리턴한다.
  // ==> Score 인스턴스를 생성하여 리턴한다.
  // ==> Score 인스턴스를 생성한 후 그 주소를 리턴한다.
  static Score createScore(String name, int kor, int eng, int math) {
    Score s = new Score();
    s.name = name;
    s.kor = kor;
    s.eng = eng;
    s.math = math;
    s.sum = kor + eng + math;
    s.aver = s.sum / 3f;

    return s; // s에 저장된 인스턴스의 주소를 리턴한다.

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


