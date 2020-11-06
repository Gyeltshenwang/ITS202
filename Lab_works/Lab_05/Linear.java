public class Linear
{
	public static void main(String [] argument)

	{
	  linear_search();
	}

	public static void linear_search()
	{
		int value = 9;
		int [] a = { 4,3,2,1,5,6,7,9};
		for(int i=0; i<a.length; i++)
		{
			if(value == a[i])
			{
				System.out.println(i);
			} 
		}
	}
}