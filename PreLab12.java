import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PreLab12{
    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException
    {   
        int choice = 999;
        while(choice != 0)
        { System.out.println("Select an option from this menu :\n"
        +                    "0. Exit Program"
        +                    "1. Find nth power of 32\n"
        +                    "2. Check the encoding of a character: \n");
        choice = Integer.parseInt(stdin.readLine().trim());
        switch(choice)
        {
            case 0:
            {
                System.out.println("Exiting program now...");
            }
            break;
            case 1:
            {
                System.out.println("Enter a power to raise 32 by: \n");
                int n = Integer.parseInt(stdin.readLine().trim());
                System.out.print(n + "\n");
                int nthpowerof32 = 1 << (n * 5);
                System.out.println(nthpowerof32);
            }
            break;
            case 2:
            {   String s = stdin.readLine().trim();
                char c= s.toUpperCase().charAt(0); // c is initialized to an upper-case letter, ex: 'D'
                int rank = c - 'A' + 1;
                System.out.println(rank); //displays 4 if c is ‘D’, 1 if c is ‘A’, and 26 if c is ‘Z’

            }
            break;
        }
        }
    }
}