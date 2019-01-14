package ch09;

public class Calculator3 {

    // TODO Auto-generated method stub
     int result =0;
     
   Calculator3 c1 =  new Calculator3();
   Calculator3 c2 = new Calculator3();
   
   static void plus(Calculator3 that, int a){
      that.result += a;
   }
   static void minus(Calculator3 that, int a) {
     that.result -= a;
     }
   static void muitipule(Calculator3 that, int a){
     that.result *= a;
     }
   static void divide(Calculator3 that, int a){
     that.result /= a;
     }
   

  }


