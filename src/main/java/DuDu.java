import java.util.Scanner;

public class DuDu {

    private static final int MAX_TASKS = 100;
    private static final String LINE = "-------------------------------------------";

    public static void main(String[] args) {

        System.out.println(LINE);
        System.out.println("Hello! I'm DuDu");
        System.out.println("What can I do for you?");
        System.out.println(LINE);

        Scanner scan = new Scanner(System.in);
        Task[] tasks = new Task[MAX_TASKS];

        int count = 0;

        while (true) {
            try {
                String inData = scan.nextLine();

                // bye
                if (inData.equalsIgnoreCase("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println(LINE);
                    break;
                }

                // list
                if (inData.equalsIgnoreCase("list")) {
                    System.out.println(LINE);
                    System.out.println("Here are the tasks in your list:");

                    for (int i = 0; i < count; i++) {
                        // W4.6f + inheritance: rely on toString()
                        System.out.println((i + 1) + "." + tasks[i]);
                    }

                    System.out.println(LINE);
                    continue;
                }

                // mark
                if (inData.startsWith("mark ")) {
                    int index = Integer.parseInt(inData.substring(5)) - 1;
                    if (index < 0 || index >= count) {
                        throw new DuDuException("Task number does not exist.");
                    }
                    tasks[index].setDone(true);
                    System.out.println(LINE);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + tasks[index]);
                    System.out.println(LINE);
                    continue;
                }

                // unmark
                if (inData.startsWith("unmark ")) {
                    int index = Integer.parseInt(inData.substring(7)) - 1;
                    if (index < 0 || index >= count) {
                        throw new DuDuException("Task number does not exist.");
                    }
                    tasks[index].setDone(false);
                    System.out.println(LINE);
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks[index]);
                    System.out.println(LINE);
                    continue;
                }

                // add todo / deadline / event
                System.out.println(LINE);

                if (inData.startsWith("todo ")) {
                    tasks[count] = new Todo(inData.substring(5));

                } else if (inData.startsWith("deadline ")) {
                    String[] parts = inData.substring(9).split(" /by ");
                    if (parts.length < 2) {
                        throw new DuDuException("Deadline must include /by.");
                    }
                    tasks[count] = new Deadline(parts[0], parts[1]);

                } else if (inData.startsWith("event ")) {
                    String[] parts = inData.substring(6).split(" /from | /to ");
                    if (parts.length < 3) {
                        throw new DuDuException("Event must include /from and /to.");
                    }
                    tasks[count] = new Event(parts[0], parts[1], parts[2]);


                } else {
                    if (inData.equalsIgnoreCase("todo") || inData.equalsIgnoreCase("deadline") || inData.equalsIgnoreCase("event")) {
                        String msg = "Please add description for " + inData;
                        throw new DuDuException(msg);
                    }
                    else {
                        throw new DuDuException("Enter a valid command");
                    }
                }

                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks[count]);
                count++;
                System.out.println("Now you have " + count + " tasks in the list.");
                System.out.println(LINE);
            }

            catch (DuDuException e) {
                System.out.println(LINE);
                System.out.println(e.getMessage());
                System.out.println(LINE);
            }
            catch (NumberFormatException e) {
                System.out.println(LINE);
                System.out.println("Please enter a valid task number.");
                System.out.println(LINE);
            }
        }
        scan.close();

    }

}
