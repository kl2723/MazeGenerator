import java.util.Random;
import java.util.ArrayList;

public class Maze {

    static ArrayList<String> visitedStack = new ArrayList<>();

    static char mazeArray[][] = new char[12][12];
    static String chosenValue;



    public static void main(String[] args) {

        Random randNumGenerator = new Random();
        int count = 0;
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;
        int randX = 0;
        int randY = 0;


        for (int y = 0; y < mazeArray.length; y++) {
            System.out.println();
            for (int x = 0; x < mazeArray[y].length; x++) {
                mazeArray[y][x] = '*';
                System.out.print("\t");
                System.out.print(mazeArray[y][x]);
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        mazeArray[0][0] = ' ';

        while (count < 48) {
            for (int y = 0; y < mazeArray.length; y++) {
                for (int x = 0; x < mazeArray[y].length; x++) {
                    endX++;
                    startX = endX--;
                    endY++;
                    startY = endY--;
                    randX = randNumGenerator.nextBoolean() ? startX : endX;
                    randY = randNumGenerator.nextBoolean() ? startY : endY;
                    mazeArray[randY][randX] = ' ';
                    chosenValue = "Coordinate: " + randY + " , " + randX;
                    visitedStack.add(chosenValue);
                    count++;
                }
            }
        }

        for (int y = 0; y < mazeArray.length; y++) {
            System.out.println();
            for (int x = 0; x < mazeArray[y].length; x++) {
                System.out.print("\t");
                System.out.print(mazeArray[y][x]);
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("Coordinates visited \n \n");


        for (int i = 0; i < visitedStack.size(); i++) {
            System.out.println(visitedStack.get(i));
        }
    }

    public void push(String value) {
        visitedStack.add(value);
    }
}

