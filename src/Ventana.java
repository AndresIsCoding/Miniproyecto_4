import javax.swing.*;

public class Ventana extends JFrame
{
    private JPanel panel1;
    private JTabbedPane tabbedPane2;
    private JComboBox CBmarca;
    private JTextField TFproducto;
    private JButton agregarButton;
    private JButton limpiarButton;
    private JTextField textField1;
    private JTabbedPane tabbedPane3;
    private JButton button1;
    private JButton facturasButton;
    private JButton totalDeVentasButton;
    private JTable table1;

    public Ventana()
    {
        super("Gestion de la tienda");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
