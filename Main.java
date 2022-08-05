import java.io.File;
import java.util.Scanner;

public class Main {
    private static long sum = 0;

    public static void main(String[] args) {
        System.out.println(getPrint());
    }

    public static long getFolderSize(File folder) {
        try {
            if (folder.isFile()) {
                return folder.length();
            }
            File[] files = folder.listFiles();
            for (File file1 : files) {
                sum += getFolderSize(file1);
            }
        } catch (NullPointerException ex) {
            ex.getMessage();
        }
        return sum;
    }

    public static String getSort(long sum) {
        long kilobytes = 0;
        long megabytes = 0;
        long gigabytes = 0;
        if (sum < 1024) {
            return sum + " байт";
        } else if (sum > 1024) {
            kilobytes += sum / 1024;
            if (kilobytes < 1024) {
                return kilobytes + " килобайт";
            } else if (kilobytes > 1024) {
                megabytes = kilobytes / 1024;
                if (megabytes < 1024) {
                    return megabytes + " мегабайт";
                } else if (megabytes > 1024) {
                    gigabytes = megabytes / 1024;
                    if (gigabytes < 1024) {
                        return gigabytes + " гигабайт";
                    }
                }
            }
        }
        return "";
    }

    public static String getPrint() {
        System.out.println("Пример ввода: " + System.lineSeparator() +
                "Windows -> D:/Games");
        System.out.println("Введите путь до папки: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        File file = new File(input);
        getFolderSize(file);
        return "Размер папки " + input + " составляет: " + getSort(sum);
    }
}
