package edu.neu.mgen;



import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String[][] strategies = new String[6][4];
        Scanner scanner = new Scanner(System.in);

        //Initial STartegy setup
        for (int i=0; i<strategies.length;i++) {
            strategies[i][0]="Startegy " + (i+1);
        }
        // Input STrategies
        for (int i = 0; i < strategies.length; i++) {
            System.out.println("Enter details for Strategy " + (i + 1) + ":");
            System.out.print("Priority (high/medium/low): ");
            strategies[i][1] = scanner.next();
            System.out.print("Difficulty (high/medium/low): ");
            strategies[i][2] = scanner.next();
            System.out.print("Dependency (high/medium/low): ");
            strategies[i][3] = scanner.next();
        }

        // Sort strategies using bubble sort
        bubbleSortStrategies(strategies);

        // Print sorted strategies
        System.out.println("\nSorted Strategies:");
        for (int i = 0; i < strategies.length; i++) {
            for (int j = 0; j < strategies[i].length; j++) {
                System.out.print(strategies[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void bubbleSortStrategies(String[][] strategies) {
        for (int i = 0; i < strategies.length - 1; i++) {
            for (int j = 1; j < strategies.length - i - 1; j++) {
                if (compareStrategies(strategies[j], strategies[j + 1]) > 0) {
                    // Swap strategies
                    String[] temp = strategies[j];
                    strategies[j] = strategies[j + 1];
                    strategies[j + 1] = temp;
                }
            }
        }
    }

    public static int compareStrategies(String[] strategy1, String[] strategy2) {
        // COmpare based on Pririty
        if (!strategy1[1].equals(strategy2[1])) {
            return priorityValue(strategy2[1]) - priorityValue(strategy1[1]);
        }
        // If priority is same- COmpare based on difficulty
        else if (!strategy1[2].equals(strategy2[2])) {
            return difficultyValue(strategy2[2]) - difficultyValue(strategy1[2]);
        }
        // If prity and difficlty are same- compare based on dependency
        else {
            return dependencyValue(strategy2[3]) - dependencyValue(strategy1[3]);
        }
    }

    public static int priorityValue(String priority) {
        return switch (priority) {
            case "high" -> 3;
            case "medium" -> 2;
            case "low" -> 1;
            default -> 0;
        };
    }

    public static int difficultyValue(String difficulty) {
        return switch (difficulty) {
            case "high" -> 1;
            case "medium" -> 2;
            case "low" -> 3;
            default -> 0;
        };
    }

    public static int dependencyValue(String dependency) {
        return switch (dependency) {
            case "high" -> 1;
            case "medium" -> 2;
            case "low" -> 3;
            default -> 0;
        };
    }
}
