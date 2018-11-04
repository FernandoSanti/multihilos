

package ejemplo208;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Corredor implements Runnable {
    
    private int ancho = 0;

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    JLabel label;
    private RecursoCompartido recursoCompartido;
    
    @Override
    public void run() {
        int vueltas = 0;
        Random r = new Random(System.nanoTime());
        int avance = 0;
        while (vueltas++ <ancho) {
            if (recursoCompartido.isFlagWinner()) {
                break;
            }
            if (r.nextInt(100) < 50) {
                avance++;
            } else {
                avance +=0;
            }
            label.setLocation(vueltas, label.getY());
            try {
                Thread.sleep(10 + r.nextInt(100));
            } catch (InterruptedException ex) {
            }
        }
        recursoCompartido.setNameWinner(label.getText());
        JOptionPane.showMessageDialog(null, "ganador: " + label.getText());
        label.setLocation(30, 25);
    }

    public Corredor(JLabel label) {
        this.label = label;
    }
    
    public Corredor(JLabel label, RecursoCompartido recursoCompartido,int ancho) {
        this(label);
        this.ancho = ancho;
        this.recursoCompartido = recursoCompartido;
    }
    
    public RecursoCompartido getRecursoCompartido() {
        return recursoCompartido;
    }

    public void setRecursoCompartido(RecursoCompartido recursoCompartido) {
        this.recursoCompartido = recursoCompartido;
    }
    
}
