import java.util.Arrays;
import java.util.Scanner;

public class P_2048 {
	
		public static int grid;
		public static Scanner sc = new Scanner(System.in);
		public static String replay = "y";
		public static int[][] arr;
		public static int highScore;

		
    	public static void main(String[]  args){
		
    		
    		int arr[][] = newGame();
    		
    		while(replay.equals("y")){
   			
	   			
//	Arr'ý kopyaladýk Yaslý diye yeni bi arraye. 
//	Kaydýrma iþleminden sonra kontrol edeceðiz. 
	   			int copyArr[][] = new int[grid][grid];
	    		
		   		for(int i=0; i<grid; i++)
		   			for(int j=0; j<grid; j++)
		   				copyArr[i][j] = arr[i][j];
	    				
//	TAHTAYI KAYDIRMA	*******************************************************
	    		String direction = sc.nextLine();
	    		
		    	switch(direction){
		    			
		    		case "w":
		    			SlideTable.Align_Up(arr);
		    			SlideTable.Sum_Up(arr);    	    		
		    			SlideTable.Align_Up(arr);
		    			break;
		    			
		    		case "a":
		    			SlideTable.Align_Left(arr);    	    		
		    			SlideTable.Sum_Left(arr);    	    		
		    			SlideTable.Align_Left(arr);
		    			break;
		    			
		    		case "s":
		    			SlideTable.Align_Down(arr);    	    		
		    			SlideTable.Sum_Down(arr);    	    		
		    			SlideTable.Align_Down(arr);
		    			break;
		   			
		   			case "d":
		   				SlideTable.Align_Right(arr);
		   				SlideTable.Sum_Right(arr);
		   				SlideTable.Align_Right(arr);
	    				break;		    			
		    		default:
		    			System.out.println("INVALID INPUT! ENTER AGAIN..");
		    			continue;
		    	}
//	***************************************************************************	    	
		    		
//	EÐER KAYMA ZATEN YASLI BÝR YERE ÝSE	**************************************************
//	RANDOM SAYI ATMASIN
		    	boolean boardsEqual=true;
		    	
		    	for(int i=0; i<grid; i++)
		   			for(int j=0; j<grid; j++)
		   				if(copyArr[i][j]!=arr[i][j] && boardsEqual==true){
		   					boardsEqual = false;
		   					RandomAt(arr);
		   					showboard(arr);
		   					System.out.println("Current Score: " + SlideTable.Score);
		   				}
		   				
		    	if(boardsEqual==true)
		    		System.out.print("FILLED DIRECTION! Enter Again.. ");
//****************************************************************************************		    	
		    	
		    	arr = GameOver(arr);
	   			
		    		
	    	}
		    	
    	 
}
    	
    	
    	public static int[][] newGame(){
    		
    		
    		System.out.print("Enter dimension:  ");
    		
    		grid = sc.nextInt();
	
			int board[][] = new int[grid][grid];
		
			RandomAt(board);
			RandomAt(board);
	
			showboard(board);
			
			System.out.println("Current Score: " + SlideTable.Score);
    		
    		return board;
    	}
    	

		public static void showboard(int[][] board){
			
				String bs[][] = new String[grid][grid];
				for(int i=0; i<grid; i++)
		   			for(int j=0; j<grid; j++)
		   				if(board[i][j]==0)
		   					bs[i][j] = " ";
		   				else
		   					bs[i][j] = String.valueOf(board[i][j]);
				
				
		    		for(int r=0; r<grid; r++){
		    			
		    			for(int i=0; i<grid; i++)System.out.print("+----");
		    				System.out.println("+");	
		    			
		    			for(int c=0; c<grid; c++)
		    				System.out.printf("|%4s", bs[r][c] );
		    			
		    			System.out.println("|");
		    		}
		    		for(int x=0;x<grid;x++)System.out.print("+----");
		    			System.out.println("+");
		}

		
		public static void RandomAt(int[][] board){
			
			boolean RandomCreated = false;
			
			while(RandomCreated==false){
				
//	RASTGELE SATIR VE SÜTUN SEÇ & RANDOM 2 YADA 4 ÝÇÝN ZAR AT (TWOorFOUR)			
				int RandomR = (int)(Math.random() * grid);
				int RandomC = (int)(Math.random() * grid);
				int TWOorFOUR = (int)(Math.random() * 3);    			
					
				if(board[RandomR][RandomC]==0){
						
					switch(TWOorFOUR){
						case 0:
							board[RandomR][RandomC] = 2;	break;
						case 1:
							board[RandomR][RandomC] = 2;	break;
						case 2:
							board[RandomR][RandomC] = 4;	break;
					}
						
					RandomCreated=true;
				}
				
			}
			
		}

		
		public static int[][] GameOver(int[][] board){
			
//	TABLODA BOÞLUK VAR MI	*******************************************	
			boolean AnyZero=false;
			for(int i=0; i<grid; i++)
				for(int j=0; j<grid; j++)
					if(board[i][j]==0 && AnyZero==false)
						AnyZero=true;
//	*******************************************************************
			
			
			if(AnyZero==false){
				
//	TABLO DOLDUÐUNDA TOPLANACAK SAYI VAR MI DÝYE
//	HER YÖNE KAYDIRMA YAP. KOPYA ARRAY DEÐÝÞTÝYSE VAR DEMEK:
//	KAYIRSA SAYILAR, OYUNU BÝTÝRME
				
					boolean Still_Slideable=false;
					
					int copyArr[][] = new int[grid][grid];
					for(int i=0;i<grid;i++)
						for(int j=0; j<grid; j++)
							copyArr[i][j] = board[i][j];
		
					int tempScore = SlideTable.Score;
					SlideTable.Sum_Left(copyArr);
					SlideTable.Sum_Right(copyArr);
					SlideTable.Sum_Up(copyArr);
					SlideTable.Sum_Down(copyArr);
					SlideTable.Score = tempScore;
		
					for(int i=0;i<grid;i++)
					for(int j=0;j<grid;j++)
						if(copyArr[i][j] != board[i][j] && Still_Slideable==false)
							Still_Slideable=true;
//	*******************************************************************************
					
//	KOPYA ARRAY HER YÖNE KAYDI YÝNE DE ASIL ARRAYLER AYNI KALDI
//	ÖYLEYSE OYUNU BÝTÝR				
					if(Still_Slideable==false){
						System.out.println("\nGAME OVER!\n");
						System.out.println("Your Score: " + SlideTable.Score);
						
						if(SlideTable.Score > highScore){
							System.out.println("NEW RECORD! CONGRATULATIONS");
							highScore = SlideTable.Score;
						}
							System.out.println("High Score: " + highScore);
							
				//	YENÝDEN BAÞLAMAK						
						while(true){
							
							System.out.println("\nPlay again? y or n..");
							replay = sc.nextLine();
						
							if(replay.equals("y")){
								SlideTable.Score = 0;
								board = newGame();
								break;
							}
							if(replay.equals("n")){
								System.out.println("GAME IS CLOSED");
								System.exit(0);
							}
						}
				//	***************************************************
					}
//	************************************************************************************				
				
			}
			
			return board;
		}

}