import java.util.*;

public class GameLogic {
    Tile[][] board;
    int[][] directions=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

    public GameLogic(){
        setGame();

    }

    private void setGame() {
        board=new Tile[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                board[i][j]=new Tile(0);
            }
        }
        generateTile();
        generateTile();
    }

    private void generateTile() {
        List<int[]> positions=new ArrayList<>();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j].is_empty()){
                    positions.add(new int[]{i,j});
                }
            }
        }
        if(!positions.isEmpty()){
            Random r=new Random();
            int[] pos=positions.get(r.nextInt(positions.size()));
            board[pos[0]][pos[1]].setValue(r.nextDouble()<0.9?2:4);
        }
    }

    public void startGame() {
        Scanner input=new Scanner(System.in);
        while(inGamePlay()){
            System.out.print("ENTER a char:");
            String move=input.next();
            switch (move){
                case "A": case "a": moveLeft(); break;
                case "W": case "w": moveUp();   break;
                case "S": case "s": moveDown(); break;
                case "D": case "d": moveRight();     break;
            }
            generateTile();
            display();
        }
    }

    private void moveRight() {
    }

    private void moveUp() {
    }

    private void moveDown() {
        gravityDown();
        gravityDown();
    }
    public  void gravityDown(){
        for(int j=3;j>-1;j--){
            ArrayList<Integer> theRow=new ArrayList<>();
            for(int i=0;i<4;i++){
                if(!board[i][j].is_empty()){
                    theRow.add(board[i][j].getValue());
                }
            }
            for(int i=0;i<4;i++){
                if(!theRow.isEmpty()){
                    board[i][j].setValue(theRow.removeFirst());
                }
            }
        }
    }

    private void moveLeft() {

    }

    private boolean inGamePlay() {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j].is_empty()){
                    return true;
                }
                for(int[] d:directions){
                    int nx=i+d[0],ny=j+d[1];
                    if(nx<0||ny<0||nx>=4||ny>=4){
                        continue;
                    }
                    else{
                        if(board[i][j].getValue()==board[nx][ny].getValue()){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void display(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(board[i][j].getValue());
            }
            System.out.println();
        }
    }
}
