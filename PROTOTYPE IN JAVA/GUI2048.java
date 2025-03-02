import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI2048 extends JFrame implements KeyListener {
    GameLogic game;
    JPanel boardPanel,top;
    JLabel[][] tiles;
    JLabel message;
    JButton button;

    public GUI2048() {
        game=new GameLogic();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("2048");
        setLayout(new BorderLayout());
        setSize(500,500);
        setLocationRelativeTo(null);

        top=new JPanel(new GridLayout(1,2));
        message=new JLabel("2048");
        top.add(message);

        JPanel left=new JPanel();
        left.setLayout(new FlowLayout(FlowLayout.RIGHT));

        button=new JButton("RESTART");
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI2048();
                dispose();
            }
        });

        left.add(button);
        top.add(left);

        add(top,BorderLayout.NORTH);

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

        addKeyListener(this);

        startGame();
    }
    private void startGame(){
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

                tiles[i][j].revalidate();
                tiles[i][j].repaint();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar()+" "+e.getKeyCode());
        Tile[][] copy=copyBoard();
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_UP || key==KeyEvent.VK_DOWN || key==KeyEvent.VK_LEFT || key==KeyEvent.VK_RIGHT ) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> game.moveUp();
                case KeyEvent.VK_DOWN -> game.moveDown();
                case KeyEvent.VK_LEFT -> game.moveLeft();
                case KeyEvent.VK_RIGHT -> game.moveRight();
                default -> System.out.println();
            }
            if(!boardsAreEqual(copy,game.board)){
                game.generateTile();
            }
            displayBoard();
            if(winner()){
                message.setText("You have won 2048✨!");
                JOptionPane.showMessageDialog(this,"<html><div " +
                        "style='text-align:center;" +
                        "font-size:16px; color:#6A1B9A;'><b>CONGRATULATIONS!</b><br></div>🎉" +
                        "You have won the game!🏆</html>");
                removeKeyListener(this);
            }
            if(!game.inGamePlay()){
                //System.out.println("CHECKPOINT:You have lost!!");
                message.setText("You have Lost!!");
                JOptionPane.showMessageDialog(this,"<html><div " +
                        "style='text-align:center;" +
                        "font-size:16px; color:#6A1B9A;'><b>Train harder!</b><br></div>" +
                        "</html>");
                removeKeyListener(this);
            }
        }
    }

    private boolean winner() {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(game.board[i][j].getValue()==2048){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean boardsAreEqual(Tile[][] copy, Tile[][] board) {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(copy[i][j].getValue()!=board[i][j].getValue()){
                    return false;
                }
            }
        }
        return true;
    }

    private Tile[][] copyBoard() {
        Tile[][] copy=new Tile[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                copy[i][j]=new Tile(game.board[i][j].getValue());
            }
        }
        return copy;
    }

}
