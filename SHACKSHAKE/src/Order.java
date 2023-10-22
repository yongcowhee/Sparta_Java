import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    double totalPrice;
    double totalSellPrice;
    int waiting;
    List<Products> orderList = new ArrayList<>();
    List<Products> totalOrderList = new ArrayList<>();
    Map<String, Integer> countMenuList = new HashMap<>();

    public void addOrder(Products products) {
        // 장바구니에 이미 존재하는 경우
        if (orderList.contains(products)) {
            int count = this.countMenuList.getOrDefault(products.name, 0);
            this.countMenuList.put(products.name, ++count);
        } else {
            this.orderList.add(products);
            this.countMenuList.put(products.name, 1);
        }
        this.totalPrice += products.price;
        System.out.println(products.name + " 가 장바구니에 추가되었습니다.\n");
    }

    public void confirmOrder(Products products) {
        System.out.println("\"" + products.toString() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }

    public void confirmOption(Products products) {
        if (!products.optionList.isEmpty()) {
            int index = 0;
            System.out.println(products.toString());
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            for (Products.ProductOption p : products.optionList) {
                index++;
                System.out.printf("%d. %s(W %.1f)       ", index, p.optionName, p.price);
            }
            System.out.println();
        }
    }

    public void printOrder() {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.printf("[ %s ]\n", "Orders");
        for (Products p : orderList) {
            Integer count = this.countMenuList.get(p.name);
            System.out.println(p.printProducts(count));
        }
        System.out.println();
        System.out.printf("[ %s ]\n", "Total");
        System.out.printf("W %.1f " + totalPrice);

        System.out.println();
        System.out.println("1. 주문       2. 메뉴판");
    }

    public void orderFinish(List<Products> orderList) {
        for (Products p : orderList) {
            this.totalSellPrice += p.price * this.countMenuList.get(p.name);
            for (int i = 0; i < this.countMenuList.get(p.name); i++) {
                this.totalOrderList.add(p);
            }

        }
        waiting += 1;
        orderList.clear();
        totalPrice = 0;
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.printf("대기번호는 [ %d ] 번 입니다.\n", waiting);
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        System.out.println();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printCancel() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }

    public void cancel() {
        orderList.clear();
        totalPrice = 0;
        System.out.println("진행하던 주문이 취소되었습니다.\n");
    }

    public void printTotal() {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W %.2f ] 입니다.\n", this.totalSellPrice);
        System.out.println();
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();
        for (Products p : this.totalOrderList) {
            System.out.printf("- %-25s | W %.2f\n", p.name, p.price);
        }
        System.out.println();
    }
}