# 🎮 Documentação do Projeto Profemon

## 📖 Visão Geral
O **Profemon** é um jogo de RPG desenvolvido em Java que utiliza Swing para interface gráfica. O projeto implementa um sistema de combate entre personagens do tipo "Profemon" (baseados em professores) e inimigos, com mecânicas de evolução, experiência, sistema de níveis e animações de batalha.

O jogo possui uma narrativa onde o jogador é um "jovem universitário" que deve enfrentar os "inimigos do conhecimento" com a ajuda de seus Profemons.

## 🏗️ Estrutura do Projeto

### 📁 Arquivos Principais

- **`jogo.java`** - Classe principal do jogo com interface gráfica completa e sistema de seleção
- **`personagens.java`** - Classe abstrata base para todos os personagens
- **`profemon.java`** - Classe abstrata para personagens jogáveis com sistema de evolução
- **`inimigos.java`** - Classe abstrata para personagens inimigos com IA de movimento
- **`inimigoPetista.java`** - Implementação concreta de um inimigo
- **`Paiola.java`** - Profemon baseado no professor Paiola (tipo Programador)
- **`Andrea.java`** - Profemon baseado na professora Andrea (tipo Programador)  
- **`LH.java`** - Profemon baseado no professor LH (tipo Matemático)

### 🎨 Recursos Gráficos
- **`Sprints/`** - Diretório contendo sprites dos personagens:
  - `andrea_vianna.jpeg` - Sprite da Andrea
  - `douglas_rodrigues.png` - Sprite do Douglas
  - `emilia_marques.jpeg` - Sprite da Emilia
  - `luiz_henrique.png` - Sprite do LH
  - `matheus_vieira.png` - Sprite do Matheus
  - `paiola.png` - Sprite do Paiola

## 🏛️ Arquitetura do Sistema

### 📊 Hierarquia de Classes

```
personagens (abstract)
├── profemon (abstract)
│   ├── Paiola (concrete) - Tipo: Programador
│   ├── Andrea (concrete) - Tipo: Programador
│   └── LH (concrete) - Tipo: Matemático
└── inimigos (abstract)
    └── inimigoPetista (concrete)
```

### 🏗️ Classe Base: `personagens`

A classe abstrata `personagens` define a estrutura básica para todos os personagens do jogo:

**Atributos:**
- `nome`, `tipo` - Identificação do personagem
- `vida`, `ataque`, `defesa` - Atributos de combate
- `posicaoX`, `posicaoY` - Posição no campo de batalha
- `velocidade` - Velocidade de movimento/animação
- `velocidadedosataques[]` - Array com velocidades dos 4 ataques
- `imagem`, `label` - Componentes gráficos (ImageIcon e JLabel)

**Métodos Principais:**
- `atacarnormal()` - Sistema de ataque com animação de projétil
- `receberDano()` (abstrato) - Processamento de dano recebido
- `derrotado()` (abstrato) - Ação quando o personagem é derrotado
- `esperar()` - Método auxiliar para pausas nas animações

### 🎓 Classe `profemon`

Estende `personagens` e representa os personagens controlados pelo jogador:

**Atributos Específicos:**
- `nivel` - Nível atual do Profemon (1-100)
- `experiencia` - Pontos de experiência acumulados
- `evolucao` - Estágio evolutivo atual
- `vidamaxima` - Vida máxima do personagem

**Funcionalidades:**
- **Sistema de Níveis:** Evolução através de experiência (88 XP por nível)
- **Sistema de Evolução:** 
  - Evoluções especiais nos níveis 16 e 40 (dobrando atributos)
  - Nível máximo: 100
  - Aumento gradual de atributos por nível
- **Interface de Características:** Janela dedicada para visualizar status
- **Sistema de Revival:** Capacidade de ser revivido com vida restaurada
- **4 Ataques Diferentes:** Cada Profemon possui 4 ataques abstratos implementáveis

**Métodos Destacados:**
- `mostrarCaracteristicas()` - Exibe janela com foto e informações detalhadas
- `evoluirdenivel()` - Gerencia evolução por nível com aumentos de atributos
- `evoluiProf()` - Evolução especial com multiplicadores significativos
- `EliminouInimigo()` - Ganha experiência ao derrotar inimigos
- `receberDano()` - Calcula dano considerando defesa do personagem
- `reviveu()` - Sistema de ressurreição com restauração de vida

### 🐍 Classe `inimigos`

Estende `personagens` e representa os adversários:

**Características:**
- **Sistema de Movimento:** Movimentação automática através do método `andar()`
- **IA Básica:** Movimento contínuo enquanto vivo
- **Threading:** Execução paralela com interruption handling
- **Recompensa Dinâmica:** Experiência baseada em `20*defesa+dano/100`

