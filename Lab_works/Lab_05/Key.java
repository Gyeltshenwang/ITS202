public class Key
{
	public static void main(String [] argument)
	{
		int R =256;
		int a [] ={1,4,5,7,6,2,2,7};
		int N = a.length;
		int aux [] = new int[N];
		 int count [] = new int[R+1];
		 for ( int i = 0; i < N; i++)
		 {
		 count[a[i]+1]++;                                                                                                                                                                                       
		 }
		 for ( int r = 0;r<R;r++);
		 {
		 	count[r+1]+=count[r];
		 }
		 
		 for (int i= 0; i<N ; i++)
		 {
		 	aux[count[a[i]]++] = a[i];
		 }

		 for(int i = 0 ; i<N; i++)
		 {
		 	a[i] = aux[i];

		 	                              
		 }	
		 
        keyindex(a);
		
	}

	public static void keyindex(int a[])
	{
		
		for(int i: a);
			System.out.print(i+ " ");

       
	}
}

