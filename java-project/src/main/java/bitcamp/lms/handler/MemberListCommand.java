package bitcamp.lms.handler;

import java.util.List;
import java.util.Scanner;
<<<<<<< HEAD
import bitcamp.lms.domain.Board;
import bitcamp.lms.domain.Member;

public class MemberListCommand implements Command {

  Scanner keyboard;
  List<Member> list;
  
  public MemberListCommand(Scanner keyboard, List<Member> list) {
    this.keyboard = keyboard;
    this.list = list;
  }
  @Override
  public void execute() {
    Member[] members = list.toArray(new Member[] {});
    for (Member member : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
  }
  }


=======

import bitcamp.lms.domain.Member;

public class MemberListCommand implements Command {
	  Scanner keyboard;
	  List<Member> list;
	  
	  public MemberListCommand(Scanner keyboard, List<Member> list) {
	    this.keyboard = keyboard;
	    this.list = list;
	  }
	
	
	@Override
	public void execute() {
		 Member[] members = list.toArray(new Member[] {});
		    for (Member member : members) {
		      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
		          member.getNo(), member.getName(), 
		          member.getEmail(), member.getTel(), member.getRegisteredDate());
		    }	
}
}
>>>>>>> 8e750c930de10b9752559e6935da084bd2113386
