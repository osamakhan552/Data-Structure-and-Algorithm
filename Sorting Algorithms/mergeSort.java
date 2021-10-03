package com.company;


import java.util.Scanner;


class SortAlgo{

    public void merge(int[] arr,int l,int m,int r)
    {
        //Creating size of left sub array
        int nl = m-l+1;
        //Creating size of right sub array
        int nr = r-m;

        int[] L = new int[nl];
        int[] R = new int[nr];

        int k=l;
        //filling elements in left and right sub array as it is
        for(int i=0; i<nl; i++)
            L[i] = arr[l+i];
        for(int i=0; i<nr; i++)
            R[i] = arr[m+1+i];
        int i=0,j=0;
        //Comparing each elements of left and right sub array and sorting accordingly
        while(i < nl && j < nr)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //if either left or right sub array exhausted.then one of then
        //below while loop will execute...

        while(i < nl)
        {
            arr[k] = L[i];
            i++;k++;

        }
        while(j < nr)
        {
            arr[k] = R[j];
            j++;k++;
        }
    }

    private void sort(int[] arr,int l,int r)
    {
        if(r>l)
        {
            int m = l + (r-l)/2;

            sort(arr,l,m);
            sort(arr,m+1,r);

            merge(arr,l,m,r);
        }
    }

    public void callSort(int[] arr,int l,int r)
    {
        sort(arr,l,r);
        System.out.println("Sorted Array");
        for(int e : arr)
            System.out.print(e + " ");
    }

}

public class mergeSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = input.nextInt();

        }

        SortAlgo obj = new SortAlgo();
        obj.callSort(arr,0,n-1);

    }
}
