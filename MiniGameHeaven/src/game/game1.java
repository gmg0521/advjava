package game;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game1 extends JFrame implements KeyListener {

   public static void main(String args[]) {
      new game1();
   }

   Font font = new Font("바탕", Font.BOLD, 30);
   Random r = new Random();
   int combo = 0;
   int rand;
   int i1 = 0, i2 = 0, i3 = 0;
   int cursor = 1;
   boolean[] arrowcursor = { false, true, false };
   private JLabel t1, t2, t3, randLabel, score; // 텍스트창을 표시하는 t1

   private ImageIcon Combo0 = new ImageIcon(Main.class.getResource("../images/Combo0.jpg"));
   private JLabel effectcombo0 = new JLabel();
   private ImageIcon Combo1 = new ImageIcon(Main.class.getResource("../images/Combo1.jpg"));
   private JLabel effectcombo1 = new JLabel();
   private ImageIcon Combo2 = new ImageIcon(Main.class.getResource("../images/Combo2.jpg"));
   private JLabel effectcombo2 = new JLabel();
   private ImageIcon No = new ImageIcon(Main.class.getResource("../images/No.jpg"));
   private JLabel effectNo = new JLabel();
   private ImageIcon Arrow1 = new ImageIcon(Main.class.getResource("../images/arrow.png"));
   private JLabel arrow1 = new JLabel();
   private ImageIcon Arrow2 = new ImageIcon(Main.class.getResource("../images/arrow.png"));
   private JLabel arrow2 = new JLabel();
   private ImageIcon Arrow3 = new ImageIcon(Main.class.getResource("../images/arrow.png"));
   private JLabel arrow3 = new JLabel();

   public game1() {

      setTitle("jamul");
      setSize(Main.SCREEN_HEIGHT, Main.SCREEN_WIDTH);
      setResizable(true);
      setLocationRelativeTo(null);
      getContentPane().setLayout(new GridLayout(2, 0));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

      t1 = new JLabel("0");
      t1.setBounds(36, 5, 20, 35);
      t2 = new JLabel("0");
      t2.setBounds(61, 5, 20, 35);
      t3 = new JLabel("0");
      t3.setBounds(86, 5, 20, 35);
      t1.setFont(font);
      t2.setFont(font);
      t3.setFont(font);

      JPanel sc = new JPanel();
      sc.setLayout(new GridLayout(2, 3));

      JPanel p = new JPanel();
      randLabel = new JLabel();
      setRandLabel();

      effectcombo0.setIcon(Combo0);
      effectcombo1.setIcon(Combo1);
      effectcombo2.setIcon(Combo2);
      effectNo.setIcon(No);
      arrow1.setBounds(33, 36, 20, 20);
      arrow1.setIcon(Arrow1);
      arrow2.setBounds(58, 36, 20, 20);
      arrow2.setIcon(Arrow2);
      arrow3.setBounds(83, 36, 20, 20);
      arrow3.setIcon(Arrow3);

      JPanel showRand = new JPanel();
      score = new JLabel("0");
      score.setFont(new Font("굵은안상수체", Font.PLAIN, 25));
      JPanel scorePanel = new JPanel();
      p.addKeyListener(this);
      p.setLayout(null);
      p.add(t1);
      p.add(t2);
      p.add(t3);
      p.add(arrow1);
      p.add(arrow2);
      p.add(arrow3);

      arrow1.setVisible(arrowcursor[(cursor)%3]);
      arrow2.setVisible(arrowcursor[(cursor+2)%3]);
      arrow3.setVisible(arrowcursor[(cursor+1)%3]);

      getContentPane().add(effectcombo0);
      effectcombo0.setVisible(false);
      getContentPane().add(effectcombo1);
      effectcombo1.setVisible(false);
      getContentPane().add(effectcombo2);
      effectcombo2.setVisible(false);
      getContentPane().add(effectNo);
      effectNo.setVisible(false);

      p.setVisible(true);
      sc.setVisible(true);
      showRand.add(randLabel);
      scorePanel.add(score);
      getContentPane().add(scorePanel);
      getContentPane().add(p);
      getContentPane().add(showRand);
      p.requestFocus();
   }

   private void setRandLabel() {
      rand = r.nextInt(999);
      if (rand < 100) {
         if (rand < 10)
            randLabel.setText("00" + String.valueOf(rand));
         else
            randLabel.setText("0" + String.valueOf(rand));
      } else
         randLabel.setText(String.valueOf(rand));

   }

   @Override
   public void keyTyped(KeyEvent e) {

   }

   @Override
   public void keyPressed(KeyEvent e) {

   }

   @Override
   public void keyReleased(KeyEvent e) {

      int key = e.getKeyCode();

      switch (key) {
      
      case KeyEvent.VK_RIGHT:
         cursor++;
         if (cursor >= 4) {
            cursor = 1;
         }
         arrow1.setVisible(arrowcursor[(cursor)%3]);
         arrow2.setVisible(arrowcursor[(cursor+2)%3]);
         arrow3.setVisible(arrowcursor[(cursor+1)%3]);
         break;
      case KeyEvent.VK_UP:
         switch (cursor) {
         case 1:
            i1++;
            if (i1 >= 10)
               i1 = 0;
            t1.setText(String.valueOf(i1));
            break;
         case 2:
            i2++;
            if (i2 >= 10)
               i2 = 0;
            t2.setText(String.valueOf(i2));
            break;
         case 3:
            i3++;
            if (i3 >= 10)
               i3 = 0;
            t3.setText(String.valueOf(i3));
            break;
         }
         break;
   
      case KeyEvent.VK_ENTER:

         StringBuilder sb = new StringBuilder();
         sb.append(t1.getText()).append(t2.getText()).append(t3.getText());
         if (randLabel.getText().equals(sb.toString())) {
            if (combo == 0) {
               Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
               buttonClickedMusic.start();
               Thread c0 = new Thread(new Runnable() {
                  public void run() {
                     try {
                        effectcombo0.setVisible(true);
                        Thread.sleep(400);
                        effectcombo0.setVisible(false);
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                  }
               });
               c0.start();
            } else if (combo == 1) {
               Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
               buttonClickedMusic.start();
               Thread c1 = new Thread(new Runnable() {
                  public void run() {
                     try {
                        effectcombo1.setVisible(true);
                        Thread.sleep(400);
                        effectcombo1.setVisible(false);
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                  }
               });
               c1.start();
            } else {
               Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
               buttonClickedMusic.start();
               Thread c2 = new Thread(new Runnable() {
                  public void run() {
                     try {
                        effectcombo2.setVisible(true);
                        Thread.sleep(400);
                        effectcombo2.setVisible(false);
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                  }
               });
               c2.start();
            }

            score.setText(String.valueOf(Integer.parseInt(score.getText()) + 1));
            combo++;
         } else {
            combo = 0;
            Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
            buttonClickedMusic.start();
            Thread No = new Thread(new Runnable() {
               public void run() {
                  try {
                     effectNo.setVisible(true);
                     Thread.sleep(400);
                     effectNo.setVisible(false);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
               }
            });
            No.start();
         }
         setRandLabel();

      }

      /*
       * private JPanel panel;
       * 
       * private JLabel label;
       * 
       * private JButton button;
       * 
       * public ImageLabelTest(){
       * 
       * this.setTitle("이미지 레이블");
       * 
       * this.setSize(300, 250);
       * 
       * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       * 
       * panel = new JPanel();
       * 
       * label = new JLabel("이미지를 보려면 아래 버튼을 누르세요.");
       * 
       * button = new JButton("이미지 레이블");
       * 
       * ImageIcon icon = new ImageIcon("dog.png");
       * 
       * button.setIcon(icon);
       * 
       * button.addActionListener(this);
       * 
       * panel.add(label);
       * 
       * panel.add(button);
       * 
       * this.add(panel);
       * 
       * this.setVisible(true);
       * 
       * }
       * 
       * @Override
       * 
       * public void actionPerformed(ActionEvent e) {
       * 
       * ImageIcon dog = new ImageIcon("dog2.png");
       * 
       * label.setIcon(dog);
       * 
       * label.setText(null);
       * 
       * }
       * 
       */
   }

}