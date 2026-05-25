package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[]argss) {
        System.out.println("----Mundial----");
        String se1 = IngresarTexto("Ingrese la selección: ");  // 2. Variable declarada correctamente
        System.out.println("Selección ingresada: " + se1);
    }
    public static String IngresarTexto(String mensaje){
        Scanner sc=new Scanner(System.in);
        return sc.nextLine();
    }
}
