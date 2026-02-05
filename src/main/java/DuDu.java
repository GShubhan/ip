import java.util.Scanner;

public class DuDu {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println("Hello! I'm DuDu");
        System.out.println("What can I do for you?");
        System.out.println("-------------------------------------------");

        Scanner scan = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int count = 0;

        while (true) {
            String inData = scan.nextLine();

            // bye
            if (inData.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-------------------------------------------");
                break;
            }

            // list
            if (inData.equalsIgnoreCase("list")) {
                System.out.println("-------------------------------------------");
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + "." + tasks[i]);
                }
                System.out.println("-------------------------------------------");
                continue;
            }

            // mark
            if (inData.startsWith("mark ")) {
                int index = Integer.parseInt(inData.substring(5)) - 1;
                tasks[index].setDone(true);
                System.out.println("-------------------------------------------");
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + tasks[index]);
                System.out.println("-------------------------------------------");
                continue;
            }

            // unmark
            if (inData.startsWith("unmark ")) {
                int index = Integer.parseInt(inData.substring(7)) - 1;
                tasks[index].setDone(false);
                System.out.println("-------------------------------------------");
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + tasks[index]);
                System.out.println("-------------------------------------------");
                continue;
            }

            // todo
            if (inData.startsWith("todo ")) {
                tasks[count] = new Todo(inData.substring(5));

                // deadline
            } else if (inData.startsWith("deadline ")) {
                String[] parts = inData.substring(9).split(" /by ");
                tasks[count] = new Deadline(parts[0], parts[1]);

                // event
            } else if (inData.startsWith("event ")) {
                String[] parts = inData.substring(6).split(" /from | /to ");
                tasks[count] = new Event(parts[0], parts[1], parts[2]);

            } else {
                System.out.println("Invalid command");
                continue;
            }

            System.out.println("-------------------------------------------");
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + tasks[count]);
            count++;
            System.out.println("Now you have " + count + " tasks in the list.");
            System.out.println("-------------------------------------------");
        }

        scan.close();
    }
}

