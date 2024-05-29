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
                        generateTemperatureMatrix();
                        menuTemperatures();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                    default:
                        System.out.println("Ingrese una opcion valide. Intentelo de nuevo.");
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

    public static void menuTemperatures() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Se ha creado la matriz para predecir las temperaturas: ");
        while (true) {
            System.out.println("Menu de temperaturas");
            System.out.println("1. Mostrar temperaturas de cada semana");
            System.out.println("2. Mostrar promedio de temperatura de cada semana");
            System.out.println("3. Mostrar temperatura mas alta del mes");
            System.out.println("4. Salir al menu principal");

            if (scanner.hasNextInt()) {
                int options = scanner.nextInt();

                switch (options) {
                    case 1:
                        showTemperaturesOfWeek();
                        break;
                    case 2:
                        showAverageTemperatureOfWeek();
                        break;
                    case 3:
                        showHighestTemperatureOfMonth();
                        break;
                    case 4:
                        return;
                }
            }
        }
    }

    public static int[][] generateTemperatureMatrix() {
        Random random = new Random();
        int[][] temperatureArray = new int[4][7];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                temperatureArray[i][j] = random.nextInt(32) + 7;

            }
        }
        return temperatureArray;
    }

    public static int[] findExtremeWeek(int[][] temperatureArray, int week) {
        int min = temperatureArray[week][0];
        int max = temperatureArray[week][0];
        int maxDay = 0;
        int minDay = 0;

        for (int day = 1; day < 7; day++) {
            if (temperatureArray[week][day] < min) {
                min = temperatureArray[week][day];
                minDay = day;
            }
            if (temperatureArray[week][day] > max) {
                max = temperatureArray[week][day];
                maxDay = day;
            }
        }
        return new int[]{min, minDay, max, maxDay};
    }

    public static double calculateAverageWeek(int[][] temperatureArray, int week) {
        double sum = 0;
        for (int day = 0; day < 7; day++) {
            sum += temperatureArray[week][day];
        }
        return sum / 7;
    }

    public static int[] findHighestTemperatureMonth(int[][] temperatureArray) {
        int max = temperatureArray[0][0];
        int maxWeek = 0;
        int maxDay = 0;
        for (int week = 0; week < 4; week++) {
            for (int day = 0; day < 7; day++) {
                if (temperatureArray[week][day] > max) {
                    max = temperatureArray[week][day];
                    maxWeek = week;
                    maxDay = day;
                }
            }
        }
        return new int[]{max, maxWeek, maxDay};
    }

    public static void showTemperaturesOfWeek() {
        int[][] temperatureArray = generateTemperatureMatrix();
        boolean[][] extremesOfWeek = new boolean[4][7];

        for (int week = 0; week < 4; week++) {
            int[] extremes = findExtremeWeek(temperatureArray, week);
            int min = extremes[0];
            int minDay = extremes[1];
            int max = extremes[2];
            int maxDay = extremes[3];

            System.out.println("Semana " + (week + 1) + ":");
            System.out.println("Temperatura mas baja: " + min + " (Dia " + (minDay + 1) + ")");
            System.out.println("Temperatura mas alta: " + max + " (Dia " + (maxDay + 1) + ")");

            extremesOfWeek[week][minDay] = true;
            extremesOfWeek[week][maxDay + 7] = true;
        }

        printMatrix(temperatureArray, extremesOfWeek);
    }

    public static void showAverageTemperatureOfWeek() {
        int[][] temperatureArray = generateTemperatureMatrix();

        for (int week = 0; week < 4; week++) {
            double average = calculateAverageWeek(temperatureArray, week);
            System.out.println("Semana " + (week + 1) + ": Promedio de temperatura: " + average);
        }
    }

    public static void showHighestTemperatureOfMonth() {
        int[][] temperatureArray = generateTemperatureMatrix();
        int[] highestTemperatureMonth = findHighestTemperatureMonth(temperatureArray);

        System.out.println("La temperatura mas alta del mes es: " + highestTemperatureMonth[0]
                + " (semana " + (highestTemperatureMonth[1] + 1) + ", Dia " + (highestTemperatureMonth[2] + 1) + ")");
    }

    public static void printMatrix(int[][] temperatureArray, boolean[][] extremes) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (extremes[i][j]) {
                    System.out.print("\033[31m" + temperatureArray[i][j] + " ");
                } else if (extremes[i][j + 7]) {
                    System.out.print("\033[34m" + temperatureArray[i][j] + " ");
                } else {
                    System.out.print(temperatureArray[i][j] + " ");
                }
            }
            System.out.println("\033[0m");
        }
    }
}
