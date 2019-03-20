// Java config - @Configuration 과 @Bean 
package ch29.j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test04 {
  public static void main(String[] args) {
    
     //  AnnotationConfigApplicationContext 컨테이너에 패키지명을 알려주면 
      //    그 패키지에 있는 @Componet, @Service, @Repository, @Controller 객체를 생성한다.
      //    만약 클래스들 중에서 @Configuration 애노테이션이 붙은 클래스가 있다면
     //   java-config 
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig4.class);
    
    // @Component 애노테이션 붙은 클래스의 인스턴스를 자동으로 생성한다.
    //
    System.out.println("---------------------------------------");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s ==> %s\n", 
          name, iocContainer.getBean(name).getClass().getName());
    }

    System.out.println("---------------------------------------");
 System.out.println(iocContainer.getBean("car1"));
 System.out.println(iocContainer.getBean("car2"));
  }
}






