package Algo.Test;

class Test extends Thread{  
	int c = 0 ; 
	static int maxVal = 0;
	 public void run(){  
		 
		 for(int i=0 ; i<100 ; i++)
		      c++;  
		 
		 if (maxVal < c)
			 maxVal = c;
	 }  
	 
	public static void main(String args[]){  
		 Test t1=new Test();  
		 Test t2=new Test();  
		 Test t3=new Test();  
		 t1.start();  
		 try{  
		  t1.join();  
		 }catch(Exception e){System.out.println(e);}  
		  
		 t2.start();  
		 t3.start(); 
		 
		 System.out.print(maxVal);
	 }  
}
