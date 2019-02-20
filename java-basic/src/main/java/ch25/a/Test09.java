//java.sql.ResultSet 객체 - 서버에서 select의 결과를 가져오기 III
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test09 {

  public static void main(String[] args) {

    try(Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")){
      System.out.println("DBMS에 연결됨");


      try(Statement stmt = con.createStatement()){
        // Statement 구현체를 이용하여 SQL문을 서버에 전달한다.
        //  executeUpdate() : insert,update,delete 등 DDL,DMS 문법을 전달한다.
        // executeQuery() : select 문법을 전달한다.
        // execute() : 모든 SQL문을 전달한다.
        //  
        //
        // executeQuert()의 리턴 값은 ResultSet 구현체 이다.
        // ResultSet 객체?
        // => 서버의 select 실행 결과를 가져올 때 사용하는 도구이다.
        // => 단 한 개씩 가져온다. 한 번에 모두 가져오는 것이 아니다.
        //
        try(ResultSet rs=   stmt.executeQuery("select * from x_board order by board_id desc")){ 
          // next() : 서버에서 한 개의 row(record)를 가져온다.
          //   - 서버에서 한 개의 row(record)를 가져온다.
          //   - 만약 가져올 레코드가 없으면 false를 리턴한다.

          while(rs.next()) {
            // 레코드에서 컬럼 값을 꺼낼 때 컬럼의 타입에 상관없이 무조건 문자열로 받을 수 있다.
            System.out.printf("%s, %s ,%s ,%s,%s\n" ,
                rs.getString("board_id"), 
                rs.getString("title"), 
                rs.getString("contents"), 
                rs.getString("created_date"), 
                rs.getString("view_count")); 
            System.out.println("입력 성공");
          }
        }
      }
    }catch (Exception e) {
      e.printStackTrace();

    }
  }

}
