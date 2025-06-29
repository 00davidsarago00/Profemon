public class inimigoPetista extends inimigos {
    
    public inimigoPetista() {
        this.nome = "Petista";
        this.vida = 13;
        this.ataque = 13;
        this.defesa = 13;
        this.imagem = new ImageIcon("Sprints/petista.png");
        this.label = new JLabel(imagem);
    }

}