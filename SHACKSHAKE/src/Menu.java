import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    String name;
    String detail;
    List<Products> productsList = new ArrayList<>();

    public Menu(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public void addProduct(Products products) {
        this.productsList.add(products);
    }

}
