import java.util.Scanner;


public class DataRead { //Чтение данных с проверкой на правильность
    String[] arabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}; //Проверочный массив арабских чисел
    String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};//Проверочный массив римских чисел

    public String[] read() {
        int i = 0;
        System.out.println("Введите выражение, состоящее из двух целых чисел от 0 до 10 и знака операции через пробел (напр. 2 + 2): ");
        Scanner scanner = new Scanner(System.in); //Вводим строку
        String text = scanner.nextLine();
        String input = text;
        String[] blocks = new String[4]; //создаем массив для выражения и для флага римские или арабские
        for (
            String in_string : input.split(" ", 3)) { //Делим на символы, звгоняем в массив
            blocks[i] = in_string.toUpperCase(); //Надоело нажимать шифт, загнал сразу в верхний регистр
            i++;
        }
        blocks[3] = "0"; //Флаг римские, если 1
        for (int i1 = 0; i1 < rome.length; i1++) {
              if (rome[i1].equals(blocks[0]) || rome[i1].equals(blocks[2])) {
                blocks[3] = "1";
                 }

        } //Римские цифры
                if (Integer.parseInt(blocks[3])==1) { //Если цифры римские
                    int a1 = Rome2Arab.romeToArab(blocks[0]); //Переводим в арабские, загоняем результат в int
                    int a2 = Rome2Arab.romeToArab(blocks[2]);
                        if ((a1 < 0 || a1 > 10) || (a2 < 0 || a2 > 10)) {   //Проверка. Коряво, но работает
                               blocks[0] = "0"; //Загоняем а массив значения, для сообщения об ошибке
                               blocks[1] = "-";
                               blocks[2] = "100";
                        }
                    else//Если проверка прошла
                        {
                    blocks[0] = Integer.toString(a1); //Загоняем результат в массив
                    blocks[2] = Integer.toString(a2);
                        }
                    return blocks; //Возвращаем значения и флаг
                }
//Арабские цифры
            else { //Проверка
                    Integer a1=0,a2=0;
                    for (int i1 = 0; i1 < arabic.length; i1++){
                        if (isNumber(blocks[0]) ==false || isNumber(blocks[2])==false){//Проверяем, числа ли в массиве
                            blocks[0] = "0"; //Если не число, то забиваем массив значениями для ошибки
                            blocks[1] = "-";
                            blocks[2] = "100";
                        }
                        else {//Проверка удачно
                            a1 = Integer.parseInt(blocks[0]); //Загоняем в переменные. Для дальнейшей проверки. Костыль.
                            a2 = Integer.parseInt(blocks[2]); //Можно сделать по другому, проверка на число делалась после всего
                        }
                    }
                    if ((a1 < 0 || a1 > 10) || (a2 < 0 || a2 > 10)) {   //Проверка. Коряво, но работает
                        blocks[0] = "0";//Если не прошло, то забиваем массив значениями для ошибки
                        blocks[1] = "-";
                        blocks[2] = "100";
                    }

            }
        return blocks;//Возвращаем значения и флаг
        }


    public boolean isNumber(String str) {//Проверка, число ли
        if (str == null || str.isEmpty()) return false;//Если пустая строка то ложь
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;//Если не число то ложь
        }
        return true;
    }

}
