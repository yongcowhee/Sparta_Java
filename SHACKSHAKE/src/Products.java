import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products extends Menu {
    double price;
    final List<ProductOption> optionList;

    public Products(String name, String detail, double price, List<ProductOption> optionList) {
        super(name, detail);
        this.price = price;
        this.optionList = optionList;
    }

    public String printProducts(int count){
        return String.format("%-24s | W %-5.1f | %d개 | %s", this.name, this.price, count, this.detail);
    }

    @Override
    public String toString() {
        return String.format("%-24s | W %-5.1f | %s", this.name, this.price, this.detail);
    }

    static class ProductOption{
        String optionName;
        double price;

        public ProductOption(String optionName, double price) {
            this.optionName = optionName;
            this.price = price;
        }
    }
}



