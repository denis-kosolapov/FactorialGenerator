package Permutator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    /**
     * @param method метод для замера
     * @param timeUnit единица измерения
     * @return время работы
     */
    private static long timer(Runnable method, TimeUnit timeUnit) {
        long time = System.nanoTime();
        method.run();
        time = System.nanoTime() - time;
        return TimeUnit.NANOSECONDS.convert(time, timeUnit);
    }

    public static void main(String[] args) throws IOException {

        double time = timer(() -> {

            Permutator<Character> permutator = new Permutator<>(new Character[]{'A','B','C','D','E','F','G','H','I','J','K'});

                FileWriter writer = null;
                try {
                    writer = new FileWriter("options.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while (permutator.hasNext())
                //System.out.println(Arrays.deepToString(permutator.next()));

            {
                try {
                    writer.write(Arrays.deepToString(permutator.next()) + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }, TimeUnit.NANOSECONDS); // эта строчка закрывает весь код и анализирует время, затрченое на выполнение

        System.out.println(time/1000000000 + " секунд");

        // как разбить на более мелкие файлы?
    }
}
