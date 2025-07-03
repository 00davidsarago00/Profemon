import javax.swing.*;
import java.awt.*; 

public class Cherries extends inimigos {
    public Cherries() {
        this.nome = "Cherrys";
        this.tipo = "Programador";
        this.vida = 65;
        this.ataque = 95;
        this.defesa = 60;
        this.imagemfrente = new ImageIcon("Sprints/" + nome + ".png");
        imagemderrotado = new ImageIcon("Sprints/" + nome + "PB.png");
        imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));

        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente);

        this.velocidadedosataques[0] = 95; 
        this.velocidadedosataques[1] = 85; 
        this.velocidadedosataques[2] = 0;
        this.velocidadedosataques[3] = 0;

        this.poderdosataques[0] = 30;
        this.poderdosataques[1] = 35;
        this.poderdosataques[2] = 0;
        this.poderdosataques[3] = 0;

    }

}

