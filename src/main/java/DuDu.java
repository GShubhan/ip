import java.util.Scanner;
public class DuDu {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println("Hello! I'm DuDu");
        System.out.println("What can I do for you?");
        System.out.println();
        System.out.println("-------------------------------------------");
        String inData;

        Scanner scan = new Scanner(System.in);
        Task[] list = new Task[100];
        int count =0;
        while(true) {
            inData = scan.nextLine();
            //bye
            if (inData.equalsIgnoreCase("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-------------------------------------------");
                break;
            }
            //list
            if (inData.equalsIgnoreCase("list")) {
                System.out.println("-------------------------------------------");
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ".[" +
                            list[i].getStatusIcon() + "] " +
                            list[i].description);
                }
                System.out.println("-------------------------------------------");
                continue;
            }
            //mark
            if (inData.startsWith("mark ")){
                int index = Integer.parseInt(inData.substring(5)) - 1;
                list[index].setDone(true);
                System.out.println("-------------------------------------------");
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  [" + list[index].getStatusIcon() + "] " +
                        list[index].description);
                System.out.println("-------------------------------------------");
                continue;
            }

            //unmark
            if (inData.startsWith("unmark ")) {
                int index = Integer.parseInt(inData.substring(7)) - 1;
                list[index].setDone(false);

                System.out.println("-------------------------------------------");
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  [" + list[index].getStatusIcon() + "] " +
                        list[index].description);
                System.out.println("-------------------------------------------");
                continue;
            }

            System.out.println("-------------------------------------------");
            Task task = new Task (inData);
            System.out.println("added: [" + task.getStatusIcon() + "] " + task.description);
            list[count]=task;
            count++;
            System.out.println("-------------------------------------------");
        }
        scan.close();
    }
}
