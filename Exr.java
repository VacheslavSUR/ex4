import java.util.Arrays;
import java.util.ArrayList;


public class Exr {
    public static void main(String[] args) {
        System.out.println("Esse:\n" + TxtProc(10,7, "hello my name is Bessie and this is my essay"));
        System.out.println("Cluster: " + split("((())())(()(()()))"));
        System.out.println("To Camel: " + toCamelCase("hello_edabit"));
        System.out.println("To Snake: " + toSnakeCase("HelloEdabit"));
        System.out.println("Overtime wage: " +  overTime(13.25,15,30,1.5));
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println("Amount of times to multiply: " + bugger(999));
        System.out.println("Starred: " + toStarShorthand("77777geff"));
        System.out.println("Rhymes: " + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("Trouble: " + trouble(666789, 12345667));
        System.out.println("Unique books: " + countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
     }
    public static String TxtProc(int n, int k, String str) {
        String[] stroka = str.split("\\s+");
        String esse = "", decoy = "";
        for (String word : stroka) {
            if (decoy.length()+word.length() <= k) {
                decoy += word;
                esse+=word+" ";
            } else {
                esse +="\n" + word + " ";
                decoy = word;
            }
        }
        return esse;
    }
    public static ArrayList<String> split(String str) {
        ArrayList<String> clust = new ArrayList<String>();
        String one = "";
        int l=0, r=0;
        char[] arr = str.toCharArray();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == '(') l++;
            else r++;
            one+=arr[i];
            if (l == r) {clust.add(one); one="";}
        }
        return clust;
    }
    public static String toCamelCase (String str) {
        char[] arr = str.toCharArray();
        String fin = "";
        boolean flag = false;
        if (Character.isLowerCase(arr[0])) arr[0] = Character.toUpperCase(arr[0]);
        for (char ch : arr) {
            if (flag) {fin += Character.toUpperCase(ch); flag = false;}
            else {
            if (ch == '_') flag = true;
            else fin += ch; }
        }
        return fin;
    }
    public static String toSnakeCase (String str) {
        char[] arr = str.toCharArray();
        String fin = "";
        if (Character.isUpperCase(arr[0])) arr[0] = Character.toLowerCase(arr[0]);
        for (char ch : arr) {
            if (Character.isUpperCase(ch)) fin += "_" + Character.toLowerCase(ch);
            else fin += ch;
        }
        return fin;
    }
    public static String overTime(double beg, double end, double wage, double mul) {
        double ovTime = end-17;
        if (ovTime < 0) ovTime = 0;
        double pay = (end - beg)*wage+ovTime*30*(mul-1);
        pay = Math.round(pay*100);
        pay = pay / 100;
        String payy = String.format("%.2f", pay);
        return "$" + payy;
    }
    public static String BMI(String weight, String height) {
        double kgs = 0, m = 0;
        String[] wght = weight.split(" "), hght = height.split(" ");
        if (weight.contains("pounds")) kgs = Double.parseDouble(wght[0])/2.2;
        else kgs = Double.parseDouble(wght[0]);
        if (height.contains("inches")) m = Double.parseDouble(hght[0])/39.37;
        else m = Double.parseDouble(hght[0]);
        double BMI = kgs/(m*m);
        BMI = Math.round(BMI*10);
        BMI /= 10;
        if (BMI < 18.5) return BMI + " Underweight";
        else if (BMI > 25) return BMI + " Overweight";
        else return BMI + "Normal weight";
    }
    public static int bugger(int a) {
        int num = a, count=0;
        while (num/10!=0) {
            String number = String.valueOf(num);
            char[] digits = number.toCharArray();
            num = 1;
            for (char digit : digits) {
                num*= Character.getNumericValue(digit);

            }
            count++;
        }
        return count;
    }
    public static String toStarShorthand(String str) {
        String starred = "";
        char[] chars = str.toCharArray();
        char prev = str.charAt(0);
        int count = 1;
        for (int i=1; i < chars.length; i++) {
            if (chars[i] == prev) {count++;
            if (i+1==chars.length) starred+=prev+"*"+count;
            }
            else {if (count == 1) starred += prev;
            else starred += prev+"*"+count;
            prev = chars[i];
            count = 1;
            if (count == 1 && i+1==chars.length) starred += prev;
            }
        }
        return starred;
    }
    public static boolean doesRhyme(String verse1, String verse2) {
        String vowels = "aeiouAEIOU";
        String check1 = "", check2 = "";
        String[] str1 = verse1.split(" "), str2 = verse2.split(" ");
        char[] chars1 = str1[str1.length-1].toCharArray(), chars2 = str2[str2.length-1].toCharArray();
        for (char ch : chars1) {
            if (vowels.contains(Character.toString(ch))) check1+=ch;
        }
        for (char ch : chars2) {
            if (vowels.contains(Character.toString(ch))) check2+=ch;
        }
        return check1.equals(check2);
    }
    public static boolean trouble(long a, long b) {
        char[] ach = ("" + a).toCharArray();
        char[] bch = ("" + b).toCharArray();
        char prev = ach[0], check = 0;
        int count = 1;
        for (int i=1; i<ach.length; i++) {
            if (ach[i] == prev) {count++;
            if (count==3) {check=ach[i];
            break;}} else {count=1;
            prev = ach[i];
            }
        }
        count=0;
        for (int i=1; i<bch.length; i++) {
            if (bch[i] == check) {
                count++;
                if (count == 2) return true;
            }
        }
        return false;
    }
    public static int countUniqueBooks(String seq, char end) {
        String specs = "$&+,:;=?@#|'<>.-^*%!";
        String ourboy = Character.toString(end);
        if (specs.contains(ourboy)) ourboy = ('\\') + ourboy;
        String[] wp = seq.split(ourboy);
        String symbs = "";
        for (int i = 1; i < wp.length; i+=2) {
                for (char ch : wp[i].toCharArray()) {
                    if (!symbs.contains(Character.toString(ch))) symbs+=ch;
                }
        }
        return symbs.length();
    }
}
