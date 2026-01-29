import java.util.Scanner;
public class DuDu {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println("Hello! I'm DuDu");
        System.out.println("What can I do for you?");
        System.out.println();
        System.out.println("-------------------------------------------");
        String inData;
        while(true) {
            Scanner scan = new Scanner(System.in);
            inData = scan.nextLine();
            System.out.println("-------------------------------------------");
            System.out.println(inData);
            System.out.println("-------------------------------------------");
            if (inData.contains("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-------------------------------------------");
                break;
            }
        }


    }
}
