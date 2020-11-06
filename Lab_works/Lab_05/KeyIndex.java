public class KeyIndex
{
    public static void main(String[] args)
    {
        int R=256;
        int[] a = {5,6,3,2,8,1,7};
        int N = a.length;
        int aux[] = new int[N];
        int[] count = new int[R+1];
        {
            //Compute frequency counts
            for (int i=0; i<N; i++){
            count[a[i]+1]++;
            }
    
            //Transform count into indices 
            for (int r=0; r<R; r++){
            count[r+1]+=count[r];
            }

            //Distribute the data
            for (int i=0; i<N; i++){
            aux[count[a[i]]++]=a[i];
            }

            //Copy back
            for (int i=0; i<N; i++){
            a[i]=aux[i];
            }
        }
        
        show(a);
    }
    public static void show(int a[])
    {
        for (int i: a)
        {
            System.out.print(i+ " ");
        }
        System.out.print("\n");
    }
    
}