import java.util.Scanner;

public class Ladders extends Position{

    public Scanner s = new Scanner(System.in);

    public void getLaddersPosition(int noOfLadders, GameData.Data[] matrix)
    {
        for(int index = 1; index < noOfLadders + 1; index ++)
        {
            System.out.println("Enter the Start and End position of Ladder "+(index));
            int startPosition = s.nextInt();
            int endPosition = s.nextInt();
            if(startPosition >= endPosition)
            {
                System.out.println("Invalid position for ladder.");
                index --;
            }
            else if(checkValidCoordinates(startPosition, endPosition, matrix)) {
                setPosition(index, startPosition, endPosition, matrix, GameData.LADDER);
            }
            else
            {
                index --;
            }
        }
    }
}
