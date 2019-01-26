package tangible;

import edu.princeton.cs.introcs.StdDraw;

 class Garland {
    double left;
    double right;
    double last;
    double[] massLamp;
    Garland(int n, double h1) {
        left = 0; // Bad. Наименьшее возможная высота следующей лампочки
        right = h1; // Good. Наибольшее возможная высота следующей лампочки
        last = -1; // Наименьшая итоговая высота последней лампочки. Задаем -1. Если высота ни разу
        // не посчитает, то она будет отрицательна, следовательно расчеты были проведены
        // не верны
        massLamp = new double[n]; // Массив высот лампочек длинной n -количества ламп
        massLamp[0]=h1; //Высота первой лампы известна - h1
    }
    
    public void show(int n){ //Метод отрисовки ламп и их соеднинений
        double max = massLamp[0]; // Алгоритм нахождения максимального числа. В данном случаи мы говорим, что переменная max является первым элементом массива.
        // Если не один элемент не будет больше первого, значит первый максимальный элемент
        for (int i =0; i<massLamp.length; i++){
            if(massLamp[i]>max)//Если элемент больше максимума
                max=massLamp[i];//Записыаем новый наибольший элемент в переменную max
        }
        StdDraw.setScale(n+2,max+2);
        StdDraw.setCanvasSize(1000,1000);//Устанавливаем размер окна 1000 на 1000 пикселей
        for (int i=0; i<massLamp.length; i++){// Цикл отрисовки герлянды - от нулевого до длинны массива - 1
            StdDraw.setPenRadius((3/max));// Устанавливаем размер ручки, который рисуем как 3/max
            StdDraw.setPenColor(StdDraw.RED);//Ставим цвет
            StdDraw.point((double)(i+1)/(n+1),massLamp[i]/(max+2));//Рисуем точку по координатм x и y.
                /*
                Так как точки x и y в системе отрисовки могут принимать значения только от 0 до 1, тогда мы устанавливаем x = номер лампочки+1(+1 делаем, чтобы точка не отрисовывалась на левом крае)/(n+1)(+1 делаем, для правого края)
                y=значение высоты текущей лампочки/(на максимальную высоту лампочки+2)(+2 для края верхнего)
                 */
            if(i+1<massLamp.length) { //Пока i не индекс последней лампы, мы рисуем линию от лампы текущей, до лампы следующей
                StdDraw.setPenRadius((1/max)); // Устанавливаем размер ручки, который рисуем как 1/max
                StdDraw.setPenColor(StdDraw.BLACK);//Ставим цвет
                StdDraw.line((double) (i + 1) / (n + 1), massLamp[i] / (max + 2), (double) (i + 2) / (n + 1), massLamp[i + 1] / (max + 2));
                    /* Линия строится через две точки, поэтому задаем координаты двух точки
                Так как точки x и y в системе отрисовки могут принимать значения только от 0 до 1, тогда мы устанавливаем x = номер лампочки+1(+1 делаем, чтобы точка не отрисовывалась на левом крае)/(n+1)(+1 делаем, для правого края)
                y=значение высоты текущей лампочки/(на максимальную высоту лампочки+2)(+2 для края верхнего)
                 */
            }
        }
    }
}