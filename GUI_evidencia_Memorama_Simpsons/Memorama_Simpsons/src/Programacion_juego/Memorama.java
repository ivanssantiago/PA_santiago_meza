/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programacion_juego;

import java.util.Random;

/**
 *
 * @author Familia
 */
public class Memorama {
    //creación de un arreglo aleatorio
    //arreglos distintos de cartas en el juego
    public int[] getCardNumbers(){
        //creamos nuerstro arreglo de 16 cartas
        int num[]=new int[16];
        int conta=0;
        
        //creamos el ciclo aleatorio
        while(conta<16){
            //random crea nuestro objeto de tipo aleatorio
            //para usarlo necesitamos la libreria java.util.Random anexada al inicio
            //usamos su constructor y la función que lo manda a llamar:
            Random r =new Random();
            //semilla del objeto random
            int n1=r.nextInt(8)+1;
            int n2=0;
            
            for(int i=0;i<16;i++){
                if (num[i]==n1){
                    n2++;
                }  
            }
            if (n2<2){
                num[conta]=n1;
                conta++;
            }
        }
        return num;
    } 
    
}
