import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> telBook = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        Integer number;
        String numberString;

        for(;;){
            String text = scanner.nextLine();

            if (text.matches("^LIST$")) { // LIST
                System.out.println("Список телефонных номеров: ");
                for (Integer num : telBook.keySet()) {
                    System.out.println(num + " - " + telBook.get(num));
                }
            }
            else if (text.matches("^[a-zA-Zа-яА-ЯЪъ]+$")) { // поиск по имени
                if (!telBook.containsValue(text)){
                    System.out.println("Введите номер телефона");
                    numberString = scanner.nextLine().replaceAll("\\D", "");
                    number = Integer.parseInt(numberString);
                    if (telBook.containsKey(number)){
                        System.out.println("Имя будет изменено для данного номера на " + text);
                        telBook.put(number, text);
                    }
                    else {
                        telBook.put(number, text);
                        System.out.println("Номер телефона " + number + " сохранен");
                    }
                }
                else {
                    for(Integer num: telBook.keySet()) {
                        if(text.equals(telBook.get(num))) {
                            System.out.println("Имя: " + text + " - Номер телефона: " + num);
                        }
                    }
                }
            }

            if (text.matches("^[-\\+()0-9]+$")){   // поиск по номеру
                numberString = text.replaceAll("\\D", "");
                number = Integer.parseInt(numberString);
                if(!telBook.containsKey(number)){
                    System.out.println("Введите Имя");
                    text = scanner.nextLine();
                    if(text.matches("^[a-zA-Zа-яА-ЯЪъ]+$")) {
                        telBook.put(number, text);
                        System.out.println("Имя " + text + " сохранено");
                    }
                    else {
                        System.out.println("Введите корректное имя");
                    }
                }else{
                    System.out.println("Имя: " + telBook.get(number) + " - Номер телефона: " + number );
                }
            }
        }
    }
}

