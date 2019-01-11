package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App   
  Lesson lesson = new Lesson();
  Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

       keyboard.nextLine();
         System.out.println("명령>");
       
    while (lesson.index < 100) {
      System.out.print("번호? ");
      lesson.no[lesson.index] = Integer.parseInt(keyboard.nextLine());

      System.out.print("수업명? ");
      lesson.title[lesson.index] = keyboard.nextLine();

      System.out.print("설명? ");
      lesson.contents[lesson.index] = keyboard.nextLine();

      System.out.print("시작일? ");
      lesson.startDate[lesson.index] = Date.valueOf(keyboard.nextLine());

      System.out.print("종료일? ");
      lesson.endDate[lesson.index] = Date.valueOf(keyboard.nextLine());

      System.out.print("총수업시간? ");
      lesson.totalHours[lesson.index] = Integer.parseInt(keyboard.nextLine());

      System.out.print("일수업시간? ");
      lesson.dayHours[lesson.index] = Integer.parseInt(keyboard.nextLine());

      lesson.index++;

      System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
      String input = keyboard.nextLine();
      System.out.println();

      if (!input.equalsIgnoreCase("y") && !input.equals(""))
        break;
    }

    keyboard.close();

    int count = 0;

    while (count < lesson.index) {
      System.out.printf("%d, %-20s, %s ~ %s, %4d\n", lesson.no[count], lesson.title[count],
          lesson.startDate[count], lesson.endDate[count], lesson.totalHours[count]);
      count++;
    }
  }
}


