package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    Board board = new Board();
   
   
    while (board.i < 30) {
      System.out.print("번호? ");
      board.no[board.i] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("내용? ");
      board.contents[board.i] = keyboard.nextLine();
      
      board.createdDate[board.i] = new Date(System.currentTimeMillis()); 
      
      board.viewCount[board.i] = 0;
      
      board.i++;
      
      System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine().toLowerCase();
      
      if (!answer.equals("y") && answer.length() > 0) {
        break;
      }

      System.out.println();
    }
    
    keyboard.close();
    
    System.out.println();

    for (int j=0; j<board.i; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.no[j], board.contents[j], board.createdDate[j], board.viewCount[j]);
    }
  }
}