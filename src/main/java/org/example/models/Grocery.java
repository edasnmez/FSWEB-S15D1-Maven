package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery(); // Uygulama başlatılıyor
    }

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Market Listesi Uygulamasına Hoş Geldiniz!");

        while (running) {
            System.out.println("\nSeçim yapınız:");
            System.out.println("0 - Çıkış yap");
            System.out.println("1 - Eleman ekle");
            System.out.println("2 - Eleman çıkar");

            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    running = false;
                    System.out.println("Uygulama kapatıldı.");
                    break;

                case "1":
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd); // ✅ eski for döngüsünü kaldır, bunu kullan
                    break;

                case "2":
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove); // ✅ eski for döngüsünü kaldır, bunu kullan
                    break;

                default:
                    System.out.println("Geçersiz seçim, lütfen 0, 1 veya 2 giriniz.");
            }

        }

        scanner.close();
    }
    public static void addItems(String input) {
        List<String> items = parseInput(input);
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        List<String> items = parseInput(input);
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim());
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("\nGüncel ve sıralı liste: " + groceryList);
    }


    // Virgülle ayırarak girilen veriyi parçalayan yardımcı metod
    private static List<String> parseInput(String input) {
        if (input.contains(",")) {
            return Arrays.asList(input.split(","));
        } else {
            return List.of(input.trim());
        }
    }

}

