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
        int count = 0;
        // 장바구니에 이미 존재하는 경우
        if(orderList.contains(products)){
            this.countMenuList.put(products.name, count++);
            this.totalOrderList.add(products);
        }else{
            this.orderList.add(products);
            this.totalOrderList.add(products);
        }
        this.totalPrice += products.price;
        this.totalSellPrice += products.price;
        System.out.println(products.name + " 가 장바구니에 추가되었습니다.\n");
    }

    public void confirmOrder(Products products) {
        System.out.println("\"" + products.toString() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }

    public void printOrder() {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.printf("[ %s ]\n", "Orders");
        for (Products p : orderList) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.printf("[ %s ]\n", "Total");
        System.out.println("W " + totalPrice);

        System.out.println();
        System.out.println("1. 주문       2. 메뉴판");
    }

    public void orderFinish(){
        waiting += 1;
        orderList.clear();
        totalPrice = 0;
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.printf("대기번호는 [ %d ] 번 입니다.\n", waiting);
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        System.out.println();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void printCancel(){
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }

    public void cancel(){
        orderList.clear();
        totalPrice = 0;
        System.out.println("진행하던 주문이 취소되었습니다.\n");
    }

    public void printTotal(){
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