import javax.swing.*;
import java.awt.*; 

public class Boss2  extends inimigos {
    public Boss2 () {
        this.nome = "Motor Singular";
        this.tipo = "Engenheiro";
        this.vida = 170;
        this.ataque = 180;
        this.defesa = 100;
        this.imagemfrente = new ImageIcon("Sprints/Boss2.png");
        imagemderrotado = new ImageIcon("Sprints/" + nome + "PB.png");
                imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));

        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        this.label = new JLabel(imagemfrente);

        this.velocidadedosataques[0] = 75; 
        this.velocidadedosataques[1] = 85; 
        this.velocidadedosataques[2] = 60;
        this.velocidadedosataques[3] = 50;

        this.poderdosataques[0] = 90;
        this.poderdosataques[1] = 120;
        this.poderdosataques[2] = 85;
        this.poderdosataques[3] = 150;

    }

}

