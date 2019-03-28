package design_pattern.chain_of_responsibility;

public abstract class AbstractHandler implements Handler {
  
  Handler next;
  
  public AbstractHandler() {
    
  }
  
  public AbstractHandler(Handler handler) {
    this.next = next;  
  }

  public Handler getNext() {
    return next;
  }

  public void setNext(Handler next) {
    this.next = next;
  }

  
}
