import org.iesch.ad.modelo.Empleado;

import java.io.*;
import java.util.Stack;

public class FicheroBinario {

    public static void testEscribirFicheroBinario(){
        ObjectOutputStream f = null;
        File fichero = null;

        Empleado e1 = new Empleado("Juan", "Antono", 23,600);
        Empleado e2 = new Empleado("Jose", "Toro", 25,800);

        Stack<Empleado> pila = new Stack<>();
        pila.add(e1);
        pila.add(e2);

        try{
            fichero = new File ("empleados");
            f = new ObjectOutputStream(new FileOutputStream(fichero));
            System.out.println("Escribiendo objetos en binario en : " + fichero.getAbsolutePath());
            f.writeObject(e1);
            f.writeObject(e2);
            f.writeObject(pila);
            System.out.println("Todo escrito");



        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (f != null){
                try {
                    f.close();
        }catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
                }
                System.out.println("Fichero Cerrado");
            }
        }
    }



    public static void testLeerFicheroBinario() {
        ObjectInputStream f = null;
        File fichero = null;
        try {
            fichero = new File ("empleados");
            f = new ObjectInputStream(new FileInputStream(fichero));
            Empleado e1 = (Empleado) f.readObject();
            Empleado e2 = (Empleado) f.readObject();
            Stack<Empleado> pila = (Stack<Empleado>) f.readObject();
            System.out.println(pila.pop().toString());
            System.out.println(pila.pop().toString());
            System.out.println(pila.empty());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
