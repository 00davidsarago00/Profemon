import javax.swing.*;
import java.awt.*;  


public class LH extends profemon {
    public LH() {
        this.nome = "LH";
        this.tipo = "Matemático";
        this.ataque = 20;
        this.vida = 100;
        this.nivel = 1;
        imagem = new ImageIcon("Sprints/" + nome + nivel + ".png");
        this.vidamaxima = 100;
        imagem = new ImageIcon(imagem.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        this.label = new JLabel(imagem);
        this.evolucao = 1;
        this.velocidadedosataques[0] = 10; 
        this.velocidadedosataques[1] = 15; 
        this.velocidadedosataques[2] = 20;
        this.velocidadedosataques[3] = 25;     
    }
    @Override
    public void run() {

    }
}

    
