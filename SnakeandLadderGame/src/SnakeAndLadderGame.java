import java.util.Scanner;

public class SnakeAndLadderGame {

    public GameData.Data[] matrix = new GameData.Data[GameData.UPPER_BOUND + 1];
    public Player players[];
    public static Scanner s = new Scanner(System.in);

    public SnakeAndLadderGame()
    {
        for(int position = 1; position <=100; position ++)
        {
            matrix[position] = new GameData().new Data();
            matrix[position].endPoint = position;
            matrix[position].value =  String.valueOf(position);
        }
    }

    public void getSnakesInfo()
    {
        System.out.println("Enter the number of Snakes");
        int noOfSnakes = s.nextInt();
        Snakes snakeObject = new Snakes();
        snakeObject.getSnakesPosition(noOfSnakes,matrix);
    }

    public void getLadderInfo()
    {
        System.out.println("Enter the number of Ladders");
        int noOfLadders = s.nextInt();
        Ladders ladderObject = new Ladders();
        ladderObject.getLaddersPosition(noOfLadders, matrix);
    }

    public void getPlayerInfo()
    {
        System.out.println("Enter the number of Players");
        int nofOfPlayers = s.nextInt();
        players = new Player[nofOfPlayers];
        for(int index = 0; index < nofOfPlayers; index ++)
        {
            players[index] = new Player();
            players[index].index = index + 1;
        }
    }

    public void printGame()
    {
        int position = GameData.UPPER_BOUND;
        boolean flag = true;
        while(position > 0)
        {
            if(flag)
            {
                for(int i = 0; i < 10; i++)
                {
                    if(matrix[position].normal)
                        System.out.print(String.format("%10d ", position--));
                    else
                        System.out.print(String.format("%10s", matrix[position--].value));
                }
                position -= 9;
            }
            else
            {
                for(int i = 0; i < 10; i++)
                {
                    if(matrix[position].normal)
                        System.out.print(String.format("%10d ", position++));
                    else
                        System.out.print(String.format("%10s", matrix[position++].value));
                }
                position -= 11;
            }

            flag = ! flag;
            System.out.println();
        }

        for(Player player: players)
            System.out.println(String.format("Player %d position : %d",player.index,player.position));

    }
    public void playGame()
    {
        System.out.println("Game Begins !!!");
        while(true)
        {
            for(Player player : players)
            {
                printGame();
                player.play(matrix);
                s.nextInt();
            }
        }
    }

    public static void main(String[] args)
    {
        SnakeAndLadderGame obj = new SnakeAndLadderGame();
        obj.getSnakesInfo();
        obj.getLadderInfo();
        obj.getPlayerInfo();
        obj.playGame();
    }
}
