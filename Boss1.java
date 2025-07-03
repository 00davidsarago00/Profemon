import javax.swing.*;
import java.awt.*; 

public class Boss1  extends inimigos {
    public Boss1 () {
        this.nome = "Paradoxo Compilado";
        this.tipo = "Programador";
        this.vida = 200;
        this.ataque = 80;
        this.defesa = 170;
        this.imagemfrente = new ImageIcon("Sprints/Boss1.png");
        imagemderrotado = new ImageIcon("Sprints/" + nome + "PB.png");
        imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));

        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        this.label = new JLabel(imagemfrente);

        this.velocidadedosataques[0] = 60; 
        this.velocidadedosataques[1] = 70; 
        this.velocidadedosataques[2] = 50;
        this.velocidadedosataques[3] = 40;

        this.poderdosataques[0] = 0;
        this.poderdosataques[1] = 70;
        this.poderdosataques[2] = 85;
        this.poderdosataques[3] = 110;

    }

}

