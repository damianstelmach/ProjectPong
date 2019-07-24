import javax.swing.*;

public class Main {


    public static void main (String [] args)
    {
        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();

        obj.setTitle("PandaPong");
        obj.setBounds(10,10,700,600);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        obj.add(gameplay);

    }
}
