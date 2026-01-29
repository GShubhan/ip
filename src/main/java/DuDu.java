import java.util.Scanner;
public class DuDu {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println("Hello! I'm DuDu");
        System.out.println("What can I do for you?");
        System.out.println();
        System.out.println("-------------------------------------------");
        String inData;
        String[] list = new String[100];
        int count =0;
        while(true) {
            Scanner scan = new Scanner(System.in);
            inData = scan.nextLine();
            if (inData.equalsIgnoreCase("list")) {
                for (int i = 0; i < count; i++) {
                    System.out.println(count + ". " + list[i]);
                }
                continue;
            }
            System.out.println("-------------------------------------------");
            System.out.println("added: "+inData);
            list[count]=inData;
            count++;
            System.out.println("-------------------------------------------");



            if (inData.contains("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-------------------------------------------");
                break;
            }
        }
    }
}
