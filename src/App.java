import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    JTextField location;
    JTextArea input;
    JButton bGo;

    public App(String name){
        super(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout());

        //location = new JTextField();

        input = new JTextArea();
        input.setSize(100,100);
        input.setBorder(BorderFactory.createLineBorder(Color.black));

        bGo = new JButton("Go");
        bGo.addActionListener(this);

        //add(location);
        add(input);
        add(bGo);
    }

    public static void main(String[] args) {
        App frame = new App("Log Writer");
        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bGo){
            String text = input.getText();
            System.err.println(text);
            if(text != ""){
                String[] splitText = text.split("\n");
                new LogWriter(splitText);
            }
        }
    }
}
