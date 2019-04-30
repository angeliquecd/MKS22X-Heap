import java.util.*;
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
    if (index*2+1>size) return;//no children
    if (index*2+1==size){//edge case (only one child)
      int child2 = data[index*2+1];
      if (child2> data[index]) swap(data,index*2+1, index);
      return;}
  int child1 = data[index*2+1];
  int child2 = data[index*2+2];//establishes children
  int biggerchild;
  if (child1>child2)  biggerchild=index*2+1;//establishes which is the bigger child
  else biggerchild =index*2+2;
  if (data[index]<data[biggerchild]) {//if heap is messed up
    swap (data,index,biggerchild);//swap
    pushDown(data,size,biggerchild);//carry on
  }
  else return;
  }

private static void pushUp(int[] data, int size, int index){
  int parent;
  if (index==0) return;//if you have reached the top then stop
    parent = data[(index-1)/2];
    if (parent<data[index]){
      swap (data,(index-1)/2,index);
      pushUp(data,size,(index-1)/2);//otherwise continue with new index as starting point
    }
}
public static void heapify (int [] data){
  int index = 0;
  int earlier =0;
  while(index<data.length){//stops at the end
    earlier=data[index];
    pushDown(data,data.length-1,index);
    pushUp(data,data.length-1,index); //essentially checks each heap then
    if (data[index]==earlier){//moves on if no change occurs
      index++;}
    //HeapPrinter.print(data);
  //  System.out.println();
   //System.out.println(""+index);
  }
}
public static void heapify2 (int [] data){
  int n = 1;
  while (n<=data.length){
    pushDown(data, data.length-1,data.length-n);
    n++;
  }
}
private static boolean checkheap(int[] data, int index){//also not used but could be useful later
  if (index*2+1<data.length)  return (data[index]>data[index*2+2] && data[index]>data[index*2+1]);
  return true;
}
public static void heapify (int [] data,int size){//not really used and doesn't work
  int index = 0;
  int earlier =0;
  while(index<size+1){
    earlier=data[index];
    pushDown(data,size,index);
    if (data[index]==earlier){
      index++;}
  //  HeapPrinter.print(data);
  //  System.out.println(""+index);
  }
}
public static void heapsort(int[] data){
  int n =1;
  heapify(data);//makes it a valid heap first
  //printString(data);
  while (n<data.length){
  swap(data,0,data.length-n); //swaps with the end
//  System.out.println("swaps: ");
  //printString(data);
  n++;//increments
  pushDown(data, data.length-n, 0); //moves the first one down to where it belongs
  //System.out.println("pushes down: ");
//  printString(data);
}
}
  public static void printString(int[] heap){
    for (int a: heap){
      System.out.print(a+ ", ");
    }
    System.out.println();
  }
  public static void main(String[] args){
    Random rng = new Random();
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
    int[] heaply = new int[25];
    for (int i=0;i<heaply.length;i++){
      heaply[i]=Math.abs(rng.nextInt()%100);
    }
    int[] heaply1 = new int[25];
    for (int i=0;i<heaply.length;i++){
      heaply1[i]=Math.abs(rng.nextInt()%200);
    }
    int[] heaply2 = new int[25];
    for (int i=0;i<heaply.length;i++){
      heaply2[i]=Math.abs(rng.nextInt()%100);
    }
    System.out.println("Heapifying: ");
    heapify2(heaply);
    HeapPrinter.print(heaply);
    System.out.println();
    heapify2(heaply1);
    HeapPrinter.print(heaply1);
    System.out.println();
    heapify2(heaply2);
    HeapPrinter.print(heaply2);
  }
}
