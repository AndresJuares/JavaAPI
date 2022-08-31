
package proyectojava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class ProyectoJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
       
        
        DateTimeFormatter fecha= DateTimeFormatter.ofPattern("MM/yy");
        String FechaActual=fecha.format(LocalDateTime.now());
        SimpleDateFormat f1=new SimpleDateFormat("MM/yy");//TOMA MES Y AÑO DE LA TARJETA
        Date dt1=f1.parse(FechaActual);//CONTIENE LA FECHA DEL DIA DE HOY
        
        
        //CREACION DE TARJETAS
        Card tarjeta=new Card();
        tarjeta.SetMarca("nara");
        tarjeta.SetCardHolderName("Reinaldo Andres");
        tarjeta.SetCardHolderSurnname("Juares Acevedo");
        tarjeta.Setnrotarjeta("351698762516874643651684".toString());
        tarjeta.SetMonth(05);
        tarjeta.SetYear(23);
        tarjeta.SetFVenc(tarjeta);
        
        
        Card tarjeta1=new Card();
        tarjeta1.SetMarca("VISA".toUpperCase());
        tarjeta1.SetCardHolderName("andres");
        tarjeta1.SetCardHolderSurnname("juares");
        tarjeta1.Setnrotarjeta("66008877".toString());
        tarjeta1.SetMonth(20);
        tarjeta1.SetYear(25);
        tarjeta1.SetFVenc(tarjeta1);
        
       
        Card tarjeta2=new Card();
        tarjeta2.SetMarca("VISA".toUpperCase());
        tarjeta2.SetCardHolderName("andres");
        tarjeta2.SetCardHolderSurnname("juares");
        tarjeta2.Setnrotarjeta("66008877".toString());
        tarjeta2.SetMonth(20);
        tarjeta2.SetYear(25);
        tarjeta2.SetFVenc(tarjeta2);
        tarjeta2.SetImporte(5000);
        System.out.println("BIENVENIDO");
        System.out.println(tarjeta1.Distint(tarjeta2, tarjeta1));
        
        //ELIJO TARJETA 2
        int a=0;
        boolean entrada=false;
        boolean in=false;
        while(entrada!=true){
            while(in!=true){
                System.out.println("Eliga la opcion que quiera realizar: ");
                System.out.println("1- Ver información de la tarjeta");
                System.out.println("2- Es valida para operar ");
                System.out.println("3- Realizar una operación");
                System.out.println("4- Salir");
                System.out.println("\n");
            
               
                try{
                    Scanner text=new Scanner(System.in);
                    a=text.nextInt();
                    if(a>4){
                        System.out.println("Ingreso no valido, ingrese un numero");
                    }
                }
                catch(Exception e){
                    System.out.println("Ingreso no valido, ingrese un numero");
                    e.getMessage();
                }
                switch(a){
                 case 1:
                     for(String c:tarjeta2.info(tarjeta2)){
                         System.out.println(c);
                     }
                     break;
                 case 2:
                     entrada=tarjeta2.GetFVenc().before(dt1);
                     if(entrada==true){
                         System.out.println("Su tarjeta expiro");
                         entrada=true;
                         in=true;
                         break;
                     }
                     else
                        System.out.println("Su tarjeta es valida para operar");
                        System.out.println("Su tarjeta vence el "+tarjeta2.GetFVenc().toString());
                        break;
                 case 3:
                     Scanner text1=new Scanner(System.in);
                     try{
                        System.out.println("1- Sacar importe");
                        
                        a=text1.nextInt();
                     }
                     catch(Exception e){
                         System.out.println("Ingreso no valido");
                     }
                     if(a==1){
                         try{
                            System.out.println("Ingrese importe");
                            a=text1.nextInt();
                         }
                         catch(Exception e){
                             System.out.println("Ingreso no valido, ingrese un importe");
                         }
                         if(a<1000){
                             System.out.println(tarjeta2.TasaOperacion(tarjeta2));
                             double d=tarjeta2.GetImporte(tarjeta2)-tarjeta2.TasaCard(tarjeta2)-a;
                             System.out.println("Su importe es de: $"+d);
                             tarjeta2.SetImporte(d);
                             break;
                        }
                        else{
                            System.out.println("El importe es mayor a 1000");
                            break;
                        }
                     }
                     else{
                         System.out.println("Operacion no valida");
                         break;
                     }
                 
                 case 4:
                        if(a==4){
                            in=true;
                            entrada=true;
                        }
                        break;
            
            
            
            
                 }
            
        
        
            }       
        }
        
        System.out.println("Hasta luego");
        
        
    }
    
}
