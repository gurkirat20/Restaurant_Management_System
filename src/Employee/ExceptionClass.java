package Employee;

import javax.swing.*;

public class ExceptionClass extends Exception {

    String msg;

    /***** Constructors *****/
    public ExceptionClass() {}
    public ExceptionClass(String msg) {
        this.msg = msg;
    }

    /***** method to show message *****/
    public void showMessage() {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, msg);
    }

}
