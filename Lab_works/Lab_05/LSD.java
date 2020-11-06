public class LSD
{
   public static void sort(String[] a, int W)
   {  
      int n = a.length;
      int R = 256;
      String[] aux = new String[n];
      for (int d = W-1; d >= 0; d--)
      { 
         int[] count = new int[R+1];     
         for (int i = 0; i < n; i++)
             count[a[i].charAt(d) + 1]++;
         for (int r = 0; r < R; r++)     
            count[r+1] += count[r];
         for (int i = 0; i < n; i++)     
            aux[count[a[i].charAt(d)]++] = a[i];
         for (int i = 0; i < n; i++)     
            a[i] = aux[i];
        }
    }

public static void main(String[] args){
  String [] a = {"Gyeltshen","jigme","wangdi","kenzang"};

  sort(a,3);
  for(int i = 0;i<a.length;i++){
    System.out.println(" "+a[i]);
  }
  }
}