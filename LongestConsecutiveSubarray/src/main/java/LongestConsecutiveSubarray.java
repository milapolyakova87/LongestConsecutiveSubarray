import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestConsecutiveSubarray {

    // Метод для нахождения максимальной длины подмассива с последовательными элементами
    public static int findLongestConsecutiveSubarray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        // Сортируем массив
        Arrays.sort(array);

        int maxLength = 1;
        int currentLength = 1;

        // Проходим по отсортированному массиву
        for (int i = 1; i < array.length; i++) {
            // Если текущий элемент на 1 больше предыдущего, увеличиваем длину последовательности
            if (array[i] == array[i - 1] + 1) {
                currentLength++;
            }
            // Если текущий элемент равен предыдущему, пропускаем (дубликаты)
            else if (array[i] == array[i - 1]) {
                continue;
            }
            // Иначе, сбрасываем длину последовательности
            else {
                currentLength = 1;
            }

            // Обновляем максимальную длину
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Используем ArrayList для динамического ввода массива
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("Введи элементы массива через запятую или пробел:");

        // Считываем всю строку
        String input = scanner.nextLine();

        // Разделяем строку на числа по запятым или пробелам
        String[] tokens = input.split("[,\\s]+");

        // Преобразуем строки в числа и добавляем в ArrayList
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token.trim());
                arrayList.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: '" + token + "' не является числом. Пропускаем.");
            }
        }

        // Преобразуем ArrayList в массив int[]
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }

        // Находим максимальную длину подмассива с последовательными элементами
        int result = findLongestConsecutiveSubarray(array);

        // Выводим результат
        System.out.println("Максимальная длина подмассива с последовательными элементами: " + result);

        scanner.close();
    }
}