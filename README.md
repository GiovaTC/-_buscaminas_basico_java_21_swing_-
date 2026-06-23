# -_buscaminas_basico_java_21_swing_- :.
# Buscaminas:

<img width="1254" height="1254" alt="image" src="https://github.com/user-attachments/assets/86fa5cf0-e2cd-4cf0-af14-d222b823eb09" />  

```

## Proyecto Java 21 + Swing:

Proyecto básico desarrollado utilizando **Java 21** y **Swing**, implementado únicamente con **dos archivos Java**. El objetivo es mostrar
un ejemplo sencillo de programación orientada a objetos e interfaces gráficas para estudiantes que comienzan con Java SE .

---

# Características

- Java 21
- Swing
- Tablero de 6 × 6
- 5 minas colocadas aleatoriamente
- Descubrimiento de casillas mediante clic
- Finaliza al encontrar una mina
- Victoria al descubrir todas las casillas seguras
- Proyecto compacto y fácil de comprender

---

# Estructura del proyecto

```text
Buscaminas
│
├── Main.java
│
└── VentanaPrincipal.java
```

---

# Main.java

```java
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal();
        });

    }

}
```

---

# VentanaPrincipal.java

```java
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

    private void colocarMinas(){

        Random r=new Random();

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

    private void abrir(int f,int c){

        if(abiertas[f][c])
            return;

        abiertas[f][c]=true;

        JButton b=botones[f][c];

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

    private int contarMinas(int f,int c){

        int total=0;

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

    private void mostrarMinas(){

        for(int i=0;i<FILAS;i++){

            for(int j=0;j<COLUMNAS;j++){

                if(minas[i][j]){

                    botones[i][j].setText("X");

                }

            }

        }

    }

    private void desactivar(){

        for(int i=0;i<FILAS;i++){

            for(int j=0;j<COLUMNAS;j++){

                botones[i][j].setEnabled(false);

            }

        }

    }

}
```

---

```

# Funcionamiento

1. Al iniciar el programa se crea un tablero de **6 × 6**.
2. Se colocan **5 minas** en posiciones aleatorias.
3. El usuario hace clic sobre una casilla.

- Si contiene una mina:
  - Se muestra una **X**.
  - Se revelan todas las minas.
  - Finaliza la partida con el mensaje **GAME OVER**.

- Si no contiene una mina:
  - Se calcula el número de minas adyacentes.
  - Se muestra dicho número.
  - La casilla queda deshabilitada.

4. Cuando todas las casillas seguras han sido descubiertas aparece el mensaje:

```
```text
¡GANASTE!
```
---

```

# Ejecución

1. Crear un proyecto Java.
2. Agregar los dos archivos:

- `Main.java`
- `VentanaPrincipal.java`

3. Ejecutar:
```
```text
Main.java
```
---
# Conceptos aplicados:
- Java 21
- Swing
- JFrame
- JPanel
- JButton
- GridLayout
- ActionListener (expresiones lambda)
- Arreglos bidimensionales
- Programación orientada a objetos
- Generación de números aleatorios
- Eventos gráficos
---
# Posibles mejoras
Este proyecto fue diseñado como un ejemplo introductorio. Algunas mejoras que pueden implementarse posteriormente son:
- Descubrimiento automático de zonas vacías.
- Banderas para marcar minas.
- Colores diferentes para cada número.
- Contador de minas restantes.
- Temporizador.
- Botón para reiniciar la partida.
- Selección del nivel de dificultad.
- Diferentes tamaños de tablero.
- Iconos e imágenes para las minas.
- Menú principal.
---
# Autor
Proyecto de ejemplo desarrollado con **Java 21 + Swing**, pensado como material didáctico para estudiantes 
que comienzan con el desarrollo de aplicaciones de escritorio utilizando Java SE .
:. . / .
