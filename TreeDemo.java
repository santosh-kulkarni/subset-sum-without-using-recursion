import java.util.*;
class TreeDemo
{
	int count = 1;
	public void printSolution(int index , int[] original , int level)
	{	
		System.out.print("Solution "+count+" is = { ");
		while(index != 0)
		{
				if(index % 2 == 0 )
				{
					System.out.print(original[level]+" ");
				}
			level = level - 1;
			index = index / 2;
		}
		System.out.println("}");
		count++;
	}
	public static void main(String[] args)
	{
		int k = 0,i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();
		System.out.println("Enter the Elements");
		int ele[] = new int[n+1];
		for(i=1 ;i<=n; i++)
			ele[i] = sc.nextInt();
		System.out.println("Enter the sum to be obtained");
		int sum = sc.nextInt();
		int level = 1;
		int len = (int)Math.pow(2,n+1);
		int arr[] = new int[len];
		arr[1] = arr[0] = 0;
		k = 2;
		int parent;
		while(k < len)
		{
			for(i = k; i<k+(int)Math.pow(2,level); i++)
			{
				if(i%2 == 0)
				{
					parent = i/2;
					arr[i] = arr[parent] + ele[level];
				}
				else
				{
					parent = i/2;
					arr[i] = arr[parent];
				}
			}
			level = level + 1;
			k = i;
		}
//		for(i=1; i<len ; i++)
//			System.out.print(arr[6] + " ");
//		System.out.println();i
		TreeDemo obj = new TreeDemo();
		for(i=(int)Math.pow(2,n); i<len; i++)
		{
			if(arr[i] == sum)
			{
				obj.printSolution(i,ele,n);
			}
		}
	}
}
																								
