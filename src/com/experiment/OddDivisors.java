package com.experiment;

/**
 * Created by kapilsharma on 25/12/17.
 */
import java.util.*;
class OddDivisors
{
    public static long odddiv(int n)
    {long sum=0;
        for(int i=1;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                if(n/i!=i)
                {
                    if((n/i%2)!=0)
                    {
                        sum=sum+(n/i);
                    }
                    if((i%2)!=0)
                    {
                        sum=sum+i;
                    }
                }
                else
                {
                    if((i%2)!=0)
                    {
                        sum=sum+i;
                    }
                }

            }

        }
        return sum;
    }



    public static void main(String args[])
    {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        long arr[]=new long[t];
        int x=t;
        while(t!=0)
        {
            long sum=0;
            int l=sc.nextInt();
            int r=sc.nextInt();
            for(int i=l;i<=r;i++)
            {
                long k=odddiv(i);
                sum=sum+k;

            }

            arr[--t]=sum;


        }

        for(int i=x-1;i>=0;i--)
        {
            System.out.println(arr[i]);
        }




    }



}
