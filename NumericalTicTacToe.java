import java.util.Scanner;

public class NumericalTicTacToe {

  //initializePlayer
  public static Player initializePlayer(Scanner in, int playerNumber){
    //Prompt user + store info
    System.out.println("Player " + playerNumber + ", enter your name:");
    String p1 = in.nextLine();
    System.out.println("Evens or odds?");
    String a = in.nextLine();
    char ch = ' ';
    if (a.equalsIgnoreCase("evens")||a.equalsIgnoreCase("even")){
        ch = 'e';
    }
    else if (a.equalsIgnoreCase("odds")||a.equalsIgnoreCase("odd")){
        ch = 'o';
    }
    else{
        System.out.println("Error: Invalid answer. Type \"evens\" or \"odds\":");
        a = in.nextLine();
    if (a.equalsIgnoreCase("evens")||a.equalsIgnoreCase("even")){
        ch = 'e';
    }
    else if (a.equalsIgnoreCase("odds")||a.equalsIgnoreCase("odd")){
        ch = 'o';
    }
    }
    Player one = new Player(p1, ch);
    return one;
  }

  //Board
  public static void printBoard(Board board){
    System.out.println("     |     |     ");
    System.out.println(board.getTopRow());
    System.out.println("     |     |     ");
    System.out.println("-----------------");
    System.out.println("     |     |     ");
    System.out.println(board.getMiddleRow());
    System.out.println("     |     |     ");
    System.out.println("-----------------");
    System.out.println("     |     |     ");
    System.out.println(board.getBottomRow());
    System.out.println("     |     |     ");
  }

  //Move
  public static void move(Scanner in, Board board, Player currentPlayer){
    //prompt user for coordinates + store info
    System.out.println(currentPlayer.getPlayerName() + ", enter coordinates. Format: (row,column)");
    String m1 = in.nextLine();
    if (m1.length()<5){
      System.out.println("Error: Invalid coordinates. Please reenter. Format: (row,column)");
      m1 = in.nextLine();
    }
    String x = m1.substring(1,2);
    String y = m1.substring(3,4);
    String xy = x + y;

    //prompt user for value
    String ch = " ";
    if(currentPlayer.getGameCharacter()=='e'){
        System.out.println(currentPlayer.getPlayerName() + ", enter an even number 1-9");
        String EA = in.nextLine();
        System.out.println();
        String evens = "2468";
        if (!evens.contains(EA)||EA.length()!=1){
            System.out.println("Error: Invalid input. Please reenter an even number 1-9");
            ch = in.nextLine();
        }
        else{
            ch = EA;
        }
    }
    else if (currentPlayer.getGameCharacter()=='o'){
        System.out.println(currentPlayer.getPlayerName() + ", enter an odd number 1-9");
        String OA = in.nextLine();
        System.out.println();
        String odds = "13579";
        if (!odds.contains(OA)||OA.length()!=1){
            System.out.println("Error: Invalid input. Please reenter an odd number 1-9");
            ch = in.nextLine();
        }
        else{
            ch = OA;
        }
    }

    //assign variables each getRow value
    String t = board.getTopRow();
    String m = board.getMiddleRow();
    String b = board.getBottomRow();
    String O_O = t.substring(0,6);
    String O_I = t.substring(6,13);
    String O_II = t.substring(13);
    String I_O = m.substring(0,6);
    String I_I = m.substring(6,13);
    String I_II = m.substring(13);
    String II_O = b.substring(0,6);
    String II_I = b.substring(6,13);
    String II_II = b.substring(13);
    String ono = t.charAt(2)+"";
    String oni = t.charAt(8)+"";
    String onii = t.charAt(14)+"";
    String ino = m.charAt(2)+"";
    String ini = m.charAt(8)+"";
    String inii = m.charAt(14)+"";
    String iino = b.charAt(2)+"";
    String iini = b.charAt(8)+"";
    String iinii = b.charAt(14)+"";

    //to ensure valid input
    String numbers = "1.2.3.4.5.6.7.8.9";
    String options = "00.01.02.10.11.12.20.21.22";
    if (!options.contains(xy)){
      System.out.println("Error: invalid coordinates. Format: (row,column), no spaces");
    }
    else{
    if (xy.equals("00")){
      //run if cell is empty
      if (!options.contains(numbers)){
        O_O = O_O.substring(0,2)+ch+O_O.substring(3);
      }
      //if cell is already filled
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }
    else if (xy.equals("01")){
      if (!numbers.contains(oni)){
        O_I = O_I.substring(0,2)+ch+O_I.substring(3);
      }
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }
    else if (xy.equals("02")){
      if (!numbers.contains(onii)){
        O_II = O_II.substring(0,1)+ch+O_II.substring(2);
      }
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }
    else if (xy.equals("10")){
      if (!numbers.contains(ino)){
        I_O = I_O.substring(0,2)+ch+I_O.substring(3);
      }
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }
    else if (xy.equals("11")){
      if (!numbers.contains(ini)){
        I_I = I_I.substring(0,2)+ch+I_I.substring(3);
      }
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }
    else if (xy.equals("12")){
      if (!numbers.contains(inii)){
        I_II = I_II.substring(0,1)+ch+I_II.substring(2);
      }
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }
    else if (xy.equals("20")){
      if (!numbers.contains(iino)){
        II_O = II_O.substring(0,2)+ch+II_O.substring(3);
      }
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }
    else if (xy.equals("21")){
      if (!numbers.contains(iini)){
        II_I = II_I.substring(0,2)+ch+II_I.substring(3);
      }
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }
    else if (xy.equals("22")){
      if (!numbers.contains(iinii)){
        II_II = II_II.substring(0,1)+ch+II_II.substring(2);
      }
      else{
        System.out.println("Error: Cell already contains a character");
      }
    }

    board.setTopRow(O_O + O_I + O_II);
    board.setMiddleRow(I_O + I_I + I_II);
    board.setBottomRow(II_O + II_I + II_II);

    printBoard(board);
    System.out.println();
  }
  }
  
