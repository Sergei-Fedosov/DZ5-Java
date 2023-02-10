import java.util.HashMap;

public class Task0 {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    // Пусть дан список сотрудников:Иван Иванов (и остальные, полный текст дз будет на платформе)
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.

//    Иван Иванов 88001122333
//    Иван Курицин 88001662333
//    Иван Курицин 88001112333
//    Иван Незлобин 88001122432
//    Сергей Потапов 88001112453
//    Сергей Потапов 8800163214
//    Сергей Курицин 8800142421
//    Михаил Незлобин 880012343
//
//    OutPut
//    Иван - 3
//    Сергей - 2
//    Потому как если один сотрудник имеет 2 или более номера , его имя считаем 1 раз.

    public static void main(final String[] args) {
        HashMap<Long, String> passportsAndNames = new HashMap<>();
        HashMap<String, Integer> output = new HashMap<>();

        passportsAndNames.put(88001122333l, "Иван Иванов");
        passportsAndNames.put(88001662339l, "Иван Курицин");
        passportsAndNames.put(88001662330l, "Иван Курицин");
        passportsAndNames.put(88001112333l, "Иван Незлобин");
        passportsAndNames.put(88001112453l, "Сергей Потапов");
        passportsAndNames.put(8800163214l, "Сергей Потапов");
        passportsAndNames.put(8800142421l, "Сергей Курицин");
        passportsAndNames.put(880012343l, "Михаил Незлобин");

        var namesArray = passportsAndNames.values().stream().map(item -> getName(item)).toArray(String[]::new);
        passportsAndNames.forEach((key, value) -> {
            String name = getName(value);
            int countDuplicate = findDuplicate(namesArray, name);
            if (countDuplicate > 1) {
                if (output.get(name) == null) {
                    output.put(name, countDuplicate);
                }
            }
        });
        output.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });
    }

    public static String getName(String fullName) {
        return fullName.split("\\s+")[0];
    }

    public static int findDuplicate(String[] arr, String name) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(name)) count++;
        }
        return count;
    }
}



