package main.java.medium;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dewey
 * @date 2019/4/6 13:16
 */
public class RestoreIPAddresses_93 {
    public static void main(String[] args) {
        String test = "010010";
        //System.out.println(test.substring(0,1));
        List<String> result = restoreIpAddresses(test);
        for(String str:result){
            System.out.println(str);
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()<4||s.length()>12){
            return result;
        }
        List<String> current = new ArrayList<>();
        Helper(result,current,1,0,s);
        return result;
    }
    public static void Helper(List<String> result,List<String> current,int count,int index,String s){
        if(count == 4){
            if(Integer.valueOf(s.substring(index))>=0&&Integer.valueOf(s.substring(index))<=255){
                if(s.length()-index>1&&s.charAt(index)=='0'){
                    return;
                }
                result.add(current.get(0)+"."+current.get(1)+"."+current.get(2)+"."+s.substring(index));
            }
        }
        else if(count==1){
            for (int i = 1; i <= 3; i++) {
                int remainCount = s.length() - index - i;
                if(remainCount>=3&&remainCount<=9) {
                    if(i>1&&s.charAt(index)=='0'){
                        return;
                    }
                    if (Integer.valueOf(s.substring(index, index + i)) >= 0 && Integer.valueOf(s.substring(index, index + i)) <= 255) {
                        current.add(s.substring(index,index+i));
                        Helper(result, current, count+1, index + i, s);
                        current.remove(current.size()-1);
                    }
                }
            }
        }
        else if(count==2){
            for (int i = 1; i <= 3; i++) {
                int remainCount = s.length() - index - i;
                if(remainCount>=2&&remainCount<=6) {
                    if(i>1&&s.charAt(index)=='0'){
                        return;
                    }
                    if (Integer.valueOf(s.substring(index, index + i)) >= 0 && Integer.valueOf(s.substring(index, index + i)) <= 255) {
                        current.add(s.substring(index,index+i));
                        Helper(result, current, count+1, index + i, s);
                        current.remove(current.size()-1);
                    }
                }
            }
        }
        else if(count==3){
            for (int i = 1; i <= 3; i++) {
                int remainCount = s.length() - index - i;
                if(remainCount>=1&&remainCount<=3) {
                    if (Integer.valueOf(s.substring(index, index + i)) >= 0 && Integer.valueOf(s.substring(index, index + i)) <= 255) {
                        if(i>1&&s.charAt(index)=='0'){
                            return;
                        }
                        current.add(s.substring(index,index+i));
                        Helper(result, current, count+1, index + i, s);
                        current.remove(current.size()-1);
                    }
                }
            }
        }
    }
}
