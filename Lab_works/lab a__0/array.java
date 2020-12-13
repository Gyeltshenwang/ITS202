public class array{
    static int[] ar;
    public static void main(String[] args){
        int [] ar=new int[3];
        ar[0]=1;
        ar[1]=2;
        ar[2]=3;
        int[] ar2=resize(4);
        for(int i=0; i<ar2.length;i++){
            System.out.println(ar2[i]);
            }
    }
    public static int[] resize(int n){
        int[] ar2= new int[n];
        for(int i=0; i<ar.length; i++){
            ar2[i]=ar[i];
        }
        ar2[n-1]=4;
        ar=ar2;
        return ar;
    }
}