// 인스턴스 필드와 초기화 - 인스턴스 블록을 통해 필드를 초기화 하기 
package ch10;

class Monitor3 {
  int bright ; // 밝기 (0% ~ 100%)
  int contrast ;// 명함 (0% ~ 100%)
  int widthRes; // 해상도 너비 (0% ~ 100%)
  int heightRes ; // 해상도 높이 (0% ~ 100%)
  {   //인스턴스 블록 <= 실무에서는 인스턴스 블록을 잘 사용하지 않는다.
     this.bright = 50;
     this.contrast = 50;
     this.widthRes = 1920;
     this.heightRes = 1080;
  } 
   void display() {
     System.out.println("----------------------------------------------------------");
     System.out.printf("밝기(%d)\n" ,this.bright);
     System.out.printf("명암(%d)\n" ,this.contrast);
     System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
     System.out.println("----------------------------------------------------------");
    
  }
}

public class Test05 {
  public static void main(String[] args) {
     // 모니터 인스턴스 생성
    Monitor3 m1 = new Monitor3();
    
    //인스턴스 필드의 값이 유효한 기본 값들로 미리 초기화 되었기 때문에 바로 사용 할 수 있다.
    m1.display();// 현실 세계에서 모니터의 각 값들이 유효한 기본 값으로 초기화 되지 않은 상태에서
                     // 모니터를 켠다면? 까만 화면만 볼 뿐인다.
                     // 사용자는 모니터가 고장난 줄 알고 AS를 요청할 것이다.
    m1.bright = 40;
 
    
    m1.display();
    //   고객의 의견!
    // => 모니터를 구매한 후 바로 사용할 수 있도록 모니터의 속성 값들이 유효한 값으로
    //    미리 초기화 되었으면 좋겠습니다!
    //    
    //  이 클래스를 사용하는 다른 개발자의 의견!
    // =>인스턴스의 메서드를 사용하는데 문제가 없도록
   }

}


