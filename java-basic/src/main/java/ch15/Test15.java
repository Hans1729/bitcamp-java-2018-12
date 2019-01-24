// Object 클래스 - clone() 인스턴스를 자동 복제할 때 호출하는 메서드이다.
// 
package ch15;


// clone()은 인스턴스를 복제할 때 호출하는 메서드 이다.

public class Test15 {
  static class Score{
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
    
  }
  
  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 100, 100);
    System.out.println(s1);
    
    
    Score s2 = new Score(s1.name,s1.kor,s1.eng,s1.math);
    s1.name = "임꺽정";
    
    //s1과 s2는 서로 다른 인스턴스이다.
    System.out.println(s1);
    System.out.println(s2);
    
    //해결책2:
    // => object에서 상속 받은 clone()을 오버라이딩 하라!
    //   => Test16.java를 

  }
}







