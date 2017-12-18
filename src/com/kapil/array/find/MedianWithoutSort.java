package com.kapil.array.find;

/**
 * Created by kapilsharma on 09/12/17.
 */
public class MedianWithoutSort {
    static int A[] = new int[]{19,4,90,10,11,14,20,8};
    public static void main(String[] args) {
        System.out.println("Median is:" + selection_algorithm(0, A.length-1, A.length/2));
    }

   static int partitions(int low,int high)
    {
        System.out.println("Doing partition for: low" + low + " and high:" + high);
        int p=low,r=high,x=A[r],i=p-1;
        for(int j=p;j<=r-1;j++)
        {
            if (A[j]<=x)
            {

                i=i+1;
                //swap(A[i],A[j]);
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        //swap(A[i+1],A[r]);
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1;
    }
    static int selection_algorithm(int left,int right,int kth)
    {
        for(;;)
        {
            int pivotIndex=partitions(left,right);          //Select the Pivot Between Left and Right
            System.out.println("pivot index received:" + pivotIndex);
            int len=pivotIndex-left+1;
            System.out.println("len would be:" + len);
            if(kth==len)
                return A[pivotIndex];

            else if(kth<len) {
                right = pivotIndex - 1;
                System.out.println("Len is more changing right:" + right);
            }

            else
            {
                kth=kth-len;
                left=pivotIndex+1;
                System.out.println("len is less changing left:" + left);
            }
        }
    }
}
