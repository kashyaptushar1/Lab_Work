import java.util.*;
public class ByteStuffing_Using_Array {
    static List<String> byte_Stuffing(String arr[]){
        ArrayList<String> aa = new ArrayList<String>();
        int n = arr.length;
        for(int i = 0; i< n; i++){
            if(arr[i] == "FLAG" || arr[i] == "ESC"){
                aa.add("ESC");
            }
            aa.add(arr[i]);
        }
        return aa;
    }

    static List<String> byte_Destuffing(String arr[]){
        ArrayList<String> aa = new ArrayList<String>();
        int n = arr.length;
        for(int i = 0; i< n; i++){
            if(arr[i] == "FLAG" || arr[i] == "ESC"){
                i++;
            }
            aa.add(arr[i]);
        }
        return aa;
    }

    public static void main(String[] args) {
        String data[] = {"A","B","FLAG","ESC","C"};
        System.out.print("The data is: ");
        for(var val: data){
            System.out.print(val +" ");
        }
        System.out.println();
        List<String> stuff_data = byte_Stuffing(data);
        System.out.print("Data after byte stuffing: ");
        System.out.print(stuff_data);
        System.out.println();
        String arr2[] = new String[stuff_data.size()];
        for(int i = 0; i<arr2.length; i++){
            arr2[i] = stuff_data.get(i);
        }
        List<String> Destuff_data = byte_Destuffing(arr2);
        System.out.print("Data after destuffing: ");
        System.out.print(Destuff_data);


    }
}
