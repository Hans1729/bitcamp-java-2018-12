package algorithm.data_structure.array;

public class ArrayList2 {
  
  static final int DEFAULT_SIZE= 5;
  
  Object[] arr;
  
  int size;
  
  public ArrayList2() {
    this(0);
  }
  public ArrayList2(int capacity) {
    if(capacity > DEFAULT_SIZE) {
      arr = new Object[capacity]; 
    }else {
      arr= new Object[DEFAULT_SIZE];
      }
  }  
  
   public Object[] toArray() {
      Object[] list = new Object[this.size];
      for(int i = 0; i <this.size; i++) {
        list[i] = this.arr[i];
          }
    return list;
   }
   
   public void add (Object value) {
     if(this.size == arr.length) {
       int OriginSize= arr.length;
       int newSize = OriginSize + (OriginSize >>1);
       Object temp =   new Object[newSize];
       for(int i = 0; i < arr.length; i++){
         temp[i] = arr[i];
           }arr = temp;
           arr[this.size++] = value;
     }
   }

    public void insert( int index, Object value) {
      
    }
   
   }
   

  
  
 
 private void  increase() {
   int OriginSize= arr.length;
   int newSize = OriginSize + (OriginSize >>1);
   Object temp =   new Object[newSize];
   for(int i = 0; i < this.arr.length; i++){
     temp[i] = this.arr[i];
       }arr = temp;
      
 }
}






