import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class VentanaPrincipal extends JFrame {

    private final int FILAS = 6;
    private final int COLUMNAS = 6;
    private final int MINAS = 5;

    private JButton[][] botones = new JButton[FILAS][COLUMNAS];
    private boolean[][] minas = new boolean[FILAS][COLUMNAS];
    private boolean[][] abiertas = new boolean[FILAS][COLUMNAS];

    private int casillasSeguras;

    public VentanaPrincipal() {

        setTitle("Buscaminas");
        setSize(450,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(FILAS,COLUMNAS));

        colocarMinas();

        casillasSeguras = FILAS * COLUMNAS - MINAS;

        for(int i=0;i<FILAS;i++){

            for(int j=0;j<COLUMNAS;j++){

                JButton boton = new JButton();

                botones[i][j]=boton;

                final int f=i;
                final int c=j;

                boton.addActionListener(e->abrir(f,c));

                panel.add(boton);

            }

        }

        add(panel);

        setVisible(true);

    }

    private void colocarMinas() {

        Random r = new Random();

        int contador=0;

        while(contador<MINAS){

            int f=r.nextInt(FILAS);
            int c=r.nextInt(COLUMNAS);

            if(!minas[f][c]){
                minas[f][c]=true;
                contador++;
            }
        }
    }

    private void abrir(int f, int c) {

        if(abiertas[f][c])
            return;

        abiertas[f][c]=true;

        JButton b = botones[f][c];

        if(minas[f][c]){

            b.setText("X");
            mostrarMinas();

            JOptionPane.showMessageDialog(this,"GAME OVER");
            desactivar();

            return;
        }
        int numero=contarMinas(f,c);

        b.setText(String.valueOf(numero));
        b.setEnabled(false);

        casillasSeguras--;
        if(casillasSeguras==0){
            JOptionPane.showMessageDialog(this,"¡GANASTE!");

            desactivar();
        }
    }

    private int contarMinas(int f, int c) {
        int total =0;

        for(int i=f-1;i<=f+1;i++){
            for(int j=c-1;j<=c+1;j++){
                if(i>=0 && i<FILAS && j>=0 && j<COLUMNAS){

                    if(minas[i][j])
                        total++;
                }
            }
        }
        return total;
    }

    private void mostrarMinas() {

        for(int i=0;i<FILAS;i++){
            for(int j=0;j<COLUMNAS;j++){

                if(minas[i][j]){
                    botones[i][j].setText("X");
                }
            }
        }
    }

    private void desactivar() {
        for (int i=0;i<FILAS;i++){
            for(int j=0;j<COLUMNAS;j++){
                botones[i][j].setEnabled(false);
            }
        }
    }   
}
