package tangible;
import java.util.Scanner;

public class Main {
	private static double Main()
	{
	int n = 0;
	double h1 = 0;
	Scanner scanInput = new Scanner(System.in);
	String tempVar = scanInput.nextLine();
	if (tempVar != null)
	{
		n = Integer.parseInt(tempVar);
	}
	String tempVar2 = scanInput.nextLine();
	if (tempVar2 != null)
	{
		h1 = Double.parseDouble(tempVar2);
	}
	double left = 0;
	double right = h1;
	double last = -1;
	while ((right - left) > 0.01 / (n - 1))
	{
	double mid = (left + right) / 2;
	double prev = h1;
	double cur = mid;
	boolean aboveGround = cur > 0;
	for (int i = 3; i <= n; i++)
	{
	double next = 2 * cur - prev + 2;
	aboveGround &= next > 0;
	prev = cur;
	cur = next;
	}
	if (aboveGround)
	{
	right = mid;
	last = cur;
	}
	else
	{
	left = mid;
	}
	}
	assert right < h1;
	System.out.println(last);
	return last;
	}




}
