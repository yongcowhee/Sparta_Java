import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String foodName = br.readLine();
        float star = Float.parseFloat(br.readLine());
        String[] recipeArr = new String[10];

        for (int i = 0; i < 10; i++) {
            recipeArr[i] = br.readLine();
        }

        System.out.println("[ " + foodName + " ]");
        System.out.println("별점 : " + (int) star + " (" + (float) ((int) star * (100 / 5)) + "%)");

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + ". " + recipeArr[i]);
        }

    }
}