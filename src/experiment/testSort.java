package experiment;

public class testSort {
    public static void main(String[] args) {
        int[] a=new int[]{4,2,1,3,5};
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length-1;j++){
                if(a[i]>a[j]){
                    int tem=0;
                    tem=a[j];
                    a[j]=a[i];
                    a[i]=tem;
                }
            }
        }
        for (int e:a) {
            System.out.println(e);
        }
    }
}
