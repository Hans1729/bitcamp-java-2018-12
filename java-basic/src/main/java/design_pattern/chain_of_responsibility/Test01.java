package design_pattern.chain_of_responsibility;

import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
       Scanner keyScan = new Scanner(System.in);     
       TerminalHandler terminalHandler = new TerminalHandler();
       PlusHandler plusHandler = new PlusHandler();
       plusHandler.setNext(terminalHandler);
   
       // 마이너스 연산을 처리하고 싶다면 그 작업을 수행하는 객체를 만들어 체인에 연결하라!
       MinusHandler minusHandler = new MinusHandler();
      
       minusHandler.setNext(plusHandler);
       
       // * 연산을 처리하고 싶다면 그 작업을 수행하는 객체를 만들어 체인에 연결하라!
       MutipleHandler mutipleHandler = new MutipleHandler();
           mutipleHandler.setNext(minusHandler);
       
           
         //이렇게 기능을 체인으로 엮어 가는 ㅅ
       while(true) {
         System.out.print("a? ");
         int a= keyScan.nextInt();
         
         System.out.print("b? ");
         int b= keyScan.nextInt();
         
         System.out.print("op? ");
         String op= keyScan.next();
         
         mutipleHandler.handle(a, b, op);
         
         
       }
       
  }
}
