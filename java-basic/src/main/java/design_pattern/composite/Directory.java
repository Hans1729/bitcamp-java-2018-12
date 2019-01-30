package design_pattern.composite;

import java.util.ArrayList;

public class Directory implements Node {

   ArrayList<Node> childs = new ArrayList<>();
   public Directory (String title) {
     this.title = title;
   }
  @Override
  public void getFileinfo() {
 System.out.println("디렉토리명: %s\n" , this.title);
    
  }
  public void add(Node node) {
    childs.add(node);
    
  }
  public Node remove(int index) {
    return  childs.remove(node);
    
    public Node get(int index) {
      return childs.get(node);
    }
    
    
  }



}
