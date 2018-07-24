
public class SlideTable {
	
	public static int Score=0;
	
	 public static int[][] Align_Left(int[][] a){
		 
		 int zeros=0;
		 for (int i = 0; i<P_2048.grid; i++){
		
			 for (int j = 0; j<P_2048.grid; j++){
				 	  
				 if(a[i][j]==0)
					 zeros++;
				 
				 else{
					
					int temp=a[i][j-zeros];
					a[i][j-zeros]=a[i][j];
					a[i][j]=temp;

					j=j-zeros;
					zeros=0;
					
				 }
				  
		 }
			 zeros=0;
		 }

		 return a;
	 }

	public static int[][] Sum_Left(int[][] t){
		
		for(int i=0; i<P_2048.grid; i++)
			 for (int j = 0; j <P_2048.grid-1; j++){
				 if(t[i][j]==t[i][j+1]){
					t[i][j]*=2;
					t[i][j+1]=0;
					Score+=t[i][j];
			}
		}
		
		return t;
	}

	public static int[][] Align_Right(int[][] a){
		 
		 int zeros=0;
		 for (int i = P_2048.grid-1; i>=0; i--){

		
			 for (int j = P_2048.grid-1; j>=0; j--){
				 	  
				 if(a[i][j]==0){
					 zeros++;

				 }
				 else{
					
					int temp=a[i][j+zeros];
					a[i][j+zeros]=a[i][j];
					a[i][j]=temp;

					j=j+zeros;
					zeros=0;
					
				 }
				  
		 }
			 zeros=0;
		 }

		 return a;
	}

	public static int[][] Sum_Right(int[][] t){
		
		for(int i=P_2048.grid-1; i>=0; i--)
			 for (int j = P_2048.grid-1; j>0; j--){
				 if(t[i][j]==t[i][j-1]){
					t[i][j]*=2;
					t[i][j-1]=0;
					Score+=t[i][j];
			}
		}
			
		return t;
	}

	public static int[][] Align_Up(int[][] a){
		 
		 int zeros=0;
		 for (int j = 0; j<P_2048.grid; j++){
		
			 for (int i = 0; i<P_2048.grid; i++){
				 	  
				 if(a[i][j]==0)
					 zeros++;
				 
				 else{
					
					int temp=a[i-zeros][j];
					a[i-zeros][j]=a[i][j];
					a[i][j]=temp;

					i=i-zeros;
					zeros=0;
					
				 }
				  
		 }
			 zeros=0;
		 }

		 return a;
	}

	public static int[][] Sum_Up(int[][] t){
		
		for(int j=0; j<P_2048.grid; j++)
			 for (int i = 0; i<P_2048.grid-1; i++){
				 if(t[i][j]==t[i+1][j]){
					t[i][j]*=2;
					t[i+1][j]=0;
					Score+=t[i][j];
			}
		}
		
		return t;
	}

	public static int[][] Align_Down(int[][] a){
		 
		 int zeros=0;
		 for (int j = P_2048.grid-1; j >=0; j--){

			 for (int i = P_2048.grid-1; i>=0; i--){
				 	  
				 if(a[i][j]==0){
					 zeros++;

				 }
				 else{
					
					int temp=a[i+zeros][j];
					a[i+zeros][j]=a[i][j];
					a[i][j]=temp;

					i=i+zeros;
					zeros=0;
					
				 }
				  
		 }
			 zeros=0;
		 }

		 return a;
	}

	public static int[][] Sum_Down(int[][] t){
		
		for(int j=P_2048.grid-1; j>=0; j--)
			 for (int i=P_2048.grid-1; i>0; i--){
				 if(t[i][j]==t[i-1][j]){
					t[i][j]*=2;
					t[i-1][j]=0;
					Score+=t[i][j];
			}
		}
			
		return t;
	}

}
