public class Position {

    public void setPosition(int index, int startPosition, int endPosition, GameData.Data[] matrix, String type)
    {
        matrix[startPosition].type = type;
        matrix[startPosition].endPoint = endPosition;
        matrix[startPosition].value = type + " : " + index + "start";
        matrix[endPosition].value = type + " : " + index + "end";
        matrix[startPosition].normal = false;
        matrix[endPosition].normal = false;
    }

    public static boolean checkValidCoordinates(int startPosition, int endPosition, GameData.Data matrix[])
    {
        if(startPosition < GameData.LOWER_BOUND && startPosition > GameData.UPPER_BOUND)
        {
            System.out.println("Invalid position for start position.");
            return false;
        }
        else if(endPosition < GameData.LOWER_BOUND && endPosition > GameData.UPPER_BOUND)
        {
            System.out.println("Invalid position for end position");
            return false;
        }
        else if(matrix[startPosition].type != GameData.SQUARE)
        {
            System.out.println("The given position is not valid as it is not of type Square(NOT EMPTY");
            return false;
        }
        return true;
    }
}
