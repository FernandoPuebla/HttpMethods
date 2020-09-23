import com.google.gson.Gson;
import javax.swing.*;
import java.io.InputStreamReader;
import java.net.URL;
import javax.xml.bind.JAXB;



public class WelcomeRESTJSONClientJFrame extends javax.swing.JFrame{

    public WelcomeRESTJSONClientJFrame(){
        //initComponents();
    }

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt){
        String name = nameJTextField.getText();

        try {
            String url = "https://localhost:8080/welcomeRESTJSON/" + "webservices/welcome/" + name;

            InputStreamReader reader = new InputStreamReader(new URL(url).openStream());

            WelcomeRESTJSONResource.TextMessage message = new Gson().fromJson(reader, WelcomeRESTJSONResource.TextMessage.class);

            JOptionPane.showMessageDialog(this,message.getMessage());

        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        new WelcomeRESTJSONClientJFrame().setVisible(true);
                    }
                }
        );
    }

    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JButton submitJButton;

}

class TextMessage{
    private String message;

    public String getMessage(){
        return message;
    }
}


