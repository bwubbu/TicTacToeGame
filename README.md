# Tic Tac Toe Game

A classic Tic Tac Toe (Noughts and Crosses) game implemented in Java with a graphical user interface. Play against another player in this timeless two-player strategy game.

## 🎮 Overview

This is a desktop implementation of the popular Tic Tac Toe game using Java Swing. The game features an interactive 3x3 grid where two players take turns marking spaces with either X or O, with the first to get three in a row winning the game.

## ✨ Features

- **Two-Player Gameplay**: Play against another human player
- **Graphical User Interface**: Interactive grid-based board using Java Swing
- **Real-time Game Status**: Live display of current player and game result
- **Win Detection**: Automatic detection of winning conditions (horizontal, vertical, diagonal)
- **Draw Detection**: Recognizes when the board is full with no winner
- **Reset Functionality**: Start a new game anytime
- **Visual Feedback**: Clear display of X and O marks with intuitive UI

## 📋 Game Rules

- Players alternate turns, with one player using X and the other using O
- Players click on empty cells to place their mark
- First player to get three marks in a row (horizontal, vertical, or diagonal) wins
- If all 9 cells are filled with no winner, the game is a draw
- Players can reset and start a new game at any time

## 🎯 Winning Conditions

A player wins by getting three of their marks in a row:

```
Horizontal:    Vertical:      Diagonal:
X | _ | _      X | _ | _      X | _ | _
---------      ---------      ---------
X | _ | _      _ | X | _      _ | X | _
---------      ---------      ---------
X | _ | _      _ | _ | X      _ | _ | X

Diagonal:
_ | _ | X
---------
_ | X | _
---------
X | _ | _
```

## 📁 Project Structure

```
TicTacToeGame/
├── README.md                           # This file
├── .vscode/                            # VS Code configuration
│
├── src/                                # Source code
│   ├── TicTacToe.java                 # Main game class
│   ├── TicTacToe.class                # Compiled main class
│   ├── TicTacToe$Cell.class           # Compiled Cell inner class
│   └── TicTacToe$Cell$MyActionListener.class  # Compiled action listener
│
└── bin/                                # Compiled binaries directory
```

## 🛠️ Technologies Used

- **Language**: Java 100%
- **GUI Framework**: Java Swing
- **Build Tool**: Java Compiler (javac)
- **IDE Support**: VS Code

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/bwubbu/TicTacToeGame.git
cd TicTacToeGame
```

2. Compile the Java source:
```bash
javac src/TicTacToe.java
```

3. Run the game:
```bash
java -cp src TicTacToe
```

## 🎮 How to Play

1. **Launch the game** - Run the compiled program
2. **See the board** - A 3x3 grid appears with empty cells
3. **Player X starts** - Click any empty cell to place an X
4. **Player O's turn** - The opponent clicks an empty cell to place an O
5. **Alternate turns** - Players continue clicking cells to place their marks
6. **Win or Draw** - The game announces the winner or declares a draw
7. **Play again** - Click the reset button to start a new game

## 🏗️ Code Structure

### Main Class: TicTacToe
- Manages the game window and overall game logic
- Initializes the 3x3 grid of buttons
- Handles game state (current player, game over status)
- Implements win/draw detection
- Provides reset functionality

### Inner Class: Cell
- Represents each cell in the game board
- Extends JButton for interactive UI
- Stores cell state (empty, X, or O)
- Handles click events

### Inner Class: MyActionListener
- Implements ActionListener for cell clicks
- Processes player moves
- Updates game state
- Checks for win/draw conditions
- Updates UI display

## 🧮 Game Algorithm

### Win Detection
The game checks for three consecutive marks in:
1. **All rows**: Three X's or O's in horizontal lines
2. **All columns**: Three X's or O's in vertical lines
3. **Both diagonals**: Three X's or O's in diagonal lines

### Draw Detection
- Triggered when all 9 cells are filled
- No three-in-a-row exists for either player

### Turn Management
- Alternates between X and O after each valid move
- Prevents moves on already-filled cells
- Displays current player

## 🖼️ User Interface

The game features:
- **3x3 Button Grid**: Interactive cells for gameplay
- **Status Display**: Shows current player or game result
- **Reset Button**: Start a new game
- **Clear Visual Design**: Easy-to-read board layout
- **Responsive Buttons**: Immediate feedback on clicks

## 🎓 Educational Value

This project demonstrates:
- Java GUI programming with Swing
- Event-driven programming (ActionListener)
- Inner classes and nested classes
- 2D game logic and state management
- Win condition algorithms
- Object-oriented design principles
- User interaction handling

## 🔄 Game Flow

```
Start Game
    ↓
Initialize empty 3x3 board
    ↓
Display board with status "Player X's turn"
    ↓
→ Player X clicks a cell
    ↓
    Check if cell is empty
    ├─ Yes: Place X, check for win/draw
    │        ├─ X wins: Display "Player X Wins!", offer reset
    │        ├─ Draw: Display "Draw!", offer reset
    │        └─ Continue: Switch to Player O
    └─ No: Do nothing, wait for valid move
    ↓
→ Player O clicks a cell
    ↓
    (Same validation and flow as above)
    ↓
Loop until win or draw
```

## 🎨 Customization

You can easily modify:
- **Board size**: Change grid dimensions (e.g., 4x4 for larger game)
- **Colors**: Customize button and text colors
- **Fonts**: Change font sizes and styles
- **Win condition**: Modify to require 4 in a row
- **Game modes**: Add single-player vs AI option

## 🧪 Testing the Game

1. **Test X Win**: Place 3 X's in a row (horizontal, vertical, or diagonal)
2. **Test O Win**: Have O player get 3 in a row
3. **Test Draw**: Fill all cells without creating three-in-a-row
4. **Test Invalid Moves**: Try clicking an already-filled cell
5. **Test Reset**: Verify new game clears the board

## 🐛 Known Limitations

- Two-player only (no AI opponent)
- No move history or undo feature
- No game statistics or scoring
- No difficulty levels
- Fixed 3x3 board size

## 💡 Future Enhancements

- Add single-player mode with AI opponent
- Implement difficulty levels
- Add move history and undo feature
- Support different board sizes
- Add game statistics and win counter
- Implement networked multiplayer
- Add sound effects and animations

## 🤝 Contributing

Feel free to fork this project and submit pull requests for improvements!

## 📝 License

Open source - available for educational and personal use.

## 📧 Contact

For questions or suggestions about the Tic Tac Toe Game, feel free to open an issue in the repository.

---

**Status**: Complete  
**Language**: Java (100%)  
**Last Updated**: November 2023
