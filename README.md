# Documentação do Projeto Profemon

## Visão Geral
O **Profemon** é um jogo desenvolvido em Java que utiliza Swing para interface gráfica. O projeto implementa um sistema de combate entre personagens do tipo "Profemon" e inimigos, com mecânicas de evolução, experiência e animações de batalha.

## Estrutura do Projeto

### Arquivos Principais

- **`jogo.java`** - Classe principal do jogo (atualmente vazia)
- **`personagens.java`** - Classe abstrata base para todos os personagens
- **`profemon.java`** - Classe abstrata para personagens jogáveis
- **`inimigos.java`** - Classe abstrata para personagens inimigos
- **`inimigoPetista.java`** - Implementação concreta de um inimigo
- **`README.md`** - Documentação básica do projeto

### Recursos Gráficos
- **Sprints/** - Diretório contendo imagens dos personagens (formato PNG)

## Arquitetura do Sistema

### Hierarquia de Classes

```
personagens (abstract)
├── profemon (abstract)
└── inimigos (abstract)
    └── inimigoPetista (concrete)
```

### Classe Base: `personagens`

A classe abstrata `personagens` define a estrutura básica para todos os personagens do jogo:

**Atributos:**
- `nome`, `tipo` - Identificação do personagem
- `vida`, `ataque`, `defesa` - Atributos de combate
- `posicaoX`, `posicaoY` - Posição no campo de batalha
- `imagem`, `label` - Componentes gráficos

**Métodos Principais:**
- `atacarnormal` - Sistema de ataque com animação
- `receberDano` (abstrato) - Processamento de dano recebido
- `derrotado` (abstrato) - Ação quando o personagem é derrotado

### Classe `profemon`

Estende `personagens` e representa os personagens controlados pelo jogador:

**Funcionalidades:**
- **Sistema de Níveis:** Evolução através de experiência
- **Evolução:** Transformações nos níveis 16, 40 e máximo 100
- **Interface de Características:** Janela para visualizar status
- **Sistema de Revival:** Capacidade de ser revivido

**Métodos Destacados:**
- `evoluirdenivel` - Gerencia evolução por nível
- `mostrarCaracteristicas` - Exibe janela com informações
- `EliminouInimigo` - Ganha experiência ao derrotar inimigos

### Classe `inimigos`

Estende `personagens` e representa os adversários:

**Características:**
- **Sistema de Movimento:** Movimentação automática através do método `andar`
- **Velocidade:** Controla a rapidez do movimento
- **Recompensa:** Concede experiência quando derrotado

### Implementação Concreta: `inimigoPetista`

Primeira implementação concreta de um inimigo com:
- Vida: 13
- Ataque: 13
- Defesa: 13
- Sprite: "petista.png"

## Funcionalidades Implementadas

### Sistema de Combate
- Animações de ataque com movimento de projéteis
- Cálculo de dano baseado em ataque vs defesa
- Estados de derrota com mudança visual

### Sistema de Progressão
- Ganho de experiência (88 pontos para evolução)
- Evolução com aumento de atributos
- Evoluções especiais nos níveis 16 e 40

### Interface Gráfica
- Uso de `JLabel` e `ImageIcon` para sprites
- Janelas de informações com `JFrame`
- Animações através de `Thread.sleep()`

## Threading
O projeto utiliza a interface `Runnable` e threading para:
- Animações de movimento
- Movimentação contínua de inimigos
- Sincronização de ataques

## Estado Atual
O projeto está em desenvolvimento inicial com:
- ✅ Estrutura básica de classes implementada
- ✅ Sistema de combate funcional
- ✅ Mecânicas de evolução
- ❌ Classe principal `jogo` ainda não implementada
- ❌ Apenas um tipo de inimigo implementado (`inimigoPetista`)

## Próximos Passos Sugeridos
1. Implementar a classe `jogo` com loop principal
2. Adicionar mais tipos de inimigos
3. Implementar diferentes tipos de Profemon
4. Criar sistema de mapas/cenários
5. Adicionar interface de usuário mais robusta

## Tecnologias Utilizadas
- **Java** - Linguagem de programação principal
- **Swing** - Framework para interface gráfica
- **Threading** - Para animações e movimentação
- **ImageIcon** - Para carregamento e exibição de sprites

## Como Executar
1. Compile todos os arquivos `.java`
2. Execute a classe principal `jogo` (quando implementada)
3. Certifique-se de que o diretório `Sprints/` esteja na raiz do projeto

## Estrutura de Diretórios
```
Profemon/
├── jogo.java
├── personagens.java
├── profemon.java
├── inimigos.java
├── inimigoPetista.java
├── README.md
└── Sprints/
    └── *.png (sprites dos personagens)
```