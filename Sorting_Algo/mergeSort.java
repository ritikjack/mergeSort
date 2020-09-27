import java.util.*;
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int s;
        int[] a = new int[50];
        System.out.println("enter the total no of elements :");
        s=scan.nextInt();
        
        System.out.println("enter the elements : ");
        for (int i=0;i<s;i++)
        {
            a[i]=scan.nextInt();
        }
        
        //call mergeSort method and pass arr ,low,high
        Main obj= new Main();
        
        obj.mergeSort (a,0,s-1);
        
        
        System.out.println("Sorted array is : ");
        for(int i=0;i<s;i++)
        {
            System.out.print(a[i]+" ");
        }
        
    }
    public static void mergeSort(int[] a, int l ,int r)
    {
        int mid;
        if(l<r)
        {
            mid=(l+r)/2;
            
            //divide and conquer
            
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,r);
            
            //combine
            merge(a,l,mid,r);
            
        }
        
    }
    public static void merge(int[] a, int l, int mid ,int r)
    {
        int n1=mid-l+1;
        int n2=r-mid;
        
        int [] L= new int[n1];//temporay array
        int[]  R= new int [n2];
        
        int i,j;
        
        for ( i=0;i<n1;i++)
        {
            L[i]=a[l+i];
        }
        for (j=0;j<n2;j++)
        {
            R[j]=a[mid+1+j];
        }
        
        i=0;
        j=0;
        //process of combining  two sorted array
        int k=l;
       while(i<n1 && j<n2)
       {
           if(L[i]<=R[j])
           {
               a[k]=L[i];
               i++;
           }
           else 
           {
               a[k]=R[j];
               j++;
           }
           k++;
       }
       
       //copy remaining elements of l[]
       while(i<n1)
       {
           a[k]=L[i];
           i++;
           k++;
       }
       //copy remaining elements of R[]
       while(j<n2)
       {
           a[k]=R[j];
           j++;
           k++;
       }
    }
}