  //isGameOver
  public static boolean isGameOver(Board board, Player one, Player two){
    String t = board.getTopRow();
    String m = board.getMiddleRow();
    String b = board.getBottomRow();
    String ono = t.charAt(2)+"";
    String oni = t.charAt(8)+"";
    String onii = t.charAt(14)+"";
    String ino = m.charAt(2)+"";
    String ini = m.charAt(8)+"";
    String inii = m.charAt(14)+"";
    String iino = b.charAt(2)+"";
    String iini = b.charAt(8)+"";
    String iinii = b.charAt(14)+"";
    String numbers = "123456789";
    //row1
    if(!numbers.contains(ono)){
        ono = "0";
    }
    if(!numbers.contains(oni)){
        oni = "0";
    }
    if(!numbers.contains(onii)){
        onii = "0";
    }
    //row2
    if(!numbers.contains(ino)){
        ino = "0";
    }
    if(!numbers.contains(ini)){
        ini = "0";
    }
    if(!numbers.contains(inii)){
        inii = "0";
    }
    //row3
    if(!numbers.contains(iino)){
        iino = "0";
    }
    if(!numbers.contains(iini)){
        iini = "0";
    }
    if(!numbers.contains(iinii)){
        iinii = "0";
    }
    //Convert cell contents from strings to ints
    int oNo = Integer.parseInt(ono);
    int oNi = Integer.parseInt(oni);
    int oNii = Integer.parseInt(onii);
    int iNo = Integer.parseInt(ino);
    int iNi = Integer.parseInt(ini);
    int iNii = Integer.parseInt(inii);
    int iiNo = Integer.parseInt(iino);
    int iiNi = Integer.parseInt(iini);
    int iiNii = Integer.parseInt(iinii);

    //horizontal solutions
    if (oNo+oNi+oNii==15&&oNo!=0&&oNi!=0&&oNii!=0){
        return true;
    }
    else if (iNo+iNi+iNii==15&&iNo!=0&&iNi!=0&&iNii!=0){
        return true;
    }
    else if (iiNo+iiNi+iiNii==15&&iiNo!=0&&iiNi!=0&&iiNii!=0){
        return true;
    }
    //vertical solutions
    else if (oNo+iNo+iiNo==15&&oNo!=0&&iNo!=0&&iiNo!=0){
        return true;
    }
    else if (oNi+iNi+iiNi==15&&oNi!=0&&iNi!=0&&iiNi!=0){
        return true;
    }
    else if (oNii+iNii+iiNii==15&&oNii!=0&&iNii!=0&&iiNii!=0){
        return true;
    }
    //diagonal
    else if (oNo+iNi+iiNii==15&&oNo!=0&&iNi!=0&&iiNii!=0){
        return true;
    }
    else if (iiNo+iNi+oNii==15&&iiNo!=0&&iNi!=0&&oNii!=0){
        return true;
    }
    //tie
    else if(oNo!=0&&oNi!=0&&oNii!=0&&iNo!=0&&iNi!=0&&iNii!=0&&iiNo!=0&&iiNi!=0&&iiNii!=0){
      return true;
    }
    //otherwise, game is not over
    else{
      return false;
    }
  }
  
