import javax.swing.*;
import java.awt.*;

public class GUI2048 extends JFrame {
    GameLogic game;
    JPanel boardPanel;
    JLabel[][] tiles;
    JLabel message;
    public GUI2048() {
        game=new GameLogic();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("2048");
        setLayout(new BorderLayout());
        setSize(500,500);
        setLocationRelativeTo(null);

        message=new JLabel("2048");
        add(message,BorderLayout.NORTH);

        boardPanel=new JPanel(new GridLayout(4,4,4,4));
        tiles=new JLabel[4][4];

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                tiles[i][j]=new JLabel("");
                tiles[i][j].setBackground(new Color(131, 125, 125, 226));
                tiles[i][j].setOpaque(true);
                boardPanel.add(tiles[i][j]);
            }
        }
        add(boardPanel,BorderLayout.CENTER);
        displayBoard();

        setVisible(true);

        startGame();
    }
    private void startGame(){
        game.startGame();
        displayBoard();
    }

    private void displayBoard() {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int val=game.board[i][j].getValue();
                tiles[i][j].setText(val==0?"":String.valueOf(val));
                tiles[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                tiles[i][j].setFont(new Font("Arial",Font.BOLD,30));
                tiles[i][j].setBackground(game.board[i][j].getColor(val));
            }
        }

    }
}
