package my;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel panel1;
    private JButton LOGINButton;
    private JTextField jtuser;
    private JTextField jpassword;

    private  JFrame frame;

//login constructor
    public  Login() {

        JFrame frame = new JFrame("User Login Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550,300));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jtuser.getText().equals("")){

                    JOptionPane.showMessageDialog(null, "Please Fill out Username");
                }
                else if (jpassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Fill out Password");
                }
//login code
                else if (jtuser.getText().contains("rgit")&& jpassword.getText().contains("rgit123")) {
                   JOptionPane.showMessageDialog(null, "Login Successful");
                    new CV().setVisible();
                     //setVisible(False);

                }

                //end of login
                else{

                    JOptionPane.showMessageDialog(null, "Wrong username or password!!!","Message",JOptionPane.ERROR_MESSAGE);

                }








            }
        });
    }

    private void disable() {



    }


}
