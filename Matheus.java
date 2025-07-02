import javax.swing.*;
import java.awt.*;  


public class Matheus extends profemon {
    public Matheus() {
        this.nome = "Matheus";
        this.tipo = "Engenheiro";
        this.ataque = 70;
        this.vida = 110;
        this.nivel = 1;
        this.defesa = 95;
        this.evolucao = 1;
        this.vidamaxima = 110;
        
        imagemfrente = new ImageIcon("Sprints/" + nome + nivel + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + nivel + "Back" + ".png");
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente); 
        
           
        this.velocidadedosataques[0] = 75; 
        this.velocidadedosataques[1] = 55; 
        this.velocidadedosataques[2] = 60;
        this.velocidadedosataques[3] = 30;

        this.poderdosataques[0] = 50;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 60;
        this.poderdosataques[3] = 0;
    }
    
}

    
