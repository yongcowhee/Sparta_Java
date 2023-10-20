import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainBoard {

//    Menu Burgers = new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거");
//    Menu FrozenCustard = new Menu("Frozen Custard","매장에서 신선하게 만드는 아이스크림");
//    Menu Drinks = new Menu("Drinks", "매장에서 직접 만드는 음료");
//    Menu Beer = new Menu("Beer","뉴욕 브루클린 브루어리에서 양조한 맥주");

    List<Menu> menuList = new ArrayList<>();

    public void addMenu(Menu menu) {
        this.menuList.add(menu);
    }

    public void printMenu() {
        int index = 1;
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("[ SHAKESHACK MENU ]");
        for (Menu m : menuList) {
            System.out.printf("%d. %-20s | %-30s\n", index, m.name, m.detail);
            index++;
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.printf("%d. %-10s | 장바구니를 확인 후 주문합니다.\n", index, "Order");
        System.out.printf("%d. %-10s | 진행중인 주문을 취소합니다.\n", ++index, "Cancel");
    }

    public void printProducts(int n) {
        int index = 1;
        System.out.println("[ " + menuList.get(n-1).name + " MENU ]");
        for (Products p : menuList.get(n - 1).productsList) {
            System.out.printf("%d. %-24s | W %-5.1f | %s\n", index, p.name, p.price, p.detail);
            index++;
        }
    }
}
