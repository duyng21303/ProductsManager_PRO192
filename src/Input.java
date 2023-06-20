
import java.util.HashMap;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author NguyenDuy
 */
public class Input {

    Scanner sc = new Scanner(System.in);

    public String inputCode(HashMap<String, Product> hm) {
        String code;
        do {
            System.out.println("Enter product code: ");
            code = sc.nextLine();
            if (hm.containsKey(code)) {
                System.out.println("Duplicated code.Try with another one");
                continue;
            }
            return code;
        } while (true);
    }

    public double inputPrice() {
        double price;
        while (true) {
            System.out.println("Enter price: ");
            String rs_raw = sc.nextLine();
            try {
                price = Double.parseDouble(rs_raw);
                return price;
            } catch (NumberFormatException e) {
                System.out.println("This must be number ");
                continue;
            }
        }
    }

    public float inputQuantity() {
        float quantity;
        while (true) {
            System.out.println("Enter quantity: ");
            String rs_raw = sc.nextLine();
            try {
                quantity = Float.parseFloat(rs_raw);
                return quantity;
            } catch (NumberFormatException e) {
                System.out.println("This must be number ");
                continue;
            }
        }
    }

    public boolean inputHasPromotion() {
        String choice;
        while (true) {
            System.out.println("Product has promotion?(Y/N): ");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                return true;
            }else if(choice.equalsIgnoreCase("N")){
                return false;
            }else{
                System.out.println("Must be Y or N");
                continue;
            }
        }
    }
    public boolean inputYN(String msg) {
        String choice;
        while (true) {
            System.out.println(msg);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                return true;
            }else if(choice.equalsIgnoreCase("N")){
                return false;
            }else{
                System.out.println("Must be Y or N");
                continue;
            }
        }
    }
    public int inputInt(){
        int interger;
        while (true) {
            String rs_raw = sc.nextLine();
            try {
                interger = Integer.parseInt(rs_raw);
                return interger;
            } catch (NumberFormatException e) {
                System.out.println("This must be number ");
                continue;
            }
        }
    }
}
