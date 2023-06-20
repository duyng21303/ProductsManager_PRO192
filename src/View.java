
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author NguyenDuy
 */
public class View {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Products prs = new Products();
        Input ip = new Input();
        while (true) {
            System.out.println("1 – Add product informa�on\n"
                    + "2 – Show all products\n"
                    + "3 – Delete a product\n"
                    + "4 – Filter products by SUPPLIER\n"
                    + "5 – Sort and display product\n"
                    + "6 – Statistics the products by SUPPLIER\n"
                    + "7 – Exit program");

            int choice = ip.inputInt();
            switch (choice) {
                case 1:
                    prs.addProduct();
                    break;
                case 2:
                    prs.showProduct();
                    break;
                case 3:
                    prs.deleteProduct();
                    break;
                case 4:
                    prs.filterProduct();
                    break;
                case 5:
                    prs.sortProduct();
                    break;
                case 6:
                    prs.countProductsBySupplier();
                    break;
                default:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}
