package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberAddCommand implements Command {
  MemberDao memberDao;

  public MemberAddCommand( MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      Member member = new Member();

      out.println("이름? \n !{}! \n");
      out.flush();
      member.setName(in.readLine());

      out.print("이메일?  \n !{}! \n");
      out.flush();
      member.setEmail(in.readLine());

      out.print("암호? \n !{}! \n");
      out.flush();
      member.setPassword(in.readLine());

      out.print("사진? \n !{}! \n");
      out.flush();
      member.setPhoto(in.readLine());

      out.print("전화? \n !{}! \n ");
      out.flush();
      member.setTel(in.readLine());

      memberDao.insert(member);
      out.println("저장하였습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}