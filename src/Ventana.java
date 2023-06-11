import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ventana extends JFrame
{
    private JPanel panel1;
    private JTabbedPane tabbedPane2;
    private JComboBox CBmarca;
    private JTextField TFdesProducto;
    private JButton BagregarProducto,BlimpiarProducto, BlimpiarMarca, BagregarMarca;
    private JTextField TFnomMarca;
    private JTabbedPane tabbedPane3;
    private JButton button1;
    private JButton facturasButton;
    private JButton totalDeVentasButton;
    private JTable table1;
    private JTextField TFidMarca;
    private JTextField TFidProducto;
    private JTextField TFprecioDelProducto;
    private JLabel LprecioDelProducto;
    private ArbolBinario ABproductos = new ArbolBinario(), ABmarcas = new ArbolBinario();
    private Map<String, Integer> DICmarcas = new HashMap<>();
    private int precio;


    public Ventana()
    {
        super("Gestion de la tienda");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BlimpiarProducto.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TFidProducto.setText("");
                TFdesProducto.setText("");
            }
        });
        //Agrega un producto
        BagregarProducto.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //comprueba si la id es un numero
                try
                {
                    //comprueba si la id no esta en uso, si el nombre es valido y si hay una marca seleccionada
                    String n = TFidProducto.getText();
                    int k = Integer.valueOf(n);
                    if (!(ABproductos.buscar(k)) && !(TFdesProducto.getText().trim().equals("")) && (CBmarca.getItemCount() > 0))
                    {
                        ArrayList<Object> array = new ArrayList<>();
                        array.add(DICmarcas.get(CBmarca.getSelectedItem()));
                        array.add(TFprecioDelProducto.getText());
                        array.add(TFdesProducto.getText());
                        ABproductos.insertar(k,array);
                        ABproductos.imprimirEnOrden();

                        if(TFprecioDelProducto.getText().trim().equals(""))
                    {
                        TFprecioDelProducto.setText("0");
                    }
                    } else if (TFdesProducto.getText().trim().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Porfavor introduzca un nombre valido");
                    } else if (ABproductos.buscar(k))
                    {
                        JOptionPane.showMessageDialog(null, "La id indicada ya esta en uso");
                    } else if (CBmarca.getItemCount() == 0)
                    {
                        JOptionPane.showMessageDialog(null, "Crea una marca primero");
                    }
                }catch (NumberFormatException r)
                {
                    JOptionPane.showMessageDialog(null, "Porfavor introduzca un numero");
                }

            }
        });
        BlimpiarMarca.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TFidMarca.setText("");
                TFnomMarca.setText("");
            }
        });
        BagregarMarca.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //comprueba si la id es un numero
                try
                {
                    //comprueba si la id no esta en uso y si el nombre es valido
                    String n = TFidMarca.getText();
                    int k = Integer.valueOf(n);
                    if (!(ABmarcas.buscar(k)) && !(TFnomMarca.getText().trim().equals("")))
                    {
                        ABmarcas.insertar(k,TFnomMarca.getText());
                        CBmarca.addItem(TFnomMarca.getText());
                        DICmarcas.put(TFnomMarca.getText(), k);
                    } else if (TFnomMarca.getText().trim().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Porfavor introduzca un nombre valido");
                    } else if (ABmarcas.buscar(k))
                    {
                        JOptionPane.showMessageDialog(null, "La id indicada ya esta en uso");
                    }
                }catch (NumberFormatException r)
                {
                    JOptionPane.showMessageDialog(null, "Porfavor introduzca un numero");
                }
            }
        });
    }
}
