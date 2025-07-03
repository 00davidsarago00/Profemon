import javax.swing.*;
import java.awt.*;  


public class LH extends profemon {
    public LH() {
        this.nome = "Lh";
        this.tipo = "Matematico";
        this.ataque = 120;
        this.vida = 85;
        this.nivel = 1;
        this.defesa = 70;
        this.evolucao = 1;
        this.vidamaxima = 85;
        
        imagemfrente = new ImageIcon("Sprints/" + nome + "1" + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + "1" + "Back" + ".png");
        imagemderrotado = new ImageIcon("Sprints/" + nome + "1" + "Back" + "BG.png");
        imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente);
        
           
        this.velocidadedosataques[0] = 90; 
        this.velocidadedosataques[1] = 60; 
        this.velocidadedosataques[2] = 75;
        this.velocidadedosataques[3] = 30;

        this.poderdosataques[0] = 40;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 80;
        this.poderdosataques[3] = 140;
        
        this.nomedosataques[0] = "De Morgan";
        this.nomedosataques[1] = "Tautologia";
        this.nomedosataques[2] = "Inferência Lógica";
        this.nomedosataques[3] = "Prova por Contradição";

    }
    
    


}

    
