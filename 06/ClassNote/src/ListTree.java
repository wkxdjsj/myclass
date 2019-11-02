import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ListTree {
        public static void main(String[] args) throws IOException {
            //get current direction
            String currentPath = System.getProperty("user.dir");

            //get two level up from current direction which usually is 'myclass' direction.
            String[] classPathArray = System.getProperty("user.dir").split(File.separator);
            classPathArray = Arrays.copyOf(classPathArray, classPathArray.length-2);
            String classPath = Arrays.stream(classPathArray).collect(Collectors.joining(File.separator));

//            System.out.println(classPath);
//            System.out.println(currentPath);
            listFileTree(new File(currentPath));
        }

        private static int time;

        public static void listFileTree(File file) {
            if (file.isFile() || 0 == file.listFiles().length) {
                return;
            } else {
                File[] files = file.listFiles();
                files = sort(files);

                for (File each : files) {
                    StringBuffer output = new StringBuffer();
                    if (each.isFile()) {
                        output.append(getTabs(time));
                        output.append(each.getName());
                    } else {
                        output.append(getTabs(time));
                        output.append(each.getName());
                        output.append("/");
                    }

                    System.out.println(output);

                    if (each.isDirectory()) {
                        time++;
                        listFileTree(each);
                        time--;
                    }
                }
            }
        }

        private static File[] sort(File[] files) {
            ArrayList<File> sortedFiles = new ArrayList<>();
            for (File each : files) {
                if (each.isDirectory()) {
                    sortedFiles.add(each);
                }
            }
            for (File each : files) {
                if (each.isFile()) {
                    sortedFiles.add(each);
                }
            }
            return sortedFiles.toArray(new File[files.length]);
        }

        private static String getTabs(int time) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < time; i++) {
                buffer.append("\t");
            }

            return buffer.toString();
        }
}
