/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.boscdelacoma.casinoreptefinal;

/**
 *
 * @author TimOliver
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona la base de dades:");
        System.out.println("1. MySQL");
        System.out.println("2. ObjectDB");
        int eleccio = scanner.nextInt();

        if (eleccio == 1) {
            MySQLDatabase db = new MySQLDatabase();
            // Treballar amb MySQL
        } else if (eleccio == 2) {
            ObjectDBDatabase db = new ObjectDBDatabase();
            // Treballar amb ObjectDB
        } else {
            System.out.println("Elecció no vàlida");
        }
    }
}