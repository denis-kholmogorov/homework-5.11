import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> telBook = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String number;


        for(;;){
            String text = scanner.nextLine();

            if (text.matches("^LIST$")) { // LIST
                System.out.println("Список телефонных номеров: ");
                for (String word : telBook.keySet()) {
                    System.out.println(word + " - " + telBook.get(word));
                }
            }
            else if (text.matches("^[a-zA-Zа-яА-ЯЪъ]+$")) { // поиск по имени
                if (!telBook.keySet().contains(text)){
                    System.out.println("Введите номер телефона");
                    number = scanner.nextLine().replaceAll("\\D", "");
                    telBook.put(text, Integer.parseInt(number));
                    System.out.println("Номер телефона " + number + " сохранен");
                }
                else if (telBook.keySet().contains(text)){
                    System.out.println("Имя: " + text + " - Номер телефона: " + telBook.get(text));
                }
            }

            if (text.matches("^[-\\+()0-9]+$")){   // поиск по номеру
                number = text.replaceAll("\\D", "");
                if(!telBook.containsValue(Integer.parseInt(number))){
                    System.out.println("Введите Имя");
                    text = scanner.nextLine();
                    if(text.matches("^[a-zA-Zа-яА-ЯЪъ]+$")) {
                        telBook.put(text, Integer.parseInt(number));
                        System.out.println("Имя " + text + " сохранено");
                    }
                    else {
                        System.out.println("Введите корректное имя");
                    }
                }else if (telBook.containsValue(Integer.parseInt(number))){
                    for (String word: telBook.keySet()){
                        if(telBook.get(word) == Integer.parseInt(number)){
                            System.out.println("Имя: " + word + " - Номер телефона: " + number);
                        }
                    }
                }
            }
        }
    }
}
