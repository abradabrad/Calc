
public class Calc {
    public static void main(String[] args) {

        DataRead reader = new DataRead(); //Считываем данные
        DataCalc calc = new DataCalc(); //Расчет
        Res res = new Res(); //Результат
        res.result(calc.dataCalc(reader.read()));

    }
}

