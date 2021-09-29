public class Enemigo extends Combatientes {
    //Esta variable fue añadida para poder distinguir a un jefe en el momento de otorgar el turno al usuario.
    boolean esjefe = false;
    public Enemigo(){
    }
    //@params el número del enemigo generado   
    public Enemigo(int a){
        nombre = "Enemigo "+a;
        vida = 100;
        atq = 15;
    }

//Se cambiaron los nombres de Habilidad1 y Habilidad2 a Curarse y Buff
    public void Curarse(){
        vida += 25;
    }

//Esta función se añadió para facilitar la función de Personajes "Atacar".
//@params la vida que se va a quitar por el ataque del enemigo
    public void setVida(int a){
        vida -= a;
    }

    public void Buff(){
        atq += 20;
    }

    
}
