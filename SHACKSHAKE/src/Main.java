import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    MainBoard mainBoard = new MainBoard();
    Order order = new Order();
    Scanner sc = new Scanner(System.in);

    //키오스크 프로그램 알파이자 오메가이자 본체
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        init();

        while (true) {
            mainBoard.printMenu();
            int n = sc.nextInt();
            if (n == 5) {
                order();
            } else if (n == 6) {
                order.printCancel();
                int c = sc.nextInt();
                if (c == 1) {
                    order.cancel();
                }
            } else if (n == 0) {
                order.printTotal();
            } else {
                selectMenu(n);
            }
        }
    }

    private void selectMenu(int n) {
        mainBoard.printProducts(n);
        Integer count;
        int dn = sc.nextInt();
        order.confirmOrder(mainBoard.menuList.get(n - 1).productsList.get(dn - 1));
        int c = sc.nextInt();
        if (c == 1) {
            order.addOrder(mainBoard.menuList.get(n - 1).productsList.get(dn - 1));
        }
    }

    private void order() {
        order.printOrder();
        int o = sc.nextInt();
        if (o == 1) {
            order.orderFinish();
        }
    }

    public void init() {
        Menu Burgers = new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거");
        Menu FrozenCustard = new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림");
        Menu Drinks = new Menu("Drinks", "매장에서 직접 만드는 음료");
        Menu Beer = new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주");


        Products shackBurger = new Products("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9);
        Products smokeBurger = new Products("SmokeBurger", "애플 우드 칩으로 훈연한 베이컨, 매콤한 체리 페퍼에 쉑소스가 토핑된 치즈 버거", 8.9);
        Products shroomBurger = new Products("'Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채우고 바삭하게 튀겨낸 포토벨로 버섯 패티에 양상추," +
                "토마토, 쉑소스를 올린 베지테리안 버거", 9.4);
        Products shackStack = new Products("Shack Stack", "슈룸 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴", 12.4);
        Products cheeseBurger = new Products("Cheese Burger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9);
        Products hamBurger = new Products("Ham Burger", "포테이토 번과 비프패티를 기본으로 신선한 양상추, 토마토 피클, 양파 토핑을 취향에 따라" +
                "선택할 수 있는 버거", 5.4);

        Burgers.addProduct(shackBurger);
        Burgers.addProduct(smokeBurger);
        Burgers.addProduct(shroomBurger);
        Burgers.addProduct(shackStack);
        Burgers.addProduct(cheeseBurger);
        Burgers.addProduct(hamBurger);

        Products shakes = new Products("Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피", 5.9);
        Products shakeOftheWeek = new Products("Shake of the Week", "특별한 커스터드 플레이버", 6.5);
        Products redBeanShake = new Products("Red Beean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6.5);
        Products floats = new Products("Floats", "루트 비어, 퍼플 카우, 크림시클", 5.9);

        Products cupANDcons = new Products("Cups&Cones", "바닐라, 초콜렛, Flavor of the Week", 4.9);
        Products concretes = new Products("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5.9);
        Products shackAttack = new Products("Shack Attack", "초콜렛 퍼지 소스, 초콜렛 트러플 쿠키, Lumiere 초콜렛 청크와 스프리클이 들어간" +
                "진한 초콜렛 커스타드", 5.9);

        FrozenCustard.addProduct(shakes);
        FrozenCustard.addProduct(shakeOftheWeek);
        FrozenCustard.addProduct(redBeanShake);
        FrozenCustard.addProduct(floats);
        FrozenCustard.addProduct(cupANDcons);
        FrozenCustard.addProduct(concretes);
        FrozenCustard.addProduct(shackAttack);

        Products shackMadeLemonade = new Products("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드(오리지날/시즈널)", 3.9);
        Products freshBrewedIcedTea = new Products("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4);
        Products fiftyFifty = new Products("Fifty/Fifty", "레몬에이드와 아이스티의 만남", 3.5);
        Products fountainSoda = new Products("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지 , 환타 그레이프", 2.7);
        Products abitaRootBeer = new Products("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4);
        Products bottledWater = new Products("Bottled Wate", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0);

        Drinks.addProduct(shackMadeLemonade);
        Drinks.addProduct(freshBrewedIcedTea);
        Drinks.addProduct(fiftyFifty);
        Drinks.addProduct(fountainSoda);
        Drinks.addProduct(abitaRootBeer);
        Drinks.addProduct(bottledWater);

        Products shackMeisterAle = new Products("Shack Meister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9.8);
        Products magpieBrewingCo = new Products("Magpie Brewing Co.", "", 6.8);

        Beer.addProduct(shackMeisterAle);
        Beer.addProduct(magpieBrewingCo);

        this.mainBoard.addMenu(Burgers);
        this.mainBoard.addMenu(FrozenCustard);
        this.mainBoard.addMenu(Drinks);
        this.mainBoard.addMenu(Beer);
    }

}
