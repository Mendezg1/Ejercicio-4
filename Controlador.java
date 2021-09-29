import java.util.Queue;
import java.util.LinkedList;
public class Controlador{
    static public void main(String args[]){
        //Se añadió esta variable para poder marcar un fin en la ejecución del juego.
        boolean bandera = true;
        while(bandera){
            int opcion = 0;
            Queue<String>acciones = new LinkedList<String>();
            Vista v = new Vista();
            Personajes p;
            String nombre = v.askString("Ingrese su nombre:");
            String clase = v.askString("¿A qué clase desea pertenecer? (Guerrero/Explorador):");
            if(clase.equals("Guerrero") || clase.equals("Explorador")){
                p = new Personajes(nombre, clase);
                //Estas dos variables fueron añadidas para poder implementar el sistema de turnos.
                int n = p.getCombatientes();
                int c = 0;
                while(c < (n+1)){
                    if(c == 0){
                        opcion = v.askInts("Es turno de " + p.getUsuario().getNombre()+". \n" +
                        "¿Qué desea hacer?:\n" + 
                        "1. Atacar a un enemigo \n"+
                        "2. Usar un item \n" +
                        "3. Huir");
                        if(opcion == 1){
                            String[] a = p.getEnemigos();
                            String s = "\nElije qué enemigo atacar: \n";
                            for(int i = 0; i < a.length; i++){
                                s += (i+1)+" " + a[i] + "\n";
                            }
                            int opcion1 = v.askInts(s) - 1;
                            if(p.Atacar(p.getUsuario(), opcion-1, 1) <= 0){
                                p.enemigoEliminado(opcion1);
                            }
                            acciones.add(p.getUsuario().getNombre()+ " ataca a Enemigo "+(opcion1 + 1)+".\n" );
                            if(acciones.size() > 3){
                                acciones.poll();
                            }
                        }
                        else if(opcion == 2){
                            String[] a = p.getUsuario().verItems();
                            String s = "¿Qué item desea usar? \n";
                            for(int i = 0; i < a.length; i++){
                                s += (i+1)+" " + a[i] + "\n";
                            }
                            int opcion1 = v.askInts(s) -1;
                            p.getUsuario().consumirItem(a[opcion1]);
                            acciones.add(p.getUsuario().getNombre() + " utilizó " + a[opcion1] + ".");
                            if(acciones.size() > 3){
                                acciones.poll();
                            }
                        }
                        else if(opcion == 3){
                            bandera = false;
                            c = 10;
                        }
                        else{
                            v.Mensaje("Opción desconocida. Por favor ingresar el número de las opciones mostradas en pantalla.");
                            c--;
                        }
                        c++;
                    }
                    else if(c == 1){
                        String[] nombres = p.getEnemigos();
                        opcion = v.askInts("Es turno de " + nombres[0]+". \n" +
                        "¿Qué desea hacer?:\n" + 
                        "1. Atacar \n"+
                        "2. Usar Habilidad \n");
                        if(opcion == 1){
                            if(p.Atacar(p.getUsuario(), 0, 2) <= 0){
                                p.getUsuario().Mensaje(2);
                                bandera = false;
                                c = 10;
                            }
                            acciones.add(p.getEnemigo(0).getNombre() + " atacó a " + p.getUsuario().getNombre());
                            if(acciones.size() > 3){
                                acciones.poll();
                            }
                        }
                        else if(opcion == 2){
                            p.getEnemigo(0).Curarse();
                            acciones.add(p.getEnemigo(0).getNombre() + " utilizó 'Curarse'");
                        }
                        
                        c++;
                    }
                    else if(c == 2){
                        String[] nombres = p.getEnemigos();
                        opcion = v.askInts("Es turno de " + nombres[1]+". \n" +
                        "¿Qué desea hacer?:\n" + 
                        "1. Atacar \n"+
                        "2. Usar Habilidad \n");
                        if(opcion == 1){
                            if(p.Atacar(p.getUsuario(), 1, 2) <= 0){
                                p.getUsuario().Mensaje(2);
                                bandera = false;
                                c = 10;
                            }
                            acciones.add(p.getEnemigo(1).getNombre() + " atacó a " + p.getUsuario().getNombre());
                            if(acciones.size() > 3){
                                acciones.poll();
                            }
                        }
                        else if(opcion == 2){
                            p.getEnemigo(1).Buff();;
                            acciones.add(p.getEnemigo(1).getNombre() + " utilizó 'Buff'");
                        }
                        else{
                            v.Mensaje("Opción desconocida. Por favor ingresar el número de las opciones mostradas en pantalla.");
                            c--;
                        }
                        c++;
                    }
                    else if(c == 3){
                        String[] nombres = p.getEnemigos();
                        opcion = v.askInts("Es turno de " + nombres[2]+". \n" +
                        "¿Qué desea hacer?:\n" + 
                        "1. Atacar \n"+
                        "2. Usar Habilidad \n");
                        if(opcion == 1){
                            if(p.Atacar(p.getUsuario(), 2, 2) <= 0){
                                p.getUsuario().Mensaje(2);
                                bandera = false;
                                c = 10;
                            }
                            acciones.add(p.getEnemigo(2).getNombre() + " atacó a " + p.getUsuario().getNombre());
                            if(acciones.size() > 3){
                                acciones.poll();
                            }
                        }
                        else if(opcion == 2){
                            p.getEnemigo(2).Curarse();
                            acciones.add(p.getEnemigo(2).getNombre() + "utilizó 'Curarse'");
                        }
                        else{
                            v.Mensaje("Opción desconocida. Por favor ingresar el número de las opciones mostradas en pantalla.");
                            c--;
                        }
                        c++;
                    }
                    if(p.getEnemigos().length == 0){
                        p.getUsuario().Mensaje(1);
                        c=10;
                        bandera = false;
                    }

                    if(p.getUsuario().getVida() <= 0){
                        p.getUsuario().Mensaje(2);
                    }
                    if(c == n){
                        c = 0;
                    }
                    String s = "Los stats de final de ronda son: \n\n" +
                    p.getUsuario().getNombre()+ " con " + p.getUsuario().getVida()+ " de vida y " + p.getUsuario().getAtq() +" de ataque. \n";
                    for(int i = 0; i < p.getEnemigos().length; i++){
                        s+= p.getEnemigo(i).getNombre() + " con " + p.getEnemigo(i).getVida() + " de vida y " + p.getEnemigo(i).getAtq()+ " de ataque \n";
                    }
                    v.Mensaje(s);

                    for(int i = 0; i < acciones.size(); i++){
                        String a = acciones.poll();
                        v.Mensaje(a);
                        acciones.add(a);
                    }
                }
            }else v.Mensaje("Clase desconocida, por favor ingresar una existente.");
        }    
    }
}