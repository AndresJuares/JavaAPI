
package proyectojava;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;


public class Card {
    private String marca;
    private String nrotarjeta;
    private String cardHolderName;
    private String cardHolderSurnname;
    private Date fvenc;
    private SimpleDateFormat f1=new SimpleDateFormat("MM/yy");
    private int Month,Year;
    private double tasa,importe;
    //CONSTRUCTOR VACIO
    public Card(){
        
    }
    //CONSTRUCTOR CON PARAMETROS
    public Card(String m,String nro,String card,String surname,Date fecha){
        this.marca=m.toUpperCase();
        this.nrotarjeta=nro;
        this.cardHolderName=card;
        this.cardHolderSurnname=surname;
        this.fvenc=fecha;
    }
    
    //METODOS GET
    public String GetMarca(){
        return this.marca.toUpperCase();
    }
    
    public String Getnrotarjeta(){
        return this.nrotarjeta;
    }
    public String GetCardHolderName(){
        return this.cardHolderName;
    }
    public String GetCardHolderSurnname(){
        return this.cardHolderSurnname;
    }
    public Date GetFVenc(){
        return this.fvenc;
    }
    public int GetMonth(Card c){
        return c.Month;
    }
    public int GetYear(Card d){
        return d.Year;
    }
    public double GetImporte(Card d){
        return d.importe;
    }
    
    //METODOS SET
    public void SetMarca(String m){
        try{
            this.marca=m;
            marca.toUpperCase();
        }
        catch(Exception e){
            System.out.println("Ingreso no valido, ingrese VISA,NARA o AMERICAN");
        }
        
    }
    
    public void Setnrotarjeta(String n){
        
        try{
            this.nrotarjeta=n;
        }
        catch(Exception e){
            System.out.println("Ingreso no valido, ingrese solo numeros");
        }
    }
    public void SetCardHolderName(String card){
        try{
            this.cardHolderName=card;
        }
        catch(Exception e){
            System.out.println("Ingreso no valido, ingrese nombre");
        }
        
    }
    public void SetCardHolderSurnname(String s){
        try{
           this.cardHolderSurnname=s;
        }
        catch(Exception e){
            System.out.println("Ingreso no valido, ingrese apellido");
        }
        
        
    }
    public void SetFVenc(Card f) throws ParseException{
        String g=f.Month+"/"+f.Year;
        this.fvenc=f1.parse(g);
    }
    public void SetMonth(int a){
       try{
            if(a==00){
                System.out.println("Ingreso no valido, que sea distinto a 00");
            }
            this.Month=a;    
       }
        catch(Exception e){
            System.out.println("Ingreso no valido, ingrese 2 digitos ");
        }
        
        
    }
    public void SetYear(int b){
        try{
            this.Year=b;
        }
        catch(Exception e){
            System.out.println("Ingreso no valido, ingrese 2 digitos");
        }
        
    }
    
    public void SetImporte(double f){
        try{
            this.importe=f;
        }
        catch(Exception e){
            System.out.println("Ingreso no valido, ingrese importe");
        }
        
        
    }
    
    public List<String> info(Card c){
        List<String> datos=new ArrayList<String>();
        datos.add(c.GetMarca());
        datos.add(c.GetCardHolderName());
        datos.add(c.GetCardHolderSurnname());
        datos.add(c.Getnrotarjeta());
        datos.add(c.GetFVenc().toString());
        
        return datos;
    }
    
    public double TasaCard(Card c){
        if(c.GetMarca()=="nara"||c.GetMarca()=="NARA"){
           try{
            tasa=c.Month/c.Year;
            return tasa;
           }
        catch(Exception e){
            System.out.println("Ingreso no valido, el mes es 00");
        }
            
        }
        if(c.GetMarca()=="visa"||c.GetMarca()=="VISA"){
            DateTimeFormatter fecha= DateTimeFormatter.ofPattern("dd");
            int a=Integer.parseInt(fecha.format(LocalDateTime.now()));            
            tasa=a*0.5;
            return tasa;
        }
        if(c.GetMarca()=="american"||c.GetMarca()=="AMERICAN"){
            tasa=c.Month/0*1;
            return tasa;
        }
        
        else
            return 0;
    }
    
    public String Distint(Card a,Card b){
        if(a.GetCardHolderName()==b.GetCardHolderName()){
            if(a.GetMarca()!=b.GetMarca()){
                return "Las tarjetas son de diferente empresa, pero poseen el mismo propietario";
            }
        }
        if(a.GetCardHolderName()==b.GetCardHolderName()){
            if(a.GetMarca()==b.GetMarca()){
                if(a.GetMonth(a)==b.GetMonth(b)){
                    if(a.GetYear(a)==b.GetYear(b)){
                        return "Tarjeta Clonada";
                    }
                }
                
            }
        }
        return "Las tarjetas son de diferente propietario";
    }
    public String TasaOperacion(Card e){
        List<String> t=new ArrayList<String>();
        t.add(e.GetMarca());
        String a=String.valueOf(e.TasaCard(e));
        t.add(a);
        a=String.valueOf(e.GetImporte(e));
        t.add(a);
        System.out.println("Su tasa de operacion es: ");
        for(int i=t.size()-1;i>=0;i--){
            System.out.println(t.get(i));
        }
        return "";
    }
    
}
