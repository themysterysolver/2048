## 2048
### HISTORY
- **2048** is a single-player sliding tile puzzle video game written by Italian web developer *Gabriele Cirulli* and published on GitHub.
- The objective of the game is to slide numbered tiles on a grid to combine them to create a tile with the number 2048.
- Nineteen-year-old Gabriele Cirulli created the game in a single weekend as a test to see if he could program a game from scratch
## HOW IT LOOKS!
<img src="https://github.com/user-attachments/assets/9d6103b0-f209-461b-8409-790ad7cb62b4" width="300"/>
<img src="https://github.com/user-attachments/assets/fdcce47a-d25a-4e3c-a099-00b95ecc3c5b" width="300"/>
<img src="https://github.com/user-attachments/assets/83e39dc8-f9e0-4e62-95b3-57772add5847" width="300"/>

> **KEY CONTROL** use arrow keys for tile movements


## 2048 Mechanics
- 2048 is played on a plain 4×4 grid, with numbered tiles that slide when a player moves them using the four arrow keys.
- The game begins with two tiles already in the grid, having a value of either **2** or **4**.
- After each turn, another tile (either 2 or 4) appears in a random empty space.
  - Tiles with a value of **2** appear 90% of the time.
  - Tiles with a value of **4** appear 10% of the time.
- Tiles slide as far as possible in the chosen direction until stopped by either another tile or the edge of the grid.
- If two tiles of the same number collide while moving, they merge into a single tile with the **sum** of their values.
- The resulting merged tile **cannot merge again** in the same move.
- Special merge behavior:
  - If **three consecutive tiles** of the same value slide together, **only the two farthest along the direction of motion** will merge.
  - If **all four** spaces in a row or column have the same value, a parallel move will **combine the first two and the last two**.
- A scoreboard in the upper-right keeps track of the player's score:
  - The score starts at **zero**.
  - The score increases whenever tiles combine, by the **value of the new tile**.
- The game is **won** when a tile with a value of **2048** appears.
- Players can **continue playing** to reach higher scores beyond 2048.
- The game **ends** when the player has **no legal moves** (no empty spaces and no adjacent tiles with the same value).
- The **largest possible tile** is **131,072**.

## WHY THIS REPO?

- I wnated to recreate what *Gabriele Cirulli* over  a week.
- I love to develop
- I wnated to revise my java skills and also learn more about jar creation and usage
- I love to solve problems

## REPO TREE
```
.
├── PROTOTYPE IN JAVA
│   ├── 2048Game.jar
│   ├── GUI2048.java
│   ├── Game2048.java
│   ├── GameLogic.java
│   ├── JAR_MAKE.md
│   ├── MANIFEST.MF
│   ├── Tile.java
│   └── out
│       ├── GUI2048$1.class
│       ├── GUI2048.class
│       ├── Game2048.class
│       ├── GameLogic.class
│       ├── Tile.class
│       └── production
│           └── PROTOTYPE IN JAVA
│               ├── 2048Game.jar
│               ├── GUI2048$1.class
│               ├── GUI2048.class
│               ├── Game2048.class
│               ├── GameLogic.class
│               ├── JAR_MAKE.md
│               ├── MANIFEST.MF
│               └── Tile.class
└── THEORY
    └── 2048_Theory.pdf
```
- `THEORY` - It describes game play and detailed math veiew on 2048 game.
- `PROTOTYPE IN JAVA` - this is the dir where main code logic is written
  - `Game2048.java` it is just a starter program
  - `GUI2048.java` it is the starting point of GUI and where all GUI handling is done with event loop mechanism
  - `GameLogic.java` it contains the game logic,tile generations and game play
  - `MANIFEST.MF` helps creating jar
---

