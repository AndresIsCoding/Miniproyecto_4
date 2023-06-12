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
    private JTextField TFidMarca;
    private JTextField TFidProducto;
    private JTextField TFprecioDelProducto;
    private JLabel LprecioDelProducto;
    private JButton button1;
    private JButton facturasButton;
    private JButton totalDeVentasButton;
    private JTable table1;
    private JTextField textField2;
    private JButton limpiarButton;
    private JButton crearButton;
    private JComboBox CBdias;
    private JComboBox CBmeses;
    private JComboBox CBano;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JTextField textField1;
    private JSpinner spinner1;
    private JButton limpiarButton1;
    private JButton agregarButton;
    private ArbolBinario ABproductos = new ArbolBinario(), ABmarcas = new ArbolBinario();
    private Map<String, Integer> DICmarcas = new HashMap<>();
    private int precio;

    int [] dias = new int[32];
    int[] meses = new int[13];

    int[] años = new int[2024];

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
        BagregarProducto.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String n = TFidProducto.getText();
                    int k = Integer.valueOf(n);
                    if (!(TFprecioDelProducto.getText().trim().equals(""))) {Integer.valueOf(TFprecioDelProducto.getText());}
                    if (!(ABproductos.buscar(k)) && !(TFdesProducto.getText().trim().equals("")) && (CBmarca.getItemCount() > 0))
                    {
                        ArrayList<Object> array = new ArrayList<>();
                        array.add(DICmarcas.get(CBmarca.getSelectedItem()));
                        ArrayList<Object> array2 = (ArrayList<Object>) ABmarcas.getNodo(DICmarcas.get(CBmarca.getSelectedItem())).datos;
                        ArrayList<Integer> xd = (ArrayList<Integer>) array2.get(1);
                        xd.add(k);
                        if(TFprecioDelProducto.getText().trim().equals(""))
                        {
                            array.add(0);
                        }else
                        {
                            array.add(Integer.valueOf(TFprecioDelProducto.getText()));
                        }
                        array.add(TFdesProducto.getText());
                        ABproductos.insertar(k,array);
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
                        ArrayList<Object> array = new ArrayList<>();
                        array.add(TFnomMarca.getText());
                        ArrayList<Integer> productos = new ArrayList<>();
                        array.add(productos);
                        ABmarcas.insertar(k,array);
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

        CBdias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        for (int i = 1; i <32 ; i++)
        {
            dias[i]=i+1;
            CBdias.addItem(i);

        }

        for (int i = 1; i <13 ; i++)
        {
            meses[i]=i+1;
            CBmeses.addItem(i);

        }

        for (int i = 1900; i <2024 ; i++)
        {
            años[i]=i+1;
            CBano.addItem(i);

        }

    }
}
