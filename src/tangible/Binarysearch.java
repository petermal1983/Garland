package tangible;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;

public class Binarysearch {
    private static final String errorFile="Ошибка! Файл не открылся!";
    private static final String errorConsole="Ошибка! Введенные данные имеют не верный тип!";

   

    private static int n = 0; //число лампочек
    private static double h1 = 0; // высота первой лампочки, вещественное (выберем тип double)
    static Scanner input = null;
    private static boolean flag=true;
    private static Garland gar;
    public static void main(String args[]) throws IOException {
        // Создание объекта FileWriter
    	FileWriter writer = new FileWriter(new File("garland.out"));
    	if(!fileRead(args))
    		System.exit(-1);
    	if(!modeling())
    		System.exit(-1);
    	int type=writeFile("garland.out", args);
    	if(type==-1)
    		System.exit(-1);
		gar.show(n);
    }
    
    
    	static public boolean modeling() {
    		try {gar = new Garland(n,h1);} //попытка инициализации значений, в случае несоотвествия типов метод останавливается
    		catch(Exception e) {
    			return false;
    		}
    		while ((gar.right - gar.left) > 0.01 / (n - 1)) // Максимальное число итераций. Цикл работает пока разница между наибольшей высотой и наименьшей не									
    			// составит меньше 0.01/(n-1) (на сколько должны различаться высоты соседних лампочек, чтобы высота последней выводилась с точностью 0,01)
    		{
    		    double[] mass=gar.massLamp; // Временная переменная, которая хранит в себе состояние массива, до будующих изменений
    			double mid = (gar.left + gar.right) / 2; // Считаем среднее значение между минимальной и максимальной высотой
    			double prev = h1;// Высота прерыдущий лампочки(в первый заход присваивается высоте первой
    								// лампочки)
    			double cur = mid;// Высота текущей лампочки(в первый заход второй лампочки)
                gar.massLamp[1]=cur; //Записываем высоту второй лампы.
    			boolean aboveGround = cur > 0; // Проверка: не коснулась ли герлянда земли. То есть высота текущей лампочки
    											// больше 0?
    			for (int i = 3; i <= n; i++) // Моделирование высот остальных лампочек. После 1 и 2 соотвественно идет 3.
    											// Моделирование проходит с учетом текущих left и right
    			{
    				double next = 2 * cur - prev + 2; // Высота следующей лампочки. Высчитывается cur =((next+prev)/2) -1
    													// -next/2=prev/2-cur-1 -next=prev-2cur-2 next=-prev+2cur+2
    				aboveGround &=  next > 0; // Проверка высоты новой лампочки, не ниже ли она чем 0 и гирлянда									// вся должна быть не ниже 0(то есть вторая лампочка)
    				if(aboveGround) // Если герлянда не коснулась пола, тогда запишем новую лампу в массив
    				    gar.massLamp[i-1]=next;
    				else gar.massLamp=mass;//Иначе вернем массив в состояние до записи
                    prev = cur; // Текущая лампоча записывается как предыдущая
    				cur = next; // В текущее значение записывается новое лампочка. Мы как бы проходим как список
    							// лампочки
    			}
    			if (aboveGround) // Если герлянда ни разу не коснулась пола, то понижается максимальная высота
    								// всей герлянды на среднее значение минимальной и максимальной высоты из
    								// предыдущего шага цикла и записывается результат последней лампочки в
    								// переменную last
    			{
    				gar.right = mid;
    				gar.last = cur;
    			} else // Если герлянда косается пола, то тогда минимальная высота повышается на
    					// среднее значение минимальной и максимальной высоты из предыдущего шага цикла
    			{
    				gar.left = mid;
    			}
    		}
    		return true;
    	}
    	
		static public int writeFile(String path, String[] args) {
			FileWriter writer;
			try {
				writer = new FileWriter(new File(path));
			} catch (IOException e) {
				return -1;
			}
			// Запись содержимого в файл
			DecimalFormat decimal = new DecimalFormat("#.##");
			decimal.setRoundingMode(RoundingMode.DOWN);
			if (args.length != 0 & flag) {
				try {
					writer.write(String.valueOf(decimal.format(gar.last)));
					writer.flush();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					return -1;
				}
				return 1;
			} else {
				if(gar.last==0 || gar.last==-1)
					return -1;
				else {
					System.out.println(decimal.format(gar.last));
					return 0;
				}
			}      
	}
    
    private static String fileRead( String arg){
	    String result="";
	    try {
            input = new Scanner(new File(arg));
            result="Файл Открылся. Все в порядке";
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            result=errorFile;
        }
        return result;
    } 
    public static String consoleRead(Scanner input){
        if (input.hasNextInt())// Проверка введеных данных на принадлежности типу целочисленных значений
            n = input.nextInt(); // Запись значений целочисленных в переменную n
        else
            return errorConsole;
        if (input.hasNextDouble())// Проверка введеных данных на принадлежность вещественному типу
            h1 = input.nextDouble();// Запись значений вещественных в переменную h1
        else
            return errorConsole;
        return "Все считалось";
    }
    
    public static boolean fileRead(String[] args) {
 		// Создаем объект Scanner для считывания чисел, введенных пользователем
         if (args.length != 0) {
             if (errorFile == fileRead(args[0])) {
                 System.err.print(errorFile);
                 System.out.println("Ввод с консоли");
                 flag=false;
                 input = new Scanner(System.in);
                 if (errorConsole == consoleRead(input)) {
                     System.err.println(errorConsole);
                     return false;
                 }
             }
             else {
            	 consoleRead(input);
             }
         }
         else {
        	 System.out.println("Файлы не указаны, ввод с консоли");
             input = new Scanner(System.in);
             if (errorConsole == consoleRead(input)) {
                 System.err.println(errorConsole);
                 return false;
             }
         }
         return true;
    }
    public static void clean() {
    	n=0;
    	h1=0;
    	gar.last=0;
    	gar.left=0;
    	gar.right=0;
    }
}