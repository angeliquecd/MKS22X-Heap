public class MyHeap{
  private int[] heap;
  private int size;
  public MyHeap(){
    heap = new int[10];
    size=0;
  }
  private static void pushDown(int[] data, int size, int index){
    int first=0;
    int second =0;
    boolean downfirst=true;
    boolean downsecond = true;
    if (index*2+1<size) first = index*2+1;
    else downfirst = false;
    if(index*2+2<size) second = index*2+2;
    else downsecond = false;
    int child1=data[first];
    int child2=data[second];
    while ( (downfirst|| downsecond) && data[index]<child1 && data[index]<child2){
      if (downfirst) child1 = data[first];
      if (downsecond) child2= data[second];
      if ((downfirst && !downsecond) || child1>child2 ){
        data[first]=data[index];
        data[index]=child1;
        index=first;
      }
      else{
        data[second]=data[index];
        data[index]=child2;
        index=second;
      }
      if (index*2+1<size) first = index*2+1;
      else downfirst = false;
      if(index*2+2<size) second = index*2+2;
      else downsecond = false;
    }
  }
  private void resize(){
    int[] newy = new int[size*2];
    int index=0;
    for (int i: heap){
      newy[index]=i;
      index++;
    }
  }
  public static void printString(int[] heap){
    for (int a: heap){
      System.out.print(a+ ", ");
    }
  }
  public static void main(String[] args){
    int[] heap = {20,4,10,9,6,2,3};
    pushDown(heap,heap.length,1);
    printString(heap);
  }
}
