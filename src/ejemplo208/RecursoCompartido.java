

package ejemplo208;

public class RecursoCompartido {
    
    private boolean flagWinner = false; //True  = someone has arrived
    private String nameWinner = "";

    public synchronized boolean isFlagWinner() {
        return flagWinner;
    }

    public synchronized void setFlagWinner(boolean flagWinner) {
        this.flagWinner = flagWinner;
    }

    public String getNameWinner() {
        return nameWinner;
    }

    public synchronized void setNameWinner(String nameWinner) {
        if (!isFlagWinner()) {
            this.nameWinner = nameWinner;
            flagWinner = true;
            System.out.println("El ganador es: " + nameWinner); /// muestra el ganador
        }else{
            System.out.println("soy "+nameWinner+" Y perdi"); /// el que perdio
        }
        
    }
}
