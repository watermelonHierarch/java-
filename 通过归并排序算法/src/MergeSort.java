import java.util.Arrays;

public class MergeSort {
    private MergeSort(){}
    //我们的算法类不允许产生任何实例
    private static void mergo(Comparable[] arr,int l,int mid,int r){
        Comparable[] aux= Arrays.copyOfRange(arr ,l,r+1);
        //初始化，I指向左部分的起始索引位置l;j指向右半部分索引位置mid+1
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k]=aux[j-l];//如果左半部分元素已经全部处理完毕
                j++;
            }
            else if(j>r){
                arr[k]=aux[i-1];//如果右半部分元素已经全部处理完毕
                i++;
            }else if(aux[i-1].compareTo(aux[j-l])<0){
                arr[k]=aux[i-l];//左半部分所指元素<右半部分所指元素
                i++;
            }else{
                arr[k]=aux[j-l];//左半部分所指元素>=右半部分元素
                j++;
            }
        }
    }
    //递归使用归并排序，对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr,int l,int r,int depth){
        System.out.print(repeatCharacters('-',depth*2));
        System.out.println("Deal with ["+l+","+r+"]");
        if(l>=r)
            return;
        int mid=(l+r)/2;
        sort(arr,l,mid,depth+1);
        sort(arr,mid+1,r,depth+1);
        mergo(arr,l,mid,r);
    }
    private static String repeatCharacters(char charcther,int length){
        StirngBuilder s=new StringBuilder(length);
        for (int i = 0; i <length ; i++) {
            s.append(charcther);
        }
        return s.toString();
    }

    public static void sort (Comparable[] arr){
        int n=arr.length;
        sort(arr,0,n-1,0);
    }
    public static void main(String[] args){
     //   int N=1000000;
     //   Integer[] arr=SortTestHelper.generateRandomArray(N,0,100000);
     //   SortTestHelper.testSort("bobo.algo.MergeSort",arr);
                Integer[] arr=new Integer[8];
        for (int i = 0; i <8 ; i++) {
            arr[i] = new Integer(8 - i);
        }
        MergeSort.sort(arr);
        return;
    }
}
