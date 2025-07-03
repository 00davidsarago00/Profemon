import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class profemon extends personagens {
    // Atributos específicos de Profemons
    public int nivel=1;
    int experiencia=0;
    int evolucao=1;
    int vidamaxima;
    ImageIcon imagemcostas;

    //Ações específicas de Profemons
    

    public void mostrarCaracteristicas(){
        JFrame FCaracteristicas = new JFrame("Características do Profemon");
        FCaracteristicas.setSize(1000,800); 
        FCaracteristicas.setLayout(new FlowLayout());
        FCaracteristicas.add(this.label);

        JLabel caracteristicaslabel = new JLabel("Nome: " + nome + " | Tipo: " + tipo + " | Nível: " + nivel + " | Vida: " + vida + " | Ataque: " + ataque + " | Defesa: " + defesa);
        caracteristicaslabel.setFont(new Font("Arial", Font.BOLD, 20));

        FCaracteristicas.add(caracteristicaslabel);
        FCaracteristicas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FCaracteristicas.setVisible(true);
    }

    public synchronized void receberDano(int dano, inimigos Autor) {
        this.vida -= dano;
        if (this.vida <= 0) {
            derrotado();
        }
    }

    public void derrotado() {
        this.vida = 0;
        this.label.setIcon(imagemderrotado);
        JOptionPane.showMessageDialog(null, nome + " foi derrotado!");
        try{
            Thread.sleep(2500); 
            this.label.setVisible(false); 
        }catch (InterruptedException e) {}
        
    }

    public void reviveu(int vidaRestaurada){
        if(vidaRestaurada >=vidamaxima) vidaRestaurada = vidamaxima;
        this.vida = vidaRestaurada; 

        JOptionPane.showMessageDialog(null, nome + " foi revivido e sua vida foi restaurada!");
        this.label.setIcon(new ImageIcon("Sprints/" + nome + evolucao +  "Front.png"));
    }

    public void evoluirdenivel() {
        nivel++;
        if(nivel == 16 || nivel == 40) {
            evolucao++;
            evoluiProf("Sprints/" + nome + evolucao + ".png");
        }
        else if(nivel >= 100){
            JOptionPane.showMessageDialog(null, nome + " atingiu o nível máximo e não pode mais evoluir!");
            nivel = 100;
        }
        else{
        ataque += 5;
        defesa += 5;
        vida += 10;
        }
        JOptionPane.showMessageDialog(null, nome + " evoluiu para o nível " + nivel + "!");
    }

    public void evoluiProf(String ProfEvoluido){
        ataque *= 2;
        defesa *= 2;
        vida *= 5;
        JOptionPane.showMessageDialog(null, nome + " evoluiu para o nível " + nivel + " e ganhou um aumento significativo em suas habilidades!");
    }

    public void EliminouInimigo(int experienciaGanha) {
        this.experiencia += experienciaGanha;
        if (this.experiencia >= 88) {
            evoluirdenivel();
            this.experiencia = this.experiencia-88;
        }
    }

}
