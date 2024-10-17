import java.util.*;
public class BitStuffing_Using_Array {
    static List<Integer> bit_Stuffing(int arr[]){
        List<Integer> aa = new ArrayList<>();
        int n = arr.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            aa.add(arr[i]);
            if(arr[i] == 1){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == 5){
                aa.add(0);
                cnt = 0;
            }
        }
        return aa;
    }

    static List<Integer> bit_Destuffing(int arr[]){
        List<Integer> aa = new ArrayList<>();
        int n = arr.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            aa.add(arr[i]);
            if(arr[i] == 1){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == 5){
                i++;
                cnt = 0;
            }
        }
        return aa;
    }

    public static void main(String[] args) {
        int data[] = {1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0};
        System.out.print("The data is: ");
        for(var val: data){
            System.out.print(val +" ");
        }
        System.out.println();
        System.out.print("Data after Bit_stuffing: ");
        List<Integer> stuff_Data = bit_Stuffing(data);
        System.out.print(stuff_Data);
        System.out.println();
        int arr1[] = new int[stuff_Data.size()];
        for(int i = 0; i<arr1.length ; i++){
            arr1[i] = stuff_Data.get(i);
        }
        System.out.println();
        List<Integer> Dstuff_Data = bit_Destuffing(arr1);
        System.out.print("Data after deStuffing: ");
        System.out.print(Dstuff_Data);


    }
}
