import java.util.Scanner;

public class Demo123 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a num");
		int num=sc.nextInt();
		int div=num/2;
		int flg=0;
		if(num==0||num==1)
		{
			System.out.println("not prime");
		}
		else
		{
			for(int i=3;i<=div;i++)
			{
				if(num%i==0)
				{
					System.out.println("not prime");
					flg=1;
					break;
				}
				
			}
			if(flg==0)
			{
				System.out.println("prime number");
			}
		}
	}

}
