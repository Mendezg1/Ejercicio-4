import java.util.ArrayList;
import java.util.Random;
//Hubo un descuido en el apartado de esta clase en el diseño, en la cual no se incluyeron los getters de la misma aunque
//sí fueron pensados desde el inicio. Además se eliminó la función "nuevosEnemigos" por ser innecesaria.
public class Personajes {
    private ArrayList<Enemigo>enemigos = new ArrayList<Enemigo>();
    private Jugador usuario;
    private int combatientes = 1;
    public Personajes(String nombre, String clase){
        Random rnd = new Random();
        usuario = new Jugador(nombre, clase);
        int nenemigos = (int)(rnd.nextInt(3)) + 1;
        int c = 1;
        for(int i = 0; i < nenemigos; i++){
            int njefe = (int)(rnd.nextFloat() * 100);
            if(njefe <= 15){
                enemigos.add(new Jefe(c));
                c++;
            }
            else{
                enemigos.add(new Enemigo(i+1));
            }
        }
        combatientes += enemigos.size();
    }

    //Esta función se añadió para poder eliminar los enemigos cuando su vida llegue a 0
    //@params posición del enemigo en el arraylist
    public void enemigoEliminado(int a){
        enemigos.remove(enemigos.get(a));
        combatientes--;
    }

    //@params posición del enemigo en el arraylist
    //@returns enemigo requerido
    public Enemigo getEnemigo(int a){
        return enemigos.get(a);
    }

    //@params jugador, enemigo y modalidad de ataque (Si ataca el jugador al enemigo o vice versa)
    //@returns la vida final del combatiente atacado
    public int Atacar(Jugador j, int e, int a){
        if(a == 1){
            enemigos.get(e).setVida(j.getAtq());
            return enemigos.get(e).getVida();
        }
        else{
            j.setVida(enemigos.get(e).getAtq());
            return j.getVida();
        }
    }

    public Jugador getUsuario(){
        return usuario;
    }

    public int getCombatientes(){
        return combatientes;
    }

    public String[] getEnemigos(){
        String[] a = new String[enemigos.size()];
        for(int i = 0; i < enemigos.size(); i++){
            a[i] = enemigos.get(i).getNombre();
        }
        return a;
    }
}
