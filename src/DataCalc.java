public class DataCalc { //Расчет
    public Integer[] dataCalc(String blocks[]) { //Собственно расчет
        float a1, a2;
        char operator;
        Integer result_f[] = {0, 0};//Массив для передачи результата и флага "римские"
        a1 = Float.parseFloat(blocks[0]); //Получаем аргумент
        char[] op = blocks[1].toCharArray();//Получаем оператор, загоняем в char
        operator = op[0];
        a2 = Float.parseFloat(blocks[2]);//Получаем аргумент
        int result = 0;
        result_f[1] = Integer.parseInt(blocks[3]); //получаем из массива с данными флаг "римские"
        switch (operator) {//Понеслись операции
            case '+':
                result = (int)(a1 + a2);
                result_f[0] = result; //Загоняем результат в массив
                break;
            case '-':
                result = (int)(a1 - a2);
                result_f[0] = result;//Загоняем результат в массив
                break;
            case '*':
                result = (int)(a1 * a2);
                result_f[0] = result;//Загоняем результат в массив
                break;
            case '/':  //А вот тут надо проверку, чтобы делилось целиком
                float temp_result = 0;
                temp_result = a1 / a2; //загоняем результат в float
                    if (temp_result != Math.round(temp_result)){ //Сравнивам результат
                        result_f[0] = -100;//Это для сообщения о неправильных параметрах
                }
                else {
                    result = (int)temp_result; //Целое число, ок
                    result_f[0] = result;//Загоняем результат в массив
                }
               break;

            default:
                result_f[0] = -101; //Если вместо оператора что то другое, то делаем сообщение об отсутсвии оператора
                break;
    }
return result_f ;//Возвращаем результат и флаг, для определения формата вывода результата
    }
}
