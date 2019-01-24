// Object 클래스 - clone() 인스턴스를 자동 복제할 때 호출하는 메서드이다.
// 
package ch15;


// clone()은 인스턴스를 복제할 때 호출하는 메서드 이다.

public class Test16 {
  // 인스턴스 복제 기능을 활성화하려면 Cloneable 인터페이스를 구현해야 한다.
  // => 이 인터페이스에는 메서드가 선언되어 있지 않다.
  // => 따라서 클래스는 따로 메서드를 구현할 필요가 없다.
  // => Cloneable을 구현하는 
  static class Score implements Cloneable{
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    public Score() {
      
    }
    public Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.sum = this.kor + this.eng + this.math;
      this.aver = this.sum / 3f;
    }

    @Override
    public String toString() {
      return "Score1 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
          + sum + ", aver=" + aver + "]";
    }
    // 자바에서 제공하는 인스턴스를 복제해주는 기능을 사용하려면, 
    // =>java.lang.Cloneable 인터페이스 규칙을 따라야 한다.
    // Object에서 상속 받은 clone()을 오버라이딩
    @Override
    public Score clone() throws CloneNotSupportedException {
      // 복제를 위한 코드를 작성할 필요가 없다.
      // 그냥 상속 받은 메서드를 호출하라
      
      return (Score) super.clone();
    }
  }
  
  public static void main(String[] args) throws Exception{
    Score s1 = new Score("홍길동", 100, 100, 100);
    
    
    
 
    
    Score s2 = s1.clone();
    s2.name = "임꺽정";
    
    //s1과 s2는 서로 다른 인스턴스이다.
    System.out.println(s1);
    System.out.println(s2);
    
    //해결책2:
    // => object에서 상속 받은 clone()을 오버라이딩 하라!
    //   => Test16.java를 

  }
}







