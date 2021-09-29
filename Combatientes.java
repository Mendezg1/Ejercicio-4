public class Combatientes {
    protected String nombre;
    protected int vida;
    protected int atq;

    //@returns nombre del combatiente
    public String getNombre(){
        return nombre;
    }

    //@returns ataque del combatiente
    public int getAtq(){
        return atq;
    }

    //@returns vida del combatiente
    public int getVida(){
        return vida;
    }
//Se añadió el parámetro "a" (no presente en el diseño) para poder tener mensajes estáticos.
//@params número del mensaje estático
//@returns string con el mensaje
    public String Mensaje(int a){
        if(a == 1){
            return "¡Ufff! Estuvo cerca, pero ganamos.";
        }
        else if(a == 2){
            return "No puede ser...... per....dí...";
        }
        else return "";
    }
}
