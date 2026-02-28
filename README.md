# TicTacToe-Java

A Java implementation of Tic-Tac-Toe that can run **single games or multi-round tournaments** with a configurable **board size** and **win streak**, plus pluggable **player strategies** and **renderers**. :contentReference[oaicite:1]{index=1}

## Features
- Play tournaments for a given number of rounds (alternates who starts each round). :contentReference[oaicite:2]{index=2}
- Configurable board size and win condition (`winStreak`). :contentReference[oaicite:3]{index=3}
- Player strategies:
  - `human` (interactive)
  - `whatever` (random empty cell)
  - `naive` (first empty cell, scanning rows/cols)
  - `smart` (biased strategy + randomness) :contentReference[oaicite:4]{index=4}
- Renderers:
  - `console` (prints the board)
  - `void` (no output; useful for fast tournaments) :contentReference[oaicite:5]{index=5}
## Build
From the repo root:

```bash
javac -d bin src/*.java
```
##Run
java -cp bin Tournament <rounds> <size> <winStreak> <renderer> <player1> <player2>
