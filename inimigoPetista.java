public class inimigoPetista extends inimigos {
    
    public inimigoPetista(int posicaoX, int posicaoY) {
        this.nome = "Petista";
        this.tipo = "EntraçonoRU";
        this.velocidade = 13;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.vida = 13;
        this.ataque = 13;
        this.defesa = 13;

        this.imagem = new ImageIcon("Sprints/petista.png");
        this.label = new JLabel(imagem);
        
    }

}
