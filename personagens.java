import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class personagens { 
    // Atributos comuns a todos os personagens
    public String nome;
    public String tipo;

    public int vida;
    public int ataque;
    public int defesa;
    public int [] velocidadedosataques = new int[4];
    public int [] poderdosataques = new int[4];
    
    public String [] nomedosataques = new String[4];


    ImageIcon imagemfrente;
    ImageIcon imagemderrotado;
    JLabel label;
    
    public abstract void derrotado();

    public void receberDano(int dano, personagens autor) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.derrotado();
        }
    }

    
}
