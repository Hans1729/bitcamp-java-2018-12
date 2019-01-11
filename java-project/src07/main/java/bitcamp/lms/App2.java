package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
     
    Member member = new Member();
    
    while (member.index < 30) {
      System.out.print("번호? ");
      member.no[member.index] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("이름? ");
      member.name[member.index] = keyboard.nextLine();
      
      System.out.print("이메일? ");
      member.email[member.index] = keyboard.nextLine();
      
      System.out.print("암호? ");
      member.password[member.index] = keyboard.nextLine();
  
      System.out.print("사진? ");
      member.photo[member.index] = keyboard.nextLine();
  
      System.out.print("전화? ");
      member.tel[member.index] = keyboard.nextLine();
  
      member.registeredDate[member.index] = new Date(System.currentTimeMillis()); 
      
      member.index++;
      
      System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine().toLowerCase();
      
      if (!answer.equals("y") && answer.length() > 0) {
        break;
      }

      System.out.println();
    }
    keyboard.close();
    
    System.out.println();
     
    
    for(int j=0; j < member.index; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.no[j], member.name[j], member.email[j], member.tel[j], member.registeredDate[j]); //왜 index가 안되지. .? 

    }
  }
}