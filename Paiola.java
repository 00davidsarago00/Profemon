import javax.swing.*;
import java.awt.*;  


public class Paiola extends profemon {
    public Paiola() {
        this.nome = "Paiola";
        this.tipo = "Programador";
        this.ataque = 110;
        this.vida = 80;
        this.nivel = 1;
        this.defesa = 70;
        this.evolucao = 1;
        this.vidamaxima = 110;
        
        imagemfrente = new ImageIcon("Sprints/" + nome + nivel + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + nivel + "Back" + ".png");
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente);
        
           
        this.velocidadedosataques[0] = 90; 
        this.velocidadedosataques[1] = 70; 
        this.velocidadedosataques[2] = 80;
        this.velocidadedosataques[3] = 50;

        this.poderdosataques[0] = 40;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 70;
        this.poderdosataques[3] = 120; 
           
    }
    
}

    
