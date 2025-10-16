import java.io.*;
import java.util.*;

/**
 * Клас Lab1Kovlyha305 створює трикутну (верхню) частину квадратної матриці,
 * заповнену символом, який вводить користувач.
 * <p>
 * Розмір матриці визначається користувачем. Кожен наступний рядок має
 * на один елемент менше, утворюючи трикутну фігуру.
 * Результат виводиться на екран і записується у файл MyFile.txt.
 * </p>
 */

public class Lab1Kovlyha305 {

    /**
     * Точка входу в програму.
     * <p>
     * Програма зчитує розмір матриці та символ-заповнювач від користувача,
     * створює трикутний масив символів, виводить його на екран і зберігає у файл.
     * </p>
     *
     * @param args аргументи командного рядка (не використовуються)
     * @throws FileNotFoundException якщо не вдасться створити або відкрити файл MyFile.txt
     */

    public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // Зчитування розміру квадратної матриці

        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();

        // Ініціалізація "трикутного" масиву (кожен рядок коротший за попередній)
        arr = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            arr[i] = new char[nRows - i];
        }

        // Зчитування символу-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        filler = in.nextLine();

        // Перевірка коректності введеного символу

        if (filler.length() != 1) {
            System.out.println("Помилка: Необхідно ввести рівно один символ.");
            fout.close();
            return;
        }

        // Отримання символу з рядка
        char fillChar = (char) filler.codePointAt(0);

        // Виведення та запис сформованого масиву

        System.out.println("\nСформований масив:");
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows - i; j++) {
                arr[i][j] = fillChar;
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }
            System.out.println();
            fout.println();
        }

        // Закриття потоку виведення

        fout.flush();
        fout.close();
    }
}
