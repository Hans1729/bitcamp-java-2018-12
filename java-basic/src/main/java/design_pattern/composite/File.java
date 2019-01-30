package design_pattern.composite;

import org.checkerframework.checker.units.qual.Length;

public class File implements Node {

int type;
int length;
public  File(String title String length) {
  this.Title = title;
  this.type = type;
   this.length = length;
  
}

  @Override  
  public void getFileinfo() {
   System.out.println("파일명 : %s\n", this.title);
  }
  
  

}
