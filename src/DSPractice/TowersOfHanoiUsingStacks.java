import java.util.Scanner;

public class TowersOfHanoiUsingStacks {

	public static int N;

	/* Creating Stack array */

	public static java.util.Stack<Integer>[] tower = new java.util.Stack[4];

	public static void main(String[] args)

	{
		Scanner scan = new Scanner(System.in);
		tower[1] = new java.util.Stack<Integer>();
		tower[2] = new java.util.Stack<Integer>();
		tower[3] = new java.util.Stack<Integer>();

		System.out.println("Enter number of disks");
		int num = scan.nextInt();
		N = num;
		toh(num);
	}

	/* Function to push disks into stack */
	public static void toh(int numOfDisks)
	{
		for (int currDisk = numOfDisks; currDisk > 0; currDisk--){
			tower[1].push(currDisk);
		}
			
		display();
		move(numOfDisks, 1, 2, 3);
	}

	/* Recursive Function to move disks */
	public static void move(int topDisk, int from, int spare, int to)
	{
		if (topDisk > 0)
		{
			move(topDisk - 1, from, to, spare);
			int curr = tower[from].pop();
			tower[to].push(curr);
			display();
			move(topDisk - 1, spare, from, to);
		}
	}

	/* Function to display */
	public static void display()
	{
		System.out.println("  A  |  B  |  C");
		System.out.println("---------------");
		for (int i = N - 1; i >= 0; i--)
		{
			String d1 = " ", d2 = " ", d3 = " ";

			try

			{

				d1 = String.valueOf(tower[1].get(i));

			}

			catch (Exception e) {

			}

			try

			{

				d2 = String.valueOf(tower[2].get(i));

			}

			catch (Exception e) {

			}

			try

			{

				d3 = String.valueOf(tower[3].get(i));

			}

			catch (Exception e) {

			}

			System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);

		}

		System.out.println("\n");

	}

	// public static void main(String[] args){
	// int nDisks = 3;
	// moveDisks(nDisks, 'A', 'B', 'C');
	// }
	//
	public static void moveDisks(int topDisk, char from, char spare, char to) {
		if (topDisk == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			moveDisks(topDisk - 1, from, to, spare);
			System.out.println("Disk " + topDisk + " from " + from + " to "
					+ to);
			moveDisks(topDisk - 1, spare, from, to);
		}
	}
}
