import java.util.*;
public class BitStuffing_Using_String {
    static String Bit_Stuffing(String data){
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(char bit : data.toCharArray()){
            sb.append(bit);
            if(bit == '1'){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == 5){
                sb.append("0");
                cnt = 0;
            }
        }
        return sb.toString();
    }
    static String Bit_Destuffing(String data){
        StringBuilder st = new StringBuilder();
        int cnt = 0;

        for(int i = 0; i<data.length();i++){
            char bit = data.charAt(i);

            if(bit == '1'){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == 5){
                i++;
            }
            st.append(bit);
        }
        return st.toString();
    }
    public static void main(String[] args) {
        String data = "1000111110111110";
        String stuff_Data = Bit_Stuffing(data);
        System.out.print("Stuff data is: ");
        System.out.print(stuff_Data);
        System.out.println();
        String Destuff_Data =  Bit_Destuffing(stuff_Data);
        System.out.print("Destuff Data : ");
        System.out.print(Destuff_Data);


    }
}
