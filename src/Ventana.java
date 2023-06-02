import javax.swing.*;

public class Ventana extends JFrame
{
    private JPanel panel1;
    private JTable table1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public Ventana()
    {
        super("Gestion de la tienda");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
