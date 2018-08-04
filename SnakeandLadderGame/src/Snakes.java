import java.util.Scanner;

public class Snakes extends Position{

    public Scanner s = new Scanner(System.in);

    public void getSnakesPosition(int noOfSnakes, GameData.Data[] matrix)
    {
        for(int index = 1; index < noOfSnakes + 1; index ++)
        {
            System.out.println("Enter the Start and End Position of Snake "+(index));
            int startPosition = s.nextInt();
            int endPosition = s.nextInt();
            if(startPosition <= endPosition)
            {
                System.out.println("Invalid position for snakes.");
                index--;
            }
            else if(checkValidCoordinates(startPosition, endPosition, matrix)) {
                setPosition(index, startPosition, endPosition, matrix, GameData.SNAKE);
            }
            else
            {
                index --;
            }
        }
    }
}
