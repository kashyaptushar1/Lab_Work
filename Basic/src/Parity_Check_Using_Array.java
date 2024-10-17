public class Parity_Check_Using_Array {
    static int[] Parity_Bit(int arr[]){
        int cnt = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 1) {
                cnt++;
            }
        }
        if(cnt%2 == 0){
            System.out.println("The parity bit is 0");
        }else{
            System.out.println("The parity bit is 1");
        }
        int ans[] = new int[arr.length + 1];
        for(int i = 0; i<arr.length; i++){
            ans[i] = arr[i];
        }
        if(cnt %2 == 0){
            ans[ans.length-1] = 0;
        }else{
            ans[ans.length-1] = 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,0,1,1,1,0,1,0,1,1};
        int res[] = Parity_Bit(arr);
        for(var val: res){
            System.out.print(val +" ");
        }
    }
}