  //announceResult
  public static void announceResult(Board board, String winner){
    String t = board.getTopRow();
    String m = board.getMiddleRow();
    String b = board.getBottomRow();
    String ono = t.charAt(2)+"";
    String oni = t.charAt(8)+"";
    String onii = t.charAt(14)+"";
    String ino = m.charAt(2)+"";
    String ini = m.charAt(8)+"";
    String inii = m.charAt(14)+"";
    String iino = b.charAt(2)+"";
    String iini = b.charAt(8)+"";
    String iinii = b.charAt(14)+"";
    String numbers = "123456789";
    //row1
    if(!numbers.contains(ono)){
        ono = "0";
    }
    if(!numbers.contains(oni)){
        oni = "0";
    }
    if(!numbers.contains(onii)){
        onii = "0";
    }
    //row2
    if(!numbers.contains(ino)){
        ino = "0";
    }
    if(!numbers.contains(ini)){
        ini = "0";
    }
    if(!numbers.contains(inii)){
        inii = "0";
    }
    //row3
    if(!numbers.contains(iino)){
        iino = "0";
    }
    if(!numbers.contains(iini)){
        iini = "0";
    }
    if(!numbers.contains(iinii)){
        iinii = "0";
    }
    //Convert cell contents from strings to ints
    int oNo = Integer.parseInt(ono);
    int oNi = Integer.parseInt(oni);
    int oNii = Integer.parseInt(onii);
    int iNo = Integer.parseInt(ino);
    int iNi = Integer.parseInt(ini);
    int iNii = Integer.parseInt(inii);
    int iiNo = Integer.parseInt(iino);
    int iiNi = Integer.parseInt(iini);
    int iiNii = Integer.parseInt(iinii);
    if(numbers.contains(ono)&&numbers.contains(oni)&&numbers.contains(onii)&&numbers.contains(ino)&&numbers.contains(ini)&&numbers.contains(inii)&&numbers.contains(iino)&&numbers.contains(iini)&&numbers.contains(iinii)){
      System.out.println("It's a tie!");
    }
    else{
    System.out.println("Congratulations, " + winner + " wins!");
    }
  }

  //main
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    //Initialize players
    Player one = initializePlayer(in, 1);
    System.out.println();
    System.out.println("Player 2, enter your name:");
    String name = in.nextLine();
    char GC2 = 'e';
    String x = "evens";
    if (one.getGameCharacter()=='e'){
      GC2 = 'o';
      x = "odds";
    }
    Player two = new Player(name, GC2);
    System.out.println(name+", you will be " + x);
    System.out.println();
    Board example = new Board();
    example.setTopRow("(0,0)|(0,1)|(0,2)");
    example.setMiddleRow("(1,0)|(1,1)|(1,2)");
    example.setBottomRow("(2,0)|(2,1)|(2,2)");
    System.out.println("Example board:");
    printBoard(example);
    System.out.println();

    //Create board
    Board board = new Board();
    String winner = " ";
    //Execute game!
    while (!isGameOver(board, one, two)){
      move(in, board, one);
      if(isGameOver(board, one, two)){
        winner = one.getPlayerName();
      }
      if(!isGameOver(board, one, two)){
        move(in, board, two);
        winner = two.getPlayerName();
      }
    }
    announceResult(board, winner);

    in.close();
  }
}