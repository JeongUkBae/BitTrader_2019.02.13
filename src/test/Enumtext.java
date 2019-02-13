package test;


public class Enumtext {
	public static void main(String[] args) {
		int total = 31;
		int size = 5;
		int num = 7;
		
		int startrow = 0;
		int endrow = 0;
		
		int count = total / size; 
		System.out.println("count의 나누기는?"+count);
		if(total%size != 0) {
			count = count+1;
		System.out.println("count의 나머지는?"+count);
		}
		
		int ex = count*size;
		startrow = total - (size*num)+1;
		
		
		endrow = startrow + size-1;
		if(endrow<=0) {
			endrow = endrow+size;
		}

		System.out.println("1. end:: "+ex);
		System.out.println("=== endrow:: "+endrow);
		System.out.println("=== startrow:: "+startrow);
		
	
		
		
		
	}
}
