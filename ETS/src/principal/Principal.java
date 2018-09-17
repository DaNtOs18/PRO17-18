package principal;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
	    int array []=new int[10];
        Scanner leer=new Scanner(System.in);
        int cont = 0;
        int num,x;
        for(x=0; x<10; x++){
            System.out.println("Teclea el numero "+(x+1));
            array[x]=leer.nextInt();
            }
        
        for(x=0; x<10; x++){
        	
        	System.out.println("contador  "+cont);
        	
            System.out.println("********************************************************************");
            if(array[x]%2==0){
                System.out.println(array[x]+" es par");
                cont ++;
           }else{
        	   
               System.out.println(array[x]+" es impar");
               cont ++;
           }    
            
            System.out.println("total contador  "+cont);
            }}  }





