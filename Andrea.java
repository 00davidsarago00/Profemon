import javax.swing.*;
import java.awt.*;  


public class Andrea extends profemon {
    public Andrea() {
        this.nome = "Andrea";
        this.tipo = "Programador";
        this.ataque = 65;
        this.vida = 95;
        this.nivel = 1;
        this.defesa = 105;
        this.evolucao = 1;
        this.vidamaxima = 95;
        
        imagemfrente = new ImageIcon("Sprints/" + nome + nivel + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + nivel + "Back" + ".png");
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente); 
        
           
        this.velocidadedosataques[0] = 80; 
        this.velocidadedosataques[1] = 50; 
        this.velocidadedosataques[2] = 70;
        this.velocidadedosataques[3] = 95;

        this.poderdosataques[0] = 45;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 20;
        this.poderdosataques[3] = 40;

    }
    
}

    
