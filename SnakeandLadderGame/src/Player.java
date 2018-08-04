import java.util.Random;

public class Player {

    public int position = 0;
    public int index = 0;
    public static Random random = new Random();

    public int setPosition(int play, GameData.Data matrix[])
    {
        position += play;

        if(position >= GameData.UPPER_BOUND)
        {
            System.out.println(String.format("Player %d wins",index));
            System.exit(1);
        }
        switch (matrix[position].type)
        {
            case GameData.SQUARE:
                return position;
            case GameData.LADDER:
                return matrix[position].endPoint;
            case GameData.SNAKE:
                return matrix[position].endPoint;
        }
        return 0;
    }

    public void play(GameData.Data matrix[])
    {
        int play = random.nextInt(6) + 1;
        position = setPosition(play, matrix);
    }

}