**Métodos Específicos:**
- `andar()` - Loop de movimento com controle de velocidade
- `receberDano()` - Processa dano e recompensa o atacante
- `derrotado()` - Interrompe threads e exibe animação de derrota

### 🎯 Profemons Implementados

#### 👨‍💻 Paiola
- **Tipo:** Programador
- **Atributos Iniciais:** Vida: 100, Ataque: 20, Nível: 1
- **Velocidades de Ataque:** [10, 15, 20, 25]

#### 👩‍💻 Andrea  
- **Tipo:** Programador
- **Atributos Iniciais:** Vida: 100, Ataque: 20, Nível: 1
- **Velocidades de Ataque:** [10, 15, 20, 25]

#### 🧮 LH (Luiz Henrique)
- **Tipo:** Matemático
- **Atributos Iniciais:** Vida: 100, Ataque: 20, Nível: 1
- **Velocidades de Ataque:** [10, 15, 20, 25]

### 🏴‍☠️ Implementação Concreta: `inimigoPetista`

Primeira implementação concreta de um inimigo com:
- **Vida:** 13
- **Ataque:** 13  
- **Defesa:** 13
- **Sprite:** "petista.png"

## ⚡ Funcionalidades Implementadas

### 🎮 Interface do Jogo
- **Tela Inicial:** Botão de início com layout centralizado
- **Sistema de Seleção:** Interface gráfica para escolha do Profemon inicial
- **Narrativa Introdutória:** Sequência de textos explicativos sobre o jogo
- **Layout Responsivo:** Uso de BorderLayout e GridLayout para organização

### ⚔️ Sistema de Combate
- **Animações de Ataque:** Movimento de projéteis com velocidades configuráveis
- **Cálculo de Dano:** Fórmula `dano/defesa` para balanceamento
- **Estados Visuais:** Mudança de sprites para personagens derrotados
- **Sincronização:** Métodos `synchronized` para thread safety

### 📈 Sistema de Progressão
- **Experiência:** 88 pontos necessários para evolução
- **Evolução Gradual:** +5 ataque, +5 defesa, +10 vida por nível
- **Evoluções Especiais:** 
  - Nível 16: Dobra ataque e defesa, quintuplica vida
  - Nível 40: Segunda evolução especial
  - Nível 100: Nível máximo atingido
- **Sprites Evolutivos:** Carregamento automático de `nome + nivel + .png`

### 🖼️ Interface Gráfica
- **Sprites Escalados:** Redimensionamento automático para 550x550 pixels
- **Janelas Modais:** Sistema de características com `JFrame` dedicado
- **Mensagens Informativas:** `JOptionPane` para feedback ao jogador
- **Threading Visual:** Animações não bloqueantes com `Thread.sleep()`

### 🧠 Sistema de IA
- **Movimento Autônomo:** Inimigos se movem independentemente
- **Controle de Velocidade:** Configuração individual de velocidade de movimento
- **Interrupção de Threads:** Gerenciamento seguro de threads ao morrer

## 🧵 Threading e Concorrência
O projeto utiliza extensivamente threading para:
- **Implementação de `Runnable`:** Tanto `profemon` quanto `inimigos` implementam a interface
- **Animações Paralelas:** Movimentos e ataques executados sem bloquear a UI
- **Movimentação de Inimigos:** Loop contínuo com controle de velocidade
- **Sincronização:** Métodos `synchronized` para evitar race conditions
- **Interrupção Segura:** Tratamento adequado de `InterruptedException`

## 📊 Estado Atual do Projeto

### ✅ Funcionalidades Completas
- Estrutura completa de classes com herança bem definida
- Sistema de combate totalmente funcional
- Mecânicas de evolução e progressão implementadas
- Interface gráfica principal com seleção de personagem
- Sistema de threading para animações e movimento
- Três Profemons jogáveis totalmente implementados
- Sistema de experiência e níveis funcionando

### 🚧 Em Desenvolvimento
- Sistema de batalha em tempo real
- Implementação dos 4 ataques específicos para cada Profemon
- Mais variedades de inimigos
- Sistema de mapas e cenários

### ❌ Pendências
- Completar a lógica de batalha na classe `jogo`
- Implementar ataques específicos (ataque1-4) para cada Profemon
- Adicionar mais tipos de inimigos além do `inimigoPetista`
- Sistema de save/load de progresso
- Balanceamento de dificuldade

## 🚀 Próximos Passos Sugeridos

### 🎯 Prioridade Alta
1. **Completar Sistema de Batalha:** Implementar a lógica de combate em tempo real na classe `jogo`
2. **Implementar Ataques Específicos:** Criar os 4 ataques únicos para cada Profemon
3. **Adicionar Mais Inimigos:** Criar diversidade de adversários com diferentes características
4. **Sistema de Mapas:** Implementar cenários e navegação entre áreas

