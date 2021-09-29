public class Jefe extends Enemigo{
    
    public Jefe(){
        super();
    }

    public Jefe(int a){
        nombre = "Jefesito " + a;
        vida = 200;
        atq = 40;
        esjefe = true;
    }
}
