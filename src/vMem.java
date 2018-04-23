import java.util.Scanner;

public class vMem {
	private int pageSize = 4096;
	
	public vMem() {
		setPageSize();
		
		
	}
	
	void setPageSize() {
		Scanner getInput = new Scanner(System.in);
		System.out.print("Please enter page size: ");
		pageSize = getInput.nextInt();
		
		while (isPowerOfTwo(pageSize) && (pageSize > 1024) && (pageSize < 16384)) {
			System.out.print("Please enter page size: ");
			pageSize = getInput.nextInt();
		}
		
		getAddress();
	}
	
	private void getAddress() {
		Scanner getInput = new Scanner(System.in);
		
		System.out.print("Please enter an address(in decimal): ");
		int addressDec = getInput.nextInt();
		calculatePNum(addressDec);
		
	}
	
	private void calculatePNum(int a) {
		int modResult = a % pageSize;
		int pageNumb = (int) Math.floor(a/4096);
		
		System.out.println("Page Number: " + pageNumb);
		System.out.println("Offset " + modResult);
	}
	
    private boolean isPowerOfTwo(int n)
    {
        if (n == 0) {
            return false;
        }
        
        while (n != 1)
        {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        
        return true;
    }
 
}