### 🎯 Prioridade Média  
5. **Melhorias na Interface:** Sistema de menus mais robusto e intuitivo
6. **Sistema de Inventário:** Itens, poções e equipamentos
7. **Mais Profemons:** Expandir o elenco de personagens jogáveis
8. **Sistema de Save/Load:** Persistência de progresso do jogador

### 🎯 Melhorias Futuras
9. **Multiplayer Local:** Batalhas entre jogadores
10. **Sistema de Achievements:** Conquistas e objetivos
11. **Trilha Sonora:** Efeitos sonoros e música de fundo
12. **Animações Avançadas:** Sprites animados e efeitos visuais

## 🛠️ Tecnologias Utilizadas

- **☕ Java 8+** - Linguagem de programação principal
- **🖼️ Swing** - Framework para interface gráfica nativa
- **🧵 Threading** - Para animações e processamento paralelo  
- **📷 ImageIcon** - Para carregamento e manipulação de sprites
- **🎨 AWT** - Para componentes gráficos e layout managers
- **⚡ Event Handling** - Sistema de eventos com ActionListener

## 📋 Dependências
- **JDK 8+** (recomendado JDK 11 ou superior)
- **Swing** (incluído no JDK)
- **AWT** (incluído no JDK)

## ▶️ Como Executar

### 📦 Pré-requisitos
```bash
# Verificar versão do Java
java -version
javac -version
```

### 🏃‍♂️ Passos para Execução
```bash
# 1. Navegar para o diretório do projeto
cd /caminho/para/Profemon

# 2. Compilar todos os arquivos Java
javac *.java

# 3. Executar o jogo
java jogo
```

### ⚠️ Requisitos Importantes
- Certifique-se de que o diretório `Sprints/` esteja no mesmo nível dos arquivos `.java`
- Todas as imagens devem estar no formato correto (PNG/JPEG)
- Resolução recomendada: 1920x1080 ou superior

## 📁 Estrutura de Diretórios
```
Profemon/
├── 📄 jogo.java              # Classe principal com interface gráfica
├── 📄 personagens.java       # Classe abstrata base
├── 📄 profemon.java         # Classe abstrata para jogadores
├── 📄 inimigos.java         # Classe abstrata para adversários
├── 📄 inimigoPetista.java   # Inimigo concreto implementado
├── 📄 Paiola.java           # Profemon do Professor Paiola
├── 📄 Andrea.java           # Profemon da Professora Andrea
├── 📄 LH.java               # Profemon do Professor LH
├── 📄 README.md             # Esta documentação
└── 📁 Sprints/              # Diretório de sprites
    ├── 🖼️ andrea_vianna.jpeg
    ├── 🖼️ douglas_rodrigues.png
    ├── 🖼️ emilia_marques.jpeg
    ├── 🖼️ luiz_henrique.png
    ├── 🖼️ matheus_vieira.png
    └── 🖼️ paiola.png
```

## 🎯 Características do Design

### 🏗️ Padrões de Design Utilizados
- **Template Method:** Classes abstratas definem algoritmos base
- **Strategy Pattern:** Diferentes implementações de Profemon
- **Observer Pattern:** Sistema de eventos com ActionListener
- **Runnable Interface:** Para threading e concorrência

### 📐 Princípios SOLID Aplicados
- **Single Responsibility:** Cada classe tem uma responsabilidade específica
- **Open/Closed:** Extensível via herança, fechado para modificação
- **Interface Segregation:** Interfaces específicas como Runnable e ActionListener

## 🐛 Troubleshooting

### ❌ Problemas Comuns

**1. Erro de "Cannot find symbol"**
```bash
# Solução: Compilar todos os arquivos juntos
javac *.java
```

**2. Imagens não aparecem**
```bash
# Verificar se as imagens estão no diretório correto
ls Sprints/
# Verificar nomes dos arquivos (case-sensitive)
```

**3. Exception em Threading**
```java
// Verificar se há InterruptedException sendo tratada
catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

## 📚 Documentação Adicional

### 🔧 Para Desenvolvedores
- Todas as classes abstratas devem ter implementações concretas
- Sprites devem seguir convenção: `nome + nivel + .png`
- Threading deve sempre tratar InterruptedException
- Métodos synchronized são necessários para combat

### 🎮 Para Jogadores
- Use as características dos Profemons para escolher estratégias
- Evolua seus Profemons para aumentar poder de combate
- Diferentes tipos podem ter vantagens específicas

---

**📅 Última Atualização:** Julho 2025  
**👥 Desenvolvido por:** Equipe de Desenvolvimento Profemon  
**📧 Contato:** Para dúvidas sobre o projeto, consulte a documentação no código