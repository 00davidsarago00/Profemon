import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class inimigos extends personagens {

    public synchronized void receberDano(int dano, profemon Autor) {
        this.vida -= dano;
        if (this.vida <= 0) {
            derrotado();
            Autor.EliminouInimigo(2*defesa+dano/100);
        }
    }

    public void derrotado(){
        this.vida = 0;
        this.label.setIcon(imagemderrotado);
        try{
            Thread.sleep(5000); 
            this.label.setVisible(false); 
        }catch (InterruptedException e) {}
        
    } 

}
