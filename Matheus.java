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
        
        imagemfrente = new ImageIcon("Sprints/" + nome + "1" + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + "1" + "Back" + ".png");
        imagemderrotado = new ImageIcon("Sprints/" + nome + "1" + "Back" + "BG.png");
        imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente); 
        
           
        this.velocidadedosataques[0] = 75; 
        this.velocidadedosataques[1] = 55; 
        this.velocidadedosataques[2] = 60;
        this.velocidadedosataques[3] = 30;

        this.poderdosataques[0] = 50;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 60;
        this.poderdosataques[3] = 0;
        
        this.nomedosataques[0] = "SCRUM";
        this.nomedosataques[1] = "Planejamento Estratégico";
        this.nomedosataques[2] = "Curva ABC";
        this.nomedosataques[3] = "Gestão de Recursos";
    }
    
}

    
