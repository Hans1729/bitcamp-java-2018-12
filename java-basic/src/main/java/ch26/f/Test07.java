// dynamic SQL 다루기 - #{} 와 ${} 의 사용법
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test07 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();


    HashMap<String, Object> params = new HashMap<>();

    Scanner keyboard = new Scanner(System.in);
    System.out.println("정렬할 컬럼? ");
    String column = keyboard.nextLine();
    if(column.length() > 0) {
      params.put("column", column);
    }
    
    System.out.println("정렬 방식?? ");
    String sort = keyboard.nextLine();
    if(sort.length() > 0) {
      params.put("sort", sort);
    }

    keyboard.close();
    
//  정렬할 컬럼 이름과 정렬 방식(asc 또는 desc)을 값으로 전달할 수 없다.
//    List<Board> boards = sqlSession.selectList("board.select7_ok",params);
    
    // 컬럼 이름과 정렬 방식과 같은 SQL 키워드를 값으로 전달하려면
    // SQL Mapper파일에서 #{프로퍼티명} 대신에 ${프로퍼티명} 문법을 사용해야 한다.
    //  문제는 사용자가 입력한 값을 직접 전달하게 되면 'SQL 삽입 공격' 에 노출 되므로 
    // 절대 직접 전달해서는 안된다.
    //  다음 Test07 클래스와 같이 자바 코드에서 만든 값을 전달 하라. 
    
    // 이 예제는 사용자가 입력한 값을 그대로 sql 코드에 삽입하는 예제이다.
   // => SQL 삽입 공격이 가능한 상황이다.
    List<Board> boards = sqlSession.selectList("board.select7_ok",params);
    
    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");


  }

}






