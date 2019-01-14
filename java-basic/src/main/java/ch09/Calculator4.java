package ch09;

public class Calculator4 {


     int result =0;
   
   //인스턴스 주소를 파라미터로 받지 않고 호출 될 때 앞 에서 받는 방법!
   void plus(int a){
      //메서드를 호출 할 때 인스턴스 주소를 앞으로 넘겼다.
     // 예} c1.plus(2);
      this.result += a;
   }
    void minus(int a) {
      this.result -= a;
     }
    void muitipule(int a){
     this.result *= a;
     }
    void divide(int a){
     result /= a;
     }
   
    

  }


