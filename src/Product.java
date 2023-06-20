
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author NguyenDuy
 */
public class Product implements Valuable, Comparable<Product> {

    private String productCode;
    private String productName;
    private String supplier;
    private String unit;
    private double price;
    private float quantity;
    private boolean hasPromottion;

    public Product() {
    }

    public Product(String productCode, String productName, String supplier, String unit, double price, float quantity, boolean hasPromottion) {
        this.productCode = productCode;
        this.productName = productName;
        this.supplier = supplier;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.hasPromottion = hasPromottion;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public boolean isHasPromottion() {
        return hasPromottion;
    }

    public void setHasPromottion(boolean hasPromottion) {
        this.hasPromottion = hasPromottion;
    }

    @Override
    public String toString() {
        return "Products{" + "productCode=" + productCode + ", productName=" + productName + ", supplier=" + supplier + ", unit=" + unit + ", price=" + price + ", quantity=" + quantity + ", hasPromottion=" + hasPromottion + '}';
    }

    @Override
    public float value() {
        return (float) price * quantity;
    }

    @Override
    public float vat() {
        return (value() * 8) / 100;
    }

    @Override
    public float promotion() {
        if (hasPromottion) {
            return (value() * 15) / 100;
        }
        return 0;
    }

    public void printProduct() {
        System.out.printf("|%7s|%7s|%10s|%7s|%8.1f|%5.1f|%9.1f|\n", productCode, productName, supplier, unit, value(), vat(), promotion());
    }

    @Override
    public int compareTo(Product o) {
        return o.getProductName().compareToIgnoreCase(o.getProductName());
    }

    public static Comparator<Product> compareValue = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int result = 0;
            Product acc1 = (Product) o1;
            Product acc2 = (Product) o2;
            if (acc1.value() > acc2.value()) {
                result = 1;
            } else if (acc1.value() < acc2.value()) {
                result = -1;
            }
            return result;
        }
    };
}
