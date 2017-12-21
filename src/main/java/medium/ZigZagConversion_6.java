package medium;

public class ZigZagConversion_6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
    public static String convert(String s, int numRows) {
        if (s.length() == 0 || s.length() == 1||numRows==1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
        }
        int str = 2*numRows-2;
        for(int i=0;i<s.length();i++){
            if(i%str<numRows){
                sb[i%str].append(s.charAt(i));
            }else{
                sb[str-i%str].append(s.charAt(i));
            }
        }
        for(int i=1;i<numRows;i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
    /*public static String convert(String s, int numRows) {
        if(s.length()==0||s==null){
            return "";
        }
        if(numRows == 1) {
             return s;
         }
        int l=s.length();
        StringBuilder sb=new StringBuilder();
        int size=2*(numRows-1);
        for(int i=1;i<=numRows;i++){
                for(int j=i;j<=l;j=j+size){
                    sb.append(s.charAt(j-1));
                    if(i>1&&i<numRows){
                        int mid=j+2*numRows-2*i;
                        if(mid<=l){
                            sb.append(s.charAt(mid-1));
                        }
                    }
                }
            }

        return sb.toString();
    }*/
}
