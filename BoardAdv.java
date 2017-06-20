//make class
public class BoardAdv
{
    //creates board

    static Board playerField = new Board(10,10);
    //piece position for moving pieces
    static String[][] piecePosition = new String[10][10];
    //starting points
    static int points=20;
    //string to output points
    //used in pointscollect,allLevel
    static String outPoints;
    //starting level
    static int level=0;
    static int row,col;
    //randomizes x and y values
    //used in boardSetup
    static boolean levelUp=false;
    static int randX,randY;


    //method to move pieces
    static void movePiece(int row, int col, int nRow, int nCol){
      //removes the peg from the current position
      playerField.removePeg(row,col);
      //puts the peg somewhere else
      playerField.putPeg(piecePosition[row][col],nRow,nCol);
      //changes the color of the piece
      piecePosition[nRow][nCol]=piecePosition[row][col];
      //if the position has changed
      if(row!=nRow || col!=nCol)
      {
         //the former position is now empty
         piecePosition[row][col]="empty";
      }

   }
    //checks if there is already a piece on the spot
    static void moveCheck(int x, int y)
    {
       //if the piece is red
      if(piecePosition[x][y]=="red")
      {
          //run the red hit method
         redHit();
      }
      //if the piece is green
      else if(piecePosition[x][y]=="green")
      {
         //player gets 5 points
         points+=5;
         levelUp=true;
      }
      //if the piece is white
      else if(piecePosition[x][y]=="white")
      {
          //run the points collect method
         pointsCollect();
      }
      else if(piecePosition[x][y]=="cyan")
      {
          superPoints();
      }
   }
    //gives the player points for landing on the white
    static void pointsCollect()
    {
       //gives the player two points
      points+=2;
      //outpoints is now the value of the total points
      outPoints = String.valueOf(points);
      //outpoints is printed to the screen
      playerField.displayMessage(outPoints);
   }
    static void superPoints(){
        points+=5;
    }
    static void boardSetup()
    {
       //player levels up
       level++;
       //random x and y variables are made
       //makes the entire board empty
       for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               piecePosition[i][j] = "empty";
           }
       }
       //puts the player at 0,0
       piecePosition[0][0] = "yellow";
       movePiece(0, 0, 0, 0);
       //puts the goal at 9,9
       piecePosition[9][9] = "green";
       movePiece(9, 9, 9, 9);
       //puts w1 at 55
       piecePosition[5][5] = "white";
       movePiece(5, 5, 5, 5);
       //p,0,0 g,9,9 w1,5,5
       if (level > 1) {
           //puts w2 at 3,6
           piecePosition[3][6] = "white";
           movePiece(3, 6, 3, 6);
           //p,0,0 g,9,9 w1,5,5 w2,3,6
       }
       if (level > 2) {
           //puts w3 at 5,2
           piecePosition[5][2] = "white";
           movePiece(5, 2, 5, 2);
           //puts r1 at 7,7
           piecePosition[7][7] = "red";
           movePiece(7, 7, 7, 7);
           //p,0,0 g,9,9 w1,5,5 w2,3,6 w3,5,2 r1,7,7
       }
       if (level > 3) {
           //puts r2 at 4,4
           piecePosition[4][4] = "red";
           movePiece(4, 4, 4, 4);
           //puts r3 at 4,5
           piecePosition[4][5] = "red";
           movePiece(4, 5, 4, 5);
           //puts r4 at 5,4
           piecePosition[5][4] = "red";
           movePiece(5, 4, 5, 4);
           //p,0,0 g,9,9 w1,5,5 w2,3,6 w3,5,2 r1,7,7
           //r2,4,4 r3,4,5 r4,5,4
       }
       if (level > 4) {
           //puts r5 at 8,9
           piecePosition[8][9] = "red";
           movePiece(8, 9, 8, 9);
           //puts r6 at 9,8
           piecePosition[9][8] = "red";
           movePiece(9, 8, 9, 8);
           //puts r7 at 8,8
           piecePosition[8][8] = "red";
           movePiece(8, 8, 8, 8);
           //puts r8 at 6,4
           piecePosition[6][4] = "red";
           movePiece(6, 4, 6, 4);
           //p,0,0 g,9,9 w1,5,5 w2,3,6 w3,5,2 r1,7,7
           //r2,4,4 r3,4,5 r4,5,4 r5,8,9 r6,9,8
           //r7,8,8 r8,6,4
       }
       if (level > 5) {
           //puts w4 at 3,5
           piecePosition[3][5] = "white";
           movePiece(3, 5, 3, 5);
           //puts w5 at 7,2
           piecePosition[7][2] = "white";
           movePiece(7, 2, 7, 2);
           //puts w6 at 8,4
           piecePosition[8][4] = "white";
           movePiece(8, 4, 8, 4);
           //moves r7 to 7,4
           movePiece(8, 8, 7, 4);
           //moves r4 to 3,7
           movePiece(5, 4, 3, 7);
           //p,0,0 g,9,9 w1,5,5 w2,3,6 w3,5,2 r1,7,7
           //r2,4,4 r3,4,5 r4,3,7 r5,8,9 r6,9,8
           //r7,7,4 r8,6,4 w4,3,5 w5,7,2 w6,8,4
       }
       if (level > 6) {
           //moves g to 3,8
           movePiece(9, 9, 3, 8);
           //moves w6 to 7,6
           movePiece(8, 4, 7, 6);
           //moves r5 to 4,7
           movePiece(8, 9, 4, 7);
           //p,0,0 g,3,8 w1,5,5 w2,3,6 w3,5,2 r1,7,7
           //r2,4,4 r3,4,5 r4,3,7 r5,4,7 r6,9,8
           //r7,7,4 r8,6,4 w4,3,5 w5,7,2 w6,7,6
       }
       if (level > 7) {
           //moves player to 0,5
           movePiece(0,0,0,5);
           //moves w5 to 7,2
           movePiece(5,5,7,8);
           //moves r6 to 4,3
           movePiece(9,8,4,3);
           //p,0,5 g,3,8 w1,7,8 w2,3,6 w3,5,2 r1,7,7
           //r2,4,4 r3,4,5 r4,3,7 r5,4,7 r6,4,3
           //r7,7,4 r8,6,4 w4,3,5 w5,7,2 w6,7,6
       }
       if (level > 8) {
           //moves g to 1,5
           movePiece(3,8,1,5);
           //moves w3 to 3,4
           movePiece(5,2,3,4);
           //moves r8 to 6,2
           movePiece(6,4,6,2);
           //p,0,5 g,1,5 w1,7,8 w2,3,6 w3,3,4 r1,7,7
           //r2,4,4 r3,4,5 r4,3,7 r5,4,7 r6,4,3
           //r7,7,4 r8,6,2 w4,3,5 w5,7,2 w6,7,6
       }
       if (level > 9)
       {
           //moves r4 to 3,3
           movePiece(3,7,3,3);
           //moves w2 to 8,2
           movePiece(3,6,8,4);
           piecePosition[9][9]="cyan";
           movePiece(9,9,7,5);
           //p,0,5 g,1,5 w1,7,8 w2,8,2 w3,3,4 r1,7,7
           //r2,4,4 r3,4,5 r4,3,3 r5,4,7 r6,4,3
           //r7,7,4 r8,6,2 w4,3,5 w5,7,2 w6,7,6
           //c1,7,5
       }
       if(level>10)
       {
           //moves r3 to 2,2
           movePiece(4,5,2,2);
           //moves r1 to 3,7
           movePiece(7,7,3,7);
           //moves r8 to 0,9
           movePiece(6,2, 0,9);
           //makes a new cyan pieces
           piecePosition[4][7]="cyan";
           movePiece(4,7,randX,randY);
           piecePosition [3][3]="cyan";
           movePiece(3,3,3,3);
           //p,0,5 g,1,5 w1,7,8 w2,8,2 w3,3,4 r1,3,7
           //r2,4,4 r3,2,2 r5,4,7 r6,4,3
           //r7,7,4 r8,0,9 w4,3,5 w5,7,2 w6,7,6
           //c1,7,5 c2,4,7 c3,6,2 c4,3,3

       }
       if(level>11)
       {
           //moves w2 to 2,3
            movePiece(8,2,2,3);
           //moves r8 to 6,4
            movePiece(0,9,6,4);
            //moves r7 to 2,4
            movePiece(7,4,2,2);
            //moves w4 to 6,8
            movePiece(3,5,6,8);
           //p,0,5 g,1,5 w1,7,8 w2,2,3 w3,3,4 r1,3,7
           //r2,4,4 r3,2,2 r5,4,7 r6,4,3
           //r7,2,4 r8,6,4 w4,6,8 w5,7,2 w6,7,6
           //c1,7,5 c2,4,7 c3,6,2 c4,3,3
       }
       if(level>12)
       {
           //makes the entire board empty
           for (int i = 0; i < 9; i++) {

               randX = ((int) (Math.random() * 9));
               randY = ((int) (Math.random() * 9));
               for (int j = 0; j < 9; j++) {
                   piecePosition[i][j] = "empty";
                   playerField.removePeg(i,j);
               }
           }
           int lastX,lastY;
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);


           piecePosition[4][8]="cyan";
           movePiece(4,8,randX,randY);

           piecePosition[8][5]="cyan";
           movePiece(8,5,8,5);

           piecePosition[5][8]="cyan";
           movePiece(5,8,5,8);

           piecePosition[0][5] = "yellow";
           movePiece(0, 5, 0, 5);
           //puts the goal at 9,9
           piecePosition[9][9] = "green";
           movePiece(9, 9, 9, 9);

       }
       if(level>15)
       {
           //makes the entire board empty
           for (int i = 0; i < 9; i++) {

               randX = ((int) (Math.random() * 9));
               randY = ((int) (Math.random() * 9));
               for (int j = 0; j < 9; j++) {
                   piecePosition[i][j] = "empty";
               }
           }
           int lastX,lastY;
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);


           piecePosition[4][8]="cyan";
           movePiece(4,8,randX,randY);

           piecePosition[8][5]="cyan";
           movePiece(8,5,8,5);

           piecePosition[5][8]="cyan";
           movePiece(5,8,5,8);

           piecePosition[0][5] = "yellow";
           movePiece(0, 5, 0, 5);
           //puts the goal at 9,9
           piecePosition[9][9] = "green";
           movePiece(9, 9, 9, 9);
       }
        if(points>250)
        {
            //makes the entire board empty
           for (int i = 0; i < 9; i++) {

               randX = ((int) (Math.random() * 9));
               randY = ((int) (Math.random() * 9));
               for (int j = 0; j < 9; j++) {
                   piecePosition[i][j] = "empty";
               }
           }
           int lastX,lastY;
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
            
           piecePosition[5][8]="cyan";
           movePiece(5,8,5,8);
           
           piecePosition[0][5] = "yellow";
           movePiece(0, 5, 0, 5);
           //puts the goal at 9,9
           piecePosition[9][9] = "green";
           movePiece(9, 9, 9, 9);
            
        }
        if(points>500)
        {
            //makes the entire board empty
           for (int i = 0; i < 9; i++) {

               randX = ((int) (Math.random() * 9));
               randY = ((int) (Math.random() * 9));
               for (int j = 0; j < 9; j++) {
                   piecePosition[i][j] = "empty";
               }
           }
           int lastX,lastY;
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
        }
        if(points>750)
        {
            //makes the entire board empty
           for (int i = 0; i < 9; i++) {

               randX = ((int) (Math.random() * 9));
               randY = ((int) (Math.random() * 9));
               for (int j = 0; j < 9; j++) {
                   piecePosition[i][j] = "empty";
               }
           }
           int lastX,lastY;
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
        }
        if(points>900)
        {
            //makes the entire board empty
           for (int i = 0; i < 9; i++) {

               randX = ((int) (Math.random() * 9));
               randY = ((int) (Math.random() * 9));
               for (int j = 0; j < 9; j++) {
                   piecePosition[i][j] = "empty";
               }
           }
           int lastX,lastY;
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
        }
        if(points>990)
        {
            //makes the entire board empty
           for (int i = 0; i < 9; i++) {

               randX = ((int) (Math.random() * 9));
               randY = ((int) (Math.random() * 9));
               for (int j = 0; j < 9; j++) {
                   piecePosition[i][j] = "empty";
               }
           }
           int lastX,lastY;
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);

           piecePosition[lastX][lastY]="red";
           movePiece(lastX,lastY,lastX,lastY);
           lastX=(int)(Math.random()*9);
           lastY=(int)(Math.random()*9);
        }
       if(points ==1000)
       {


           Board winText = new Board (11,11);
           winText.putPeg("black" ,10,1);
           winText.putPeg("black" ,9,1);
           winText.putPeg("black" ,10,3);
           winText.putPeg("black" ,9,3);
           winText.putPeg("black" ,8,4);
           winText.putPeg("black" ,7,4);
           winText.putPeg("black" ,8,2);
           winText.putPeg("black" ,7,2);
           winText.putPeg("black" ,8,0);
           winText.putPeg("black" ,7,0);
           winText.putPeg("black" ,7,6);
           winText.putPeg("black" ,8,6);
           winText.putPeg("black" ,8,6);
           winText.putPeg("black" ,9,6);
           winText.putPeg("black" ,10,6);
           winText.putPeg("black" ,10,8);
           winText.putPeg("black" ,9,8);
           winText.putPeg("black" ,8,8);
           winText.putPeg("black" ,7,8);
           winText.putPeg("black" ,7,10);
           winText.putPeg("black" ,8,10);
           winText.putPeg("black" ,9,10);
           winText.putPeg("black" ,10,10);
           winText.putPeg("black" ,9,9);
           winText.putPeg("black" ,8,9);
           winText.putPeg("black" ,0,10);
           winText.putPeg("black" ,1,10);
           winText.putPeg("black" ,2,10);
           winText.putPeg("black" ,3,9);
           winText.putPeg("black" ,2,8);
           winText.putPeg("black" ,1,8);
           winText.putPeg("black" ,0,8);
           winText.putPeg("black" ,1,6);
           winText.putPeg("black" ,2,6);
           winText.putPeg("black" ,0,2);
           winText.putPeg("black" ,1,1);
           winText.putPeg("black" ,2,1);
           winText.putPeg("black" ,0,0);
           winText.putPeg("black" ,0,5);
           winText.putPeg("black" ,0,4);
           winText.putPeg("black" ,1,3);
           winText.putPeg("black" ,2,3);
           winText.putPeg("black" ,3,4);
           winText.putPeg("black" ,3,5);
           winText.putPeg("black" ,3,1);
       }

    }
    //if the player hits a red piece
    public static void redHit()
    {
       //player loses 5 points
      points-=5;

   }
    //all the levels, used because i couldn't call the main method
    public static void allLevel(){
        levelUp=false;
        //calls the board setup method
        boardSetup();
        //sets the starting player location from which you can click
        if(level<8)
        {
            //first 8 levels has the player at origin
            row=0;
            col=0;
        }
        else
        {
            //player gets moved
            row=0;
            col=5;
        }
        //calls the coordinate variable and calls it clickspot
        Coordinate clickSpot;
        //loop for running the game
        boolean gameOver = false;
        while(!gameOver)
        {
            //registers the click
            clickSpot =playerField.getClick();
            //gets the x and y values
            int xClick = clickSpot.getRow();
            int yClick = clickSpot.getCol();
            //if the click is within two spaces of the player
            if(xClick-row<3&&(yClick-col)<3)
            {
                //check if there are any pieces on the spot and act accordingly
                moveCheck(xClick,yClick);
                //moves the piece
                movePiece(row,col,xClick,yClick);
                //makes the row and column values the current one
                row=xClick;
                col=yClick;
                //player loses a point per move
                points--;
                //outputs how many points are left
                String outPoints = String.valueOf(points);
                playerField.displayMessage(level +" "+ outPoints);
                //finds the end point for the level to advance
               if(levelUp==true)
               {
                   allLevel();
               }
            }
            //game ends if there are no points
            if(points<0)
            {
                playerField.displayMessage("GAME OVER");
                gameOver=true;
            }
        }
    }

    static void getCoordinates()
    {
        Coordinate clickSpot;
        while(true)
        {
            clickSpot = playerField.getClick();
            //gets the x and y values
            int xClick = clickSpot.getRow();
            int yClick = clickSpot.getCol();
            playerField.putPeg("black",xClick,yClick);
            System.out.println("playerField.putPeg(\"red\","+xClick+","+yClick+");");
        }
    }
    public static void main(String[] args)
    {
      allLevel();
      //getCoordinates();

   }
}
