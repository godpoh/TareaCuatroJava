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
                        mainMethodTemperature();
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

    public static void menuTemperatures(int[][] temperatureArray) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ver Resultados");
            System.out.println("1. Mostrar temperaturas de cada semana");
            System.out.println("2. Mostrar promedio de temperatura de cada semana");
            System.out.println("3. Mostrar temperatura mas alta del mes");
            System.out.println("4. Salir al menu principal");

            if (scanner.hasNextInt()) {
                int options = scanner.nextInt();

                switch (options) {
                    case 1:
                        showTemperaturesOfWeek(temperatureArray);
                        break;
                    case 2:
                        showAverageTemperatureOfWeek(temperatureArray);
                        break;
                    case 3:
                        showHighestTemperatureOfMonth(temperatureArray);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Error: Ingrese una opcion valida. Intente de nuevo...");
                }
            } else {
                scanner.next();
                System.out.println("Error: No se permite el ingresar letras. Intentelo de nuevo solo con numeros");
            }
        }
    }

    public static void mainMethodTemperature() {
    int[][] vGenerateArray = generateArray();

    for (int i = 0; i < vGenerateArray.length; i++) {
        int lowestTemperature = Integer.MAX_VALUE;
        int highestTemperature = Integer.MIN_VALUE;
        int lowestColumn = -1;
        int highestColumn = -1;

        for (int j = 0; j < vGenerateArray[i].length; j++) {
            int temperature = vGenerateArray[i][j];
            if (temperature < lowestTemperature) {
                lowestTemperature = temperature;
                lowestColumn = j;
            }
            if (temperature > highestTemperature) {
                highestTemperature = temperature;
                highestColumn = j;
            }
        }

        for (int j = 0; j < vGenerateArray[i].length; j++) {
            if (j == lowestColumn) {
                printColorTemperature(vGenerateArray[i][j], "blue");
            } else if (j == highestColumn) {
                printColorTemperature(vGenerateArray[i][j], "red");
            } else {
                System.out.print(vGenerateArray[i][j] + " ");
            }
        }
        System.out.println();
    }

    menuTemperatures(vGenerateArray); 
}


    public static int[][] generateArray() {
        System.out.println("Se ha creado la matriz para predecir las temperaturas: ");
        Random random = new Random();
        int[][] Arrayy = new int[4][7];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                Arrayy[i][j] = random.nextInt(32) + 7;
            }
        }
        return Arrayy;
    }

    public static void printColorTemperature(int temperature, String color) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";

        if (color.equals("blue")) {
            System.out.print(ANSI_BLUE + temperature + " " + ANSI_RESET);
        } else if (color.equals("red")) {
            System.out.print(ANSI_RED + temperature + " " + ANSI_RESET);
        }
    }

public static void showTemperaturesOfWeek(int[][] temperatureArray) {
    String[] daysOfWeek = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    for (int week = 0; week < temperatureArray.length; week++) {
        int minTemperature = Integer.MAX_VALUE;
        int maxTemperature = Integer.MIN_VALUE;
        int minDay = -1;
        int maxDay = -1;

        for (int day = 0; day < temperatureArray[week].length; day++) {
            int temperature = temperatureArray[week][day];
            if (temperature < minTemperature) {
                minTemperature = temperature;
                minDay = day;
            }
            if (temperature > maxTemperature) {
                maxTemperature = temperature;
                maxDay = day;
            }
        }

        System.out.println("Semana " + (week + 1) + ":");
        System.out.println("Temperatura mas baja: " + minTemperature + " (Dia: " + daysOfWeek[minDay] + ")");
        System.out.println("Temperatura mas alta: " + maxTemperature + " (Dia: " + daysOfWeek[maxDay] + ")");
    }
}

    public static void showAverageTemperatureOfWeek(int[][] temperatureArray) {
        for (int week = 0; week < temperatureArray.length; week++) {
            int sum = 0;
            for (int day = 0; day < temperatureArray[week].length; day++) {
                sum += temperatureArray[week][day];
            }
            double average = (double) sum / temperatureArray[week].length;
            System.out.println("Semana " + (week + 1) + ": Promedio de temperatura: " + average);
        }
    }

    public static void showHighestTemperatureOfMonth(int[][] temperatureArray) {
        int maxTemperature = Integer.MIN_VALUE;
        ArrayList<Integer> maxWeeks = new ArrayList<>();
        ArrayList<Integer> maxDays = new ArrayList<>();

        for (int week = 0; week < temperatureArray.length; week++) {
            for (int day = 0; day < temperatureArray[week].length; day++) {
                int temperature = temperatureArray[week][day];
                if (temperature > maxTemperature) {
                    maxTemperature = temperature;
                    maxWeeks.clear();
                    maxDays.clear();
                    maxWeeks.add(week + 1);
                    maxDays.add(day + 1);
                } else if (temperature == maxTemperature) {
                    maxWeeks.add(week + 1);
                    maxDays.add(day + 1);
                }
            }
        }

        System.out.print("La temperatura mas alta del mes es: " + maxTemperature);
        System.out.print(" (Se produjo en la(s) semana(s): ");
        for (int i = 0; i < maxWeeks.size(); i++) {
            System.out.print(maxWeeks.get(i));
            if (i < maxWeeks.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" el(los) dia(s): ");
        for (int i = 0; i < maxDays.size(); i++) {
            System.out.print(maxDays.get(i));
            if (i < maxDays.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

}
