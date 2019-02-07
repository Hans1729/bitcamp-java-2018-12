
package ch22.f;

import java.io.Serializable;

//java.io.serializable
//=> 개발자가 serialVersionUID의 값을 지정하면
//  컴파일러의 경고가 뜨지 않는다.
//   =>Test3_1을 실행하여 score3.data 파일에 인스턴스를 출력한 후
// 
public class Score4 implements Serializable{
  
  private static final long serialVersionUID = 100L; 
  private String name;
  private String tel; 
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aveg;
  
  public Score4() {
    System.out.println("Score4()");
  }
  public Score4(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    compute();
  }
  @Override
  public String toString() {
    return "Score4 [name=" + name + ", tel=" + tel + ", kor=" + kor + ", eng=" + eng + ", math="
        + math + ", sum=" + sum + ", aveg=" + aveg + "]";
  }
  
  
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getKor() {
    return kor;
  }
  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }
  public int getEng() {
    return eng;
  }
  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }
  public int getMath() {
    return math;
    
  }
  public void setMath(int math) {
    this.math = math;
    this.compute();
  }
  public int getSum() {
    return sum;
  }
  public float getAveg() {
    return aveg;
  }
  void compute() {
    this.sum = this.kor + this.eng + this.math;
     this.aveg = this.sum /3 ;
  }
}
