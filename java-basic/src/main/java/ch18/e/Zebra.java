package ch18.e;

public class Zebra {
  // 방향 (direction)이 숫자이기 떄문에 나중에 소스 코드를 보면 이해가 안될 것이다.
  // 숫자 보다는 문자가 직관적이기 때문에 변수를 활용한다.
  public final static int ON = 1; // 상수 문자열
  public final static int OFF = 2; //
  
  boolean use;
  
  public void rotate(int direction) {
    if(direction == 1) { 
      this.use = true;
    }else if(direction == 2) { //
      this.use = false;
      
    }
    
  }

}
