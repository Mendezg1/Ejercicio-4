import java.util.Scanner;
public class Vista {
    private Scanner scan;
    public Vista(){
        scan = new Scanner(System.in);
    }

    //De esta clase se eliminó la función "Menú" por ser innecesaria.

    //@params String con el mensaje que pide datos al usuario
    //@returns int respuesta del usuario
    public int askInts(String s){
        try{
            System.out.println(s);
            return Integer.parseInt(scan.nextLine());
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            return -1;
        }
    }

    //@params String con el mensaje que pide datos al usuario
    //@returns string respuesta del usuario
    public String askString(String s){
        System.out.println(s);
        return scan.nextLine();
    }

    //@params String con el mensaje para el usuario
    public void Mensaje(String s){
        System.out.println(s);
    }

    
}
