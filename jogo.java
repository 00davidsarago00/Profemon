import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jogo implements ActionListener{
    boolean comecou = false;
    boolean escolha = false;
    boolean confronto = false;
    boolean acabou = false;
    boolean sair = false;
    
    
    //Profemons
    Paiola paiola = new Paiola();
    Andrea andrea = new Andrea();
    LH lh = new LH();
    Matheus matheus = new Matheus();
    Emilia emilia = new Emilia();
    Douglas douglas = new Douglas();

    profemon []equipe = new profemon[6];
    profemon []rejeitados = new profemon[6];
    inimigos []equipeinimigos = new inimigos[6];

    volatile int indice = -1;
    public int quantiadedeprofemons = 0;
    public int quantiadedeinimigos = 0;

    //inimigos
    Fluflu fluflu = new Fluflu();

    //Botões
    JButton paiolaButton = new JButton("Ver as caracteristicas de Paiola");
    JButton andreaButton = new JButton("Ver as caracteristicas de Andrea");
    JButton lhButton = new JButton("Ver as caracteristicas de LH");
    JButton startButton = new JButton("Iniciar Jogo");

    JButton escolhaButton = new JButton("Aperte aqui quando tomar sua decisão!");
    
    //Paineis
    JFrame Principal = new JFrame("Jogo de Profemons");
    JPanel gamePanel = new JPanel();
    JPanel profemonsPanel = new JPanel();

    //backgorunds

    ImageIcon Biblioteca = new ImageIcon("Backgrounds/Bibilioteca_BG.png");
    ImageIcon LEPEC = new ImageIcon("Backgrounds/LEPEC_BG.png");
    ImageIcon Portaria = new ImageIcon("Backgrounds/Portaria_BG.png");
    ImageIcon PrimeiroDeMaio = new ImageIcon("Backgrounds/PrimeiroDeMaio_BG.png");
    ImageIcon RU = new ImageIcon("Backgrounds/RU_BG.png");

    JLabel fundoLabel = new JLabel(Portaria);

    //Batalha
    profemon prof;

    public jogo(){
        Portaria = new ImageIcon(Portaria.getImage().getScaledInstance(1200, 720, Image.SCALE_SMOOTH));
        Principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Principal.setSize(1200, 720);
        Principal.setLayout(new BorderLayout());

        
        fundoLabel.setBounds(0, 0, 1200, 720);

        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.addActionListener(this);
        startButton.setBounds(500, 500, 200, 50); // x, y, largura, altura

        fundoLabel.add(startButton);

        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(fundoLabel, BorderLayout.CENTER);
        
        Principal.add(gamePanel, BorderLayout.CENTER);
        Principal.setVisible(true);

        while (!comecou) {
            esperar(100);
            Principal.setTitle("Jogo de Profemons - Aguardando Início");
        }

        startButton.setVisible(false);
        fundoLabel.remove(startButton);
        JLabel gameLabel = new JLabel("Jogo Iniciado!", SwingConstants.CENTER);
        gameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gameLabel.setOpaque(true);
        gameLabel.setBackground(Color.WHITE);
        
        gameLabel.setBounds(40, 335, 1000, 50);
        fundoLabel.add(gameLabel);

        gameLabel.setText("Seja bem vindo, jovem universitario! Ao mundo dos Profemons.");
        esperar(5000);
        gameLabel.setText("Aqui, esteja preparado para enfrentar os inimigos do conhecimento!");
        esperar(5000);
        gameLabel.setText("Prepare-se para a batalha, pois os inimigos estão chegando!");
        esperar(5000);
        gameLabel.setText("Para iniciarmos, escolha seu Profemon inicial!");
        esperar(5000);
        gamePanel.removeAll();
        gamePanel.setLayout(new BorderLayout());

        
        gameLabel.setText("Escolha seu Profemon inicial:\n\n");
        gamePanel.add(gameLabel, BorderLayout.NORTH);


        paiolaButton.addActionListener(this);
        andreaButton.addActionListener(this);
        lhButton.addActionListener(this);

        paiolaButton.setFont(new Font("Arial", Font.BOLD, 20));
        andreaButton.setFont(new Font("Arial", Font.BOLD, 20));
        lhButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        paiolaButton.setIcon(paiola.imagemfrente);
        andreaButton.setIcon(andrea.imagemfrente);
        lhButton.setIcon(lh.imagemfrente);


        profemonsPanel.setLayout(new GridLayout(1,3));

        profemonsPanel.add(paiolaButton);
        profemonsPanel.add(andreaButton);
        profemonsPanel.add(lhButton);

        gamePanel.add(profemonsPanel, BorderLayout.CENTER);

        escolhaButton.setFont(new Font("Arial", Font.BOLD, 20));

        
        gamePanel.add(escolhaButton, BorderLayout.SOUTH);
        escolhaButton.addActionListener(this);
        
        gamePanel.revalidate();

        while (!escolha) {
            esperar(100);
            Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon");
        }
        
        paiolaButton.setText("Escolher Paiola!");
        andreaButton.setText("Escolher Andrea!");
        lhButton.setText("Escolher LH!");

        gamePanel.remove(escolhaButton);

        while(equipe[0] == null) {
            esperar(100);
            Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon");
        }
        escolha = false;

        

        gamePanel.removeAll();
        Principal.revalidate();

        Principal.setTitle("Jogo de Profemons - " + equipe[0].nome + " Escolhido");
        gameLabel.setText("Você escolheu " + equipe[0].nome + "! Preparem-se para a aventura!");
        gameLabel.setBounds(50, 335, 1000, 50); // mantém a posição centralizada

        fundoLabel.setIcon(PrimeiroDeMaio);
        fundoLabel.setBounds(0, 0, 1200, 720);
        fundoLabel.add(gameLabel);

        gamePanel.setLayout(null);
        gamePanel.add(fundoLabel);
        gamePanel.repaint();
        gamePanel.revalidate();
        esperar(5000);
        
        gameLabel.setText("Espera, o que é isso? Um inimigo esta se aproximando!");
        esperar(5000);
        
        equipeinimigos[0] = fluflu;
        quantiadedeinimigos = 1;
        gameLabel.setText("Prepare-se! Use seu Profemon para enfrentar o inimigo!");
        esperar(5000);

        do{
            confronto = batalha(equipe,equipeinimigos,PrimeiroDeMaio);
            if(!confronto){  
                fundoLabel.removeAll();
                fundoLabel.add(gameLabel, BorderLayout.CENTER); 
                gameLabel.setText("Espera ai, ainda nao acabou, irei curar " + equipe[0].nome +"! Tente novamente");
                equipe[0].reviveu(equipe[0].vidamaxima);
                esperar(5000);
            }
            gamePanel.revalidate();
        }while(!confronto);

        fundoLabel.removeAll();
        fundoLabel.setIcon(PrimeiroDeMaio);

        gameLabel.setBounds(50, 335, 1000, 50);
        fundoLabel.add(gameLabel);
        fundoLabel.revalidate();
        gameLabel.setText("Parabens, voce venceu seu primeiro inimigo!");
        esperar(5000);
        gameLabel.setText("Agora, sua jornada se inicia de verdade.");
        esperar(5000);
        gameLabel.setText("Por favor, ajude-nos a defender a Unesp, dos universitarios.");
        esperar(5000);
        gameLabel.setText("Te desejo sorte e cuidado! Os inimigos são o pior da humanidade");
        esperar(5000);


        

        while(!sair){
            fundoLabel.setBounds(new GridLayout(1,3));

            gameLabel.setBounds(50, 15, 1000, 50);
            gameLabel.setText("Qual confronto voce irá primeiro?");
            
            JButton fase1 = new JButton("Fase 1 - Biblioteca");

                fase1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do{
                            confronto = batalha(equipe,equipeinimigos,Biblioteca);
                            if(!confronto){  
                                fundoLabel.removeAll();
                                fundoLabel.add(gameLabel, BorderLayout.CENTER); 
                                gameLabel.setText("Espera ai, ainda nao acabou, irei curar sua equipe! Tente novamente");
                                for(profemon profem : equipe){
                                    profem.reviveu(equipe[0].vidamaxima);
                                    JOptionPane.showMessageDialog(Principal,  profem.nome + " reviveu");
                                    esperar(1000);
                                }
                            }
                            gamePanel.revalidate();
                        }while(!confronto);
                        
                        

                    }
                });

        }


    }
    
    public static void main(String[] args) {
       new jogo();
    }

    public profemon escolherProfemon(profemon[] equipe) {
            gamePanel.removeAll();
            gamePanel.setLayout(new GridLayout(2,1));
            JPanel equipePanel = new JPanel(new GridLayout(equipe.length, 1));
            JLabel equipeLabel = new JLabel("Escolha seu Profemon:");
            gamePanel.add(equipeLabel);
            equipeLabel.setFont(new Font("Arial", Font.BOLD, 20));

            for(int i=0; i<quantiadedeprofemons; i++){
                profemon profe = equipe[i];
                JButton profButton = new JButton();
                if(profe.vida <= 0) {
                    profButton.setEnabled(false);
                    ImageIcon profImagederrotado = new ImageIcon("Sprints/" + profe.nome + profe.evolucao + " derrotado.png");
                    profImagederrotado = new ImageIcon(profImagederrotado.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
                    profButton.setIcon(profImagederrotado);
                }
                else{
                    profButton.setIcon(profe.imagemfrente);
                    equipePanel.add(profButton);
                    profButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            profemon prof = profe;
                            Principal.setTitle("Jogo de Profemons - " + prof.nome + " Escolhido");
                            JOptionPane.showMessageDialog(Principal, "Você escolheu " + prof.nome + " para a batalha!");
                            prof.label.setVisible(true);
                            gamePanel.revalidate();
                            escolha = true;

                        }
                    });
                    
                    
                }       
            }
            gamePanel.add(equipePanel);
            Principal.setTitle("Jogo de Profemons - Escolha seu Profemon para Batalha");
            while(!escolha){
                esperar(100);
                Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon para Batalha");
            }
            escolha = false;
            
            
            return prof;


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            comecou = true;
        }
        else if(e.getSource() == paiolaButton && !escolha) {
            paiola.mostrarCaracteristicas();
        }  
        else if(e.getSource() == andreaButton && !escolha) {
            andrea.mostrarCaracteristicas();
        }  
        else if(e.getSource() == lhButton && !escolha) {
            lh.mostrarCaracteristicas();
        } 
        else if(e.getSource() == escolhaButton) {
            escolha = true;
        }
        else if(e.getSource() == paiolaButton && escolha) {
            gamePanel.removeAll();
            gamePanel.setLayout(new BorderLayout());
            JLabel escolhaLabel = new JLabel("Ótimo, você escolheu o Paiola! Tenho certeza que terão uma gloriosa jornada", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            paiola.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - Paiola Escolhido"); 
            gamePanel.revalidate();
            gamePanel.repaint();
            esperar(5000);

            equipe[0] = paiola;
            rejeitados[0] = andrea;
            rejeitados[1] = lh;
            quantiadedeprofemons = 1;
            
        } else if(e.getSource() == andreaButton && escolha) {
            gamePanel.removeAll();
            gamePanel.setLayout(new BorderLayout());
            JLabel escolhaLabel = new JLabel("Então, você escolheu a Andrea! Ótima escolha.", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            andrea.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - Andrea Escolhida");
            gamePanel.revalidate();
            gamePanel.repaint();
            esperar(5000);
            equipe[0] = andrea;
            rejeitados[0] = paiola;
            rejeitados[1] = lh;
            quantiadedeprofemons = 1;
            
        } else if(e.getSource() == lhButton && escolha) {
            gamePanel.removeAll();
            gamePanel.setLayout(new BorderLayout());
            JLabel escolhaLabel = new JLabel("Maravilha você escolheu o Lh! Muito bem.", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            lh.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - Lh Escolhido");
            gamePanel.revalidate();
            gamePanel.repaint();
            esperar(5000);
            equipe[0] = lh;
            rejeitados[0] = paiola;
            rejeitados[1] = andrea;
            quantiadedeprofemons = 1;
            
        }
    }

    public Boolean batalha(profemon[] equipe, inimigos[] inimigue, ImageIcon fundo){
        Boolean vitoria = false;
        
        double modificardordetipoprof = 1;
        double modificadordetipoinimigo = 1;

        
        
        if(quantiadedeprofemons == 1){
            prof = equipe[0];
        }
        else if(quantiadedeprofemons > 1){
            prof = escolherProfemon(equipe);
            while(prof == null) {
                esperar(100);
                Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon para Batalha");
            }
        }
        int aux = quantiadedeprofemons;
        int aux2 = quantiadedeinimigos;
        int contador = 0;
        inimigos inimigo = inimigue[0];

        JLabel profLabel = new JLabel(prof.nome + " (Vida: " + prof.vida + ")");
        JLabel inimigoLabel = new JLabel(inimigo.nome + " (Vida: " + inimigo.vida + ")");

        profLabel.setOpaque(true);
        profLabel.setBackground(Color.WHITE);

        inimigoLabel.setOpaque(true);
        inimigoLabel.setBackground(Color.WHITE);

        JLabel fundobatalha = new JLabel(fundo);
        fundobatalha.setBounds(0, 0, 1200, 720);

        Principal.add(gamePanel);

        while(aux > 0 && aux2 > 0){
            prof.imagemcostas = new ImageIcon(prof.imagemcostas.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
            prof.label = new JLabel(prof.imagemcostas);  
            while(prof.vida > 0 && inimigo.vida > 0) {
                fundoLabel.removeAll();
                fundoLabel.setLayout(null);
                
                fundobatalha.setBounds(0, 0, 1200, 720);
                fundobatalha.setLayout(null);

                prof.label.setBounds(150, 250, 250, 300);
                inimigo.label.setBounds(800, 250, 250, 300);
                fundobatalha.add(prof.label);
                fundobatalha.add(inimigo.label);
                
                
                JPanel infos = new JPanel(new GridLayout(1, 2, 10, 10));
                infos.setBounds(200, 150, 800, 40);
                infos.setOpaque(false);
                profLabel.setFont(new Font("Arial", Font.BOLD, 22));
                inimigoLabel.setFont(new Font("Arial", Font.BOLD, 22));
                profLabel.setHorizontalAlignment(SwingConstants.CENTER);
                inimigoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                infos.add(profLabel);
                infos.add(inimigoLabel);
                fundobatalha.add(infos);

                JPanel acoesPanel = new JPanel(new GridLayout(2, 2));
                acoesPanel.setBounds(350, 580, 500, 100);
                acoesPanel.setOpaque(true);
                acoesPanel.setBackground(new Color(255, 255, 255, 180));
                acoesPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                JButton ataque1Button = new JButton(prof.nomedosataques[0]);
                JButton ataque2Button = new JButton(prof.nomedosataques[1]);
                JButton ataque3Button = new JButton(prof.nomedosataques[2]);
                JButton ataque4Button = new JButton(prof.nomedosataques[3]);

                

                ataque1Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque2Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque3Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque4Button.setFont(new Font("Arial", Font.BOLD, 20));
            
                ataque1Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indice = 0;
                    }
                });
                ataque2Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indice = 1;
                    }
                });
                ataque3Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indice = 2;
                    }
                });
                ataque4Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indice = 3;
                    }
                });

                
                acoesPanel.add(ataque1Button);
                acoesPanel.add(ataque2Button);
                acoesPanel.add(ataque3Button);
                acoesPanel.add(ataque4Button);

                fundobatalha.add(acoesPanel);

                fundoLabel.add(fundobatalha);

                gamePanel.removeAll();
                gamePanel.setLayout(null);
                gamePanel.add(fundoLabel);
                gamePanel.revalidate();
                gamePanel.repaint();


                while(indice < 0 || indice > 3) {
                    Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Ataque");

                }
                Principal.setTitle("Atacando - Animacao");
                modificardordetipoprof = 1;
                modificadordetipoinimigo = 1;

                if(prof.tipo.equals("Programador") && inimigo.tipo.equals("Matematico")){
                    modificardordetipoprof = 1.5;
                    modificadordetipoinimigo = 0.75;
                }
                else if(inimigo.tipo.equals("Programador") && prof.tipo.equals("Matematico")){
                    modificardordetipoprof = 0.75;
                    modificadordetipoinimigo = 1.5;
                }
                else if(prof.tipo.equals("Engenheiro") && inimigo.tipo.equals("Matematico")){
                    modificardordetipoprof = 0.75;
                    modificadordetipoinimigo = 1.5;
                }
                else if(inimigo.tipo.equals("Matematico") && prof.tipo.equals("Engenheiro")){
                    modificardordetipoprof = 1.5;
                    modificadordetipoinimigo = 0.75;
                }
                else if(prof.tipo.equals("Engenheiro") && inimigo.tipo.equals("Programador")){
                    modificardordetipoprof = 1.5;
                    modificadordetipoinimigo = 0.75;
                }
                else if(inimigo.tipo.equals("Programador") && prof.tipo.equals("Engenheiro")){
                    modificardordetipoprof = 0.75;
                    modificadordetipoinimigo = 1.5;
                }


                
                int indiceinimigo = (int) (Math.random() * 4);
                
                double danoini = ((3.0 * inimigo.ataque * inimigo.poderdosataques[indiceinimigo]) / (prof.defesa + 50.0)) * modificadordetipoinimigo;
                double danoprof = ((3.0 * prof.ataque * prof.poderdosataques[indice]) / (inimigo.defesa + 50.0)) * modificardordetipoprof;               

                if(prof.velocidadedosataques[indice] > inimigo.velocidadedosataques[indiceinimigo]) {

                    animacaodeataque(prof.nomedosataques[indice], prof.poderdosataques[indice], true, fundobatalha);
                    inimigo.receberDano((int)Math.floor(danoprof), prof);
                    inimigoLabel.setText(inimigo.nome + " (Vida: " + inimigo.vida + ")");
                    if(inimigo.vida > 0) {
                        animacaodeataque(inimigo.nomedosataques[indice], inimigo.poderdosataques[indiceinimigo], false, fundobatalha);
                        prof.receberDano((int)Math.ceil(danoini), inimigo);
                        profLabel.setText(prof.nome + " (Vida: " + prof.vida + ")");
                    }
                } 
                else {
                    animacaodeataque(inimigo.nomedosataques[indice], inimigo.poderdosataques[indiceinimigo], false, fundobatalha);
                    prof.receberDano((int)Math.ceil(danoini), inimigo);
                    profLabel.setText(prof.nome + " (Vida: " + prof.vida + ")");
                    if(prof.vida > 0) {
                        animacaodeataque(prof.nomedosataques[indice], prof.poderdosataques[indice],true, fundobatalha);
                        inimigo.receberDano((int)Math.floor(danoprof), prof);
                        inimigoLabel.setText(inimigo.nome + " (Vida: " + inimigo.vida + ")");
                    }
                    
                }
                indice = -1;
                
                
            }
            
           
            fundoLabel.revalidate();
            fundoLabel.repaint();
            
            if(prof.vida <= 0) {
                gamePanel.revalidate();
                Principal.revalidate();
                prof.label.setVisible(false);
                aux--;
                if(aux > 0) {
                    prof = escolherProfemon(equipe);
                    while(prof == null) {
                        esperar(100);
                        Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon para Batalha");
                    }
                }
            } else if(inimigo.vida <= 0) {
                gamePanel.revalidate();
                Principal.revalidate();
                esperar(5000);
                inimigo.label.setVisible(false);
                aux2--;
                if(aux2 > 0) {
                    contador++;
                    inimigo = inimigue[contador];
                } else {
                    vitoria = true;
                    break;
                }
            }
        }

        Principal.setTitle("Jogo de Profemons - Batalha Finalizada");
        
        
        fundoLabel.removeAll();
        fundoLabel.setIcon(fundo);
        
        JLabel mensagemfinal = new JLabel("Batalha Finalizada!");
        mensagemfinal.setFont(new Font("Arial", Font.BOLD, 30));
        mensagemfinal.setOpaque(true);
        mensagemfinal.setBackground(Color.WHITE);
        mensagemfinal.setBounds(40, 335, 1000, 50);
        
        fundoLabel.add(mensagemfinal);
        fundoLabel.revalidate();
        fundoLabel.repaint();
        mensagemfinal.setFont(new Font("Arial", Font.BOLD, 30));
        
        esperar(5000);

        if(vitoria) mensagemfinal.setText("Você venceu a batalha!");  
        else mensagemfinal.setText("Você foi derrotado!");
            
        esperar(5000);
        acabou = true;
        return vitoria;
    }

    void animacaodeataque(String nomedoatatque, int dano, Boolean ehProfemon, JLabel fundobatalha){

        int posin;
        int posfim;
        ImageIcon ataque;
        String tipodoataque;

        if(ehProfemon){
            posin = 150;
            posfim = 800;
        }  
        else{ 
            posin = 800;
            posfim = 150;
        }

        if(dano <= 0){
            tipodoataque = "Buff";
            posfim = posin;
        }
        else if(dano<=69) tipodoataque = "Light";
        else if(dano<=100) tipodoataque = "Mid";
        else tipodoataque = "Ult";

        ataque = new ImageIcon("Sprints/Attack"+ tipodoataque + ".gif");

        JLabel imagemataque = new JLabel(ataque);
        fundobatalha.add(imagemataque);
        fundobatalha.revalidate();

        if(posin == posfim){
            imagemataque.setBounds(posin, 250, 250, 300);
            esperar(2000);
            fundobatalha.revalidate();
            fundobatalha.remove(imagemataque);
        }
        else{
            if(ehProfemon){
                for(int i = posin; i < posfim; i++){
                    imagemataque.setBounds(i, 250, 250, 300);
                    esperar(2);
                    fundobatalha.revalidate();
                }
            }
            else{
                for(int i = posin; i > posfim; i--){
                    imagemataque.setBounds(i, 250, 250, 300);
                    esperar(2);
                    fundobatalha.revalidate();
                }
            }
            fundobatalha.remove(imagemataque);
        }

    }


    void esperar(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
