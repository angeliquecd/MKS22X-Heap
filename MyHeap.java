public class MyHeap{
  private int[] heap;
  private int size;
  public MyHeap(){
    heap = new int[10];
    size=0;
  }
  private static void swap (int[] data, int one, int two){
    int temp = data[one];
    data[one]=data[two];
    data[two]=temp;
  }
  private static void pushDown(int [] data, int size, int index){
    if (index*2+1>size) return;
    if (index*2+1==size){
      int child2 = data[index*2+1];
      if (child2> data[index]) swap(data,index*2+1, index);
      return;}
  int child1 = data[index*2+1];
  int child2 = data[index*2+2];
  int biggerchild;
  if (child1>child2)  biggerchild=index*2+1;
  else biggerchild =index*2+2;
  if (data[index]<data[biggerchild]) {
    swap (data,index,biggerchild);
    pushDown(data,size,biggerchild);
  }
  else return;
  }
  /*private static void pushDown2(int[] data, int size, int index){
    int first=0; int second =0;
    boolean downfirst=true; boolean downsecond = true;
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
        index=first;}
      else{
        data[second]=data[index];
        data[index]=child2;
        index=second;  }
      if (index*2+1<size) first = index*2+1;
      else downfirst = false;
      if(index*2+2<size) second = index*2+2;
      else downsecond = false;
    }
  }*/

private static void pushUp(int[] data, int size, int index){
  int parent;
  boolean swapped=true;
  if (index==0) swapped=false;
  while(swapped){
    parent = data[(index-1)/2];
    if (parent<data[index]){
      data[(index-1)/2]=data[index];
      data[index]=parent;//performs swap
      index=(index-1)/2;//sets new index
      swapped= true;
    }
    if (index==0) swapped=false;//if you have reached the top then stop
  }
}
public static void heapify (int [] data){
  int index = 0;
  int earlier =0;
  while(index<data.length){
    earlier=data[index];
    pushDown(data,data.length-1,index);
    if (data[index]==earlier){
      index++;}
    //HeapPrinter.print(data);
  //  System.out.println(""+index);
  }
}
public static void heapify (int [] data,int size){
  int index = 0;
  int earlier =0;
  while(index<size+1){
    earlier=data[index];
    pushDown(data,size,index);
    if (data[index]==earlier){
      index++;}
    //HeapPrinter.print(data);
  //  System.out.println(""+index);
  }
}
public static void heapsort(int[] data){
  int n =1;
  while(n<data.length){
  heapify(data,data.length-n);
  swap(data,0,data.length-n);
  n++;
  printString(data);
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
    System.out.println();
  }
  public static void main(String[] args){
    int[] heap = {20,4,10,9,6,2,3};
    pushDown(heap,heap.length-1,1);
    pushDown(heap, heap.length-1,0);
    printString(heap);
    int [] heap1 = {2,25,41,10,9,5,4};
    pushUp(heap,heap.length-1,0);
    printString(heap1);
    HeapPrinter.print(heap1);
    heapify(heap1);
    HeapPrinter.print(heap1);
    HeapPrinter.print(heap);
    int[] heaply = {4,10,50,23,5,16,20,12};
    heapify(heaply);
    HeapPrinter.print(heaply);
    int [] tosort ={80,4,5,2,32,65,24,5,12,50};
    heapsort(tosort);
    printString(tosort);
  }
}
