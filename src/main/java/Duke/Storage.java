package Duke;

import java.io.*;
import java.util.ArrayList;

public class Storage {

    private static final String FILE_PATH =
            "data" + File.separator + "duke.txt";

    public static void load(ArrayList<Task> tasks) {

        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                Task task;

                if (type.equals("T")) {
                    task = new Todo(description);
                } else if (type.equals("D")) {
                    task = new Deadline(description, parts[3]);
                } else {
                    task = new Event(description, parts[3], parts[4]);
                }

                task.setDone(isDone);
                tasks.add(task);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error loading data file.");
        }
    }

    public static void save(ArrayList<Task> tasks) {

        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Task task : tasks) {
                bw.write(task.toFileFormat());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("Error saving data file.");
        }
    }
}