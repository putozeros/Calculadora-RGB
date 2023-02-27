import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Ventana extends JFrame {
    private JPanel panel;
    private JLabel etiqueta;
    private JButton b1,b2,b3;
    private int controjo=0,contverde=0,contazul=0;
    private int pulsado=0;
    public Ventana(){
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Ejercicio 3");
        setResizable(false);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        mostrarPanel();
        mostrarEtiqueta();
        mostrarBotones();
    }
    private void mostrarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        eventoRuedaRaton();
    }
    private void mostrarEtiqueta(){
        etiqueta=new JLabel();
        etiqueta.setBounds(100,30,400,50);
        etiqueta.setText("Color: (Rojo, Verde, Azul)");
        etiqueta.setFont(new Font("Arial", Font.PLAIN,20));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiqueta);
    }
    private void mostrarBotones(){
        /*pulsado = 1 -> Rojo
        pulsado = 2 -> Verde
        pulsado = 3 -> Azul*/
        b1=new JButton("Rojo");
        b1.setBounds(50,230,130,50);
        b1.setForeground(Color.RED);
        b1.setFont(new Font("arial rounded mt bold", Font.PLAIN,20));
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado=1;
            }
        });

        b2=new JButton("Verde");
        b2.setBounds(225,230,130,50);
        b2.setForeground(Color.green);
        b2.setFont(new Font("arial rounded mt bold", Font.PLAIN,20));
        panel.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado=2;
            }
        });

        b3=new JButton("Azul");
        b3.setBounds(400,230,130,50);
        b3.setForeground(Color.blue);
        b3.setFont(new Font("arial rounded mt bold", Font.PLAIN,20));
        panel.add(b3);

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado=3;
            }
        });
    }
    private void eventoRuedaRaton(){
        MouseWheelListener rueda=new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(pulsado!=0){
                    if (pulsado==1){
                        controjo += e.getWheelRotation();
                        if(controjo<0){
                            controjo=0;
                        }
                        if(controjo>255){
                            controjo=255;
                        }
                    }
                    else if(pulsado==2){
                        contverde += e.getWheelRotation();
                        if(contverde<0){
                            contverde=0;
                        }
                        if(contverde>255){
                            contverde=255;
                        }
                    }
                    else{
                        contazul += e.getWheelRotation();
                        if(contazul<0){
                            contazul=0;
                        }
                        if(contazul>255){
                            contazul=255;
                        }
                    }
                }
                etiqueta.setText("Color Rojo = "+controjo+", Verde = "+contverde+", Azul = "+contazul);
                panel.setBackground(new Color(controjo,contverde,contazul));
                //El constructor de color tomará en cuenta los tres parametros del espectro RGB automáticamente. BRUTAL.
            }
        };
        panel.addMouseWheelListener(rueda);
    }
}
