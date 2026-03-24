# Snake and Ladder Design System

This repository contains the Object-Oriented Design implementation of a Snake & Ladder game.

## Design Decisions
1. **Delegation over Implementation:** The `Game` class loop serves purely as a conductor, relying on composed structures to process rules.
2. **Strategy Pattern:** `MakeMoveStrategy` allows decoupling movement rules (like multiple 6s resetting) into `EasyMoveStrategy` or `HardMoveStrategy`.
3. **Factory Pattern:** `GameFactory` and `BoardFactory` abstract away the complex object wiring steps. Random entities are placed ensuring no cycles are created using the `EntityGenerationStrategy`.

## 📊 Visual UML Diagram (Snake & Ladder)

```mermaid
classDiagram
    class Game {
        -Board board
        -Queue players
        -MakeMoveStrategy strategy
        +play()
    }
    class Board {
        -int size
        -Map entities
        +resolvePosition(int pos)
    }
    class Player {
        -String name
        -int position
    }
    class Dice {
        +roll() int
    }
    class BoardEntity {
        <<interface>>
        +getStart() int
        +getEnd() int
    }
    class MakeMoveStrategy {
        <<abstract>>
        +makeMove(Player, Dice, Board)
    }
    class EntityGenerationStrategy {
        <<interface>>
        +generateEntities(int size, int count) List
    }
    class RandomEntityGenerationStrategy {
        +generateEntities(int size, int count) List
    }
    class RuleBasedEntityGenerationStrategy {
        +generateEntities(int size, int count) List
    }
    class BoardFactory {
        -EntityGenerationStrategy strategy
        +createBoard(int size, int snakes, int ladders) Board
    }
    class GameFactory {
        +createGame(int size, int players, String diff, EntityGenerationStrategy strat) Game
    }
    
    Game *-- Board
    Game *-- Dice
    Game o-- Player
    Game --> MakeMoveStrategy
    Board "1" *-- "many" BoardEntity
    BoardEntity <|.. Snake
    BoardEntity <|.. Ladder
    MakeMoveStrategy <|-- EasyMakeMoveStrategy
    MakeMoveStrategy <|-- HardMakeMoveStrategy
    EntityGenerationStrategy <|.. RandomEntityGenerationStrategy
    EntityGenerationStrategy <|.. RuleBasedEntityGenerationStrategy
    BoardFactory o-- EntityGenerationStrategy
    GameFactory ..> BoardFactory
    GameFactory ..> Game
    GameFactory ..> MakeMoveStrategy





```
