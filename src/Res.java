public class Res {//Вывод результата
    public void result(Integer[] result) {
        Integer flag = result[1]; //Получаем флаг
        switch (flag) { //Выбираем как выводить
            case 1://Римские
                    if (result[0] <= 0 || result[0] == -100) {//Проверка
                    System.out.println("Некорректные данные ");
                        if (result[0] == -101) {//Дополнительное сообщение об ошибке
                            System.out.println("Нет оператора");
                        }
                } else {
                    Arab2Rome arab = new Arab2Rome();
                    String result_rome = Arab2Rome.arabToRome(Integer.toString(result[0]));//Переводим обратно в римские
                    System.out.println("Результат " + result_rome);//Выводим результат римскими цифрами
                }
                break;
            case 0:
                    if (result[0] <= 0 || result[0] == -100) {//Проверка
                    System.out.println("Некорректные данные ");
                    if (result[0] == -101) {//Дополнительное сообщение об ошибке
                        System.out.println("Нет оператора");
                    }
                    }
                else {
                    System.out.println("Результат " + result[0]);//Выводим результат арабскими цифрами
                }
                break;


        }
    }

}


