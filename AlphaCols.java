import java.util.Scanner;

public class AlphaCols {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int input=s.nextInt();
        int rem;
        int mod;
        StringBuilder b=new StringBuilder();
        if(input<=26) {
            if (input == 0)
                System.out.println("please enter value greater than 0");
            else {
                char c= (char) (64+input);
                b.append(c);
            }
        }
        else {
            rem = input % 26;
            mod = input / 26;

            char cb='Z';
            if(mod<=26)
            {
                char ca;
                    ca = (char) (mod + 64);
                    b.append(ca);
            }
            else {
                for (int i = mod; i>26; i=i/26) {
                    b.append("Z");
                }
                char temp= (char) (mod/26+64);
                b.append(temp);
            }
                if(rem!=0) {
                    cb = (char) (rem + 64);
                }
                b.append(cb);
        }
        System.out.println(b);
    }
}
