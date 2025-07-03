import javax.swing.*;
import java.awt.*; 

public class CaisTharla extends inimigos {
    public CaisTharla() {
        this.nome = "CaisTharla";
        this.tipo = "Matemático";
        this.vida = 140;
        this.ataque = 50;
        this.defesa = 100;
        this.imagemfrente = new ImageIcon("Sprints/" + nome + ".png");
        imagemderrotado = new ImageIcon("Sprints/" + nome + "PB.png");
        imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));

        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        this.label = new JLabel(imagemfrente);

        this.velocidadedosataques[0] = 40; 
        this.velocidadedosataques[1] = 30; 
        this.velocidadedosataques[2] = 50;
        this.velocidadedosataques[3] = 0;

        this.poderdosataques[0] = 60;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 50;
        this.poderdosataques[3] = 0;
    }
}

