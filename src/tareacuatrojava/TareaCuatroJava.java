/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareacuatrojava;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class TareaCuatroJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Numeros par e impar con listas");
            System.out.println("2. Numeros par e impar con diccionarios");
            System.out.println("3. Generar matriz de temperaturas");
            System.out.println("4. Salir");

            if (scanner.hasNextInt()) {
                int options = scanner.nextInt();

                switch (options) {
                    case 1:
                        pairNOddLists();
                        break;
                    case 2:
                        pairNOddDictionaries();
                        break;
                    case 3:
                        generateArrayOfTemperatures();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                    default:
                        System.out.println("Digite una opcion valida. Intentelo de nuevo");
                }
            } else {
                scanner.next();
                System.out.println("Error: No se permite el ingresar letras. Intentelo de nuevo solo con numeros");
            }
        }

    }

    public static void pairNOddLists() {
        ArrayList<Integer> numbersList = new ArrayList<>();
        ArrayList<Character> numberCharacterList = new ArrayList<>();
        insertRandomNumbers(numbersList, numberCharacterList, 25);
        showConvertedValuesList(numbersList, numberCharacterList);
    }

    public static void insertRandomNumbers(ArrayList<Integer> pNumberList, ArrayList<Character> pNumberCharacterList, int pAmount) {
        Random random = new Random();
        for (int i = 0; i < pAmount; i++) {
            int numberRandom = random.nextInt(500);
            pNumberList.add(numberRandom);
            if (numberRandom % 2 == 0) {
                pNumberCharacterList.add('$');
            } else {
                pNumberCharacterList.add('#');
            }
        }
    }

    public static void showConvertedValuesList(ArrayList<Integer> pNumberList, ArrayList<Character> pNumberCharacterList) {
        for (int i = 0; i < pNumberList.size(); i++) {
            char valueTwo = pNumberCharacterList.get(i);
            int valueOne = pNumberList.get(i);

            System.out.println(valueOne + " = " + valueTwo);
        }
    }

    public static void pairNOddDictionaries() {
        HashMap<Integer, Integer> dictionarieForNumbers = new HashMap();
        HashMap<Integer, Character> dictionarieForChars = new HashMap();

        insertRandomNumbersInDictionarie(dictionarieForNumbers, dictionarieForChars, 25);
        showConvertedValuesDictionarie(dictionarieForNumbers, dictionarieForChars);

    }

    public static void insertRandomNumbersInDictionarie(HashMap pDictionarieForNumbers, HashMap pDictionarieForChars, int pAmount) {
        Random random = new Random();

        for (int i = 0; i < pAmount; i++) {
            int randomNumbersDictionarie = random.nextInt(500);
            pDictionarieForNumbers.put(i, randomNumbersDictionarie);

            if (randomNumbersDictionarie % 2 == 0) {
                pDictionarieForChars.put(i, '$');
            } else {
                pDictionarieForChars.put(i, '#');
            }
        }
    }

    public static void showConvertedValuesDictionarie(HashMap<Integer, Integer> pDictionarieForNumbers, HashMap<Integer, Character> pDictionarieForChars) {
        for (int key : pDictionarieForNumbers.keySet()) {
            int valueOne = pDictionarieForNumbers.get(key);
            char valueTwo = pDictionarieForChars.get(key);

            System.out.println("{" + key + "=" + valueOne + "} {" + key + "=" + valueTwo + "}");
        }
    }

    public static void generateArrayOfTemperatures() {

    }

}
