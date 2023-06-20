
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author NguyenDuy
 */
public class Products extends HashMap<String, Product> {

    HashMap<String, Product> hm = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Input ip = new Input();

    public Products() {
    }

    public void addProduct() {
        boolean choice = true;
        while (choice) {
            String code = ip.inputCode(hm);
            System.out.println("Enter product name: ");
            String name = sc.nextLine();
            System.out.println("Enter product supplier: ");
            String supplier = sc.nextLine().toUpperCase();
            System.out.println("Enter unit: ");
            String unit = sc.nextLine();
            double price = ip.inputPrice();
            float quantity = ip.inputQuantity();
            boolean hasPromottion = ip.inputHasPromotion();
            Product pr = new Product(code, name, supplier, unit, price, quantity, hasPromottion);
            hm.put(code, pr);
            choice = ip.inputYN("Continue?(Y/N)");
        }
    }

    public List<Product> toList() {
        return new ArrayList(hm.values());
    }

    public void showProduct() {
        System.out.printf("|%7s|%7s|%10s|%7s|%8s|%5s|%9s|\n", "CODE", "NAME", "SUPPLIER", "UNIT", "VALUE", "VAT", "PROMOTION");
        authentic();
        for (Product product : toList()) {
            product.printProduct();
        }
        authentic();
    }

    public void deleteProduct() {
        System.out.println("Enter code product you want to remove: ");
        String code = sc.nextLine();
        if (hm.containsKey(code)) {
            System.out.println("Remove successfully!");
            hm.remove(code);
        } else {
            System.out.println("Can't find product!");
        }
    }

    public void filterProduct() {
        System.out.println("Enter supplier you want to filter: ");
        String supplier = sc.nextLine();
        for (Product product : toList()) {
            if (product.getSupplier().equalsIgnoreCase(supplier)) {
                authentic();
                product.printProduct();
            }
        }
    }

    public void sortByValue() {
        List<Product> pr = new ArrayList<>(hm.values());
        Collections.sort(pr, Product.compareValue);
        System.out.printf("|%7s|%7s|%10s|%7s|%8s|%5s|%9s|\n", "CODE", "NAME", "SUPPLIER", "UNIT", "VALUE", "VAT", "PROMOTION");
        authentic();
        for (Product product : pr) {
            product.printProduct();
        }
        authentic();
    }

    public void authentic() {
        for (int i = 0; i < 61; i++) {
            System.out.printf("-");
        }
        System.out.println("");
    }

    public void sortProduct() {
        int choice;
        System.out.println("5.1 – Sort by name (ASC)\n"
                + "5.2- Sort by value (DES)");
        choice = ip.inputInt();
        if (choice == 1) {
            System.out.println("Sort by name");
            List<Product> pr = new ArrayList<>(hm.values());
            Collections.sort(pr);
            System.out.printf("|%7s|%7s|%10s|%7s|%8s|%5s|%9s|\n", "CODE", "NAME", "SUPPLIER", "UNIT", "VALUE", "VAT", "PROMOTION");
            authentic();
            for (Product product : pr) {
                product.printProduct();
            }
            authentic();
        } else if (choice == 2) {
            System.out.println("Sort by value");
            sortByValue();
        } else {
            System.out.println("You don't choice");
        }
    }

    public void countProductsBySupplier() {
        List<Product> pr = new ArrayList(hm.values());
        HashMap<String, Integer> result = new HashMap<>();
        for (Product product : pr) {
            String supplier = product.getSupplier();
            if (result.containsKey(supplier)) {
                int count = result.get(supplier);
                result.put(supplier, count + 1);
            } else {
                result.put(supplier, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String supplier = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < 25; i++) {
                System.out.println("-");
            }
            System.out.println("");
            System.out.printf("|%10s|%12s|", "SUPPLIER", "STATISTICS");
            for (int i = 0; i < 25; i++) {
                System.out.println("-");
            }
            System.out.println("");
            System.out.printf("|%10s|%12d|\n", supplier, count);
            for (int i = 0; i < 25; i++) {
                System.out.println("-");
            }
            System.out.println("");
        }
    }
}
