import java.util.ArrayList;
public class Jugador extends Combatientes {
    String clase;
    ArrayList<String>items = new ArrayList<String>();
    public Jugador(String n, String c){
        nombre = n;
        
        clase = c;
        if(clase.equals("Guerrero")){
            vida = 200;
            atq = 20;
            items.add("Pocion de vida");
            items.add("Pocion de ataque");
        }
        else{
            vida = 150;
            atq = 15;
            items.add("Pocion de vida");
            items.add("Pocion de vida");
            items.add("Pocion de ataque");
            items.add("Pocion de ataque");
        }
    }
//@params la vida que se va a quitar por el golpe del enemigo
    public void setVida(int a){
        vida -= a;
    }

//@returns array con los items del jugador
    public String[] verItems(){
        String[] a = new String[items.size()];
        for(int i = 0; i < items.size(); i++){
            a[i] = items.get(i);
        }
        return a;
    }

    //@params item a utilizar
    public void consumirItem(String s){
        if(s.equals("Pocion de vida")){
            vida+= 50;
        }else atq += 12;
    }
}
