import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Products extends Menu {
    final double price;
    public Products(String name, String detail, double price) {
        super(name, detail);
        this.price = price;
    }

    public String printProducts(int count){
        return String.format("%-24s | W %-5.1f | %d개 | %s", this.name, this.price, count, this.detail);
    }

    @Override
    public String toString() {
        return String.format("%-24s | W %-5.1f | %s", this.name, this.price, this.detail);
    }
}

