import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class inimigos extends personagens implements Runnable {
    int velocidade;

    public synchronized void receberDano(int dano, profemon Autor) {
        this.vida -= dano/this.defesa;
        if (this.vida <= 0) {
            derrotado();
            Autor.EliminouInimigo(20*defesa+dano/100);
        }
    }

    public void derrotado(){

        this.vida = 0;
        velocidade = 0;

        this.label.setIcon(new ImageIcon("Sprints/" + nome + "derrotado.png"));

        try{
            Thread.andar().interrupt();
            Thread.sleep(5000); 
            this.label.setVisible(false); 
        }catch (InterruptedException e) {}
        
    }

    public void andar(){
        //TEM QUE FAZER A LOGICA//  
        //Vetor das posições possíveis
        int x,y;
        while (this.vida > 0) {
            try {
                Thread.sleep(velocidade);
        }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return; // Sai do loop se a thread for interrompida
            }
            // Lógica de movimento do inimigo
            x = this.label.getX() + 10; // Exemplo de movimento para a direita
            y = this.label.getY();
            this.label.setLocation(x, y);
        }
    }   


}