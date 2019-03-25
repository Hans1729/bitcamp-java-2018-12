// 애노테이션 프로퍼티
// => 메서드 선언하는 문법과 비슷하다
// => 기본 값을 지정하지 않으면 필수 입력이다.
// 
package ch28.e;

import ch28.e.MyAnnotation;

//@MyAnnotation  // 필수 프로퍼티가 있는 경우 반드시 지정해야 한다.
public class Test01 {
  @MyAnnotation(value="okok")
  int a;
  
  @MyAnnotation("okok")
  int b;
  
  @MyAnnotation2(value2="okok")
  int c;
  
  //@MyAnnotation2("okok") // 프로퍼티 이름이 value 아니면 생략할 수 없다.
  int d;
  
  @MyAnnotation3(value="okok")
  int e;

  @MyAnnotation3("okok") // 프로퍼티 값 입력이 선택 항목인 경우 값 설정 생략가능.
  int f;
  
  @MyAnnotation3 // 프로퍼티 값을 지정하지 않으면 괄호() 생략 가능
  int g;
}