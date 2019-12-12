# TheBraveRats
The game is not completed. What I finished now is a very very rough cmd version of the real game.

Version
- 1.0(beta): implement the basic card battle framework.
- 2.0(20191207): add magic function.
- 3.0(20191212): add PVP function, improve UI.

TODO List:
- create a better AI

# Game Idea
"
The goal of the game is to win four rounds of battle.

Each player takes the eight cards of their color. Each player secretly chooses a card, places it face down, and then both players reveal simultaneously. The higher number wins the round—except that each rat has a special ability that can come into play.

Here are the various rats and their powers:

<li>7 – Prince: You win the round.</li>
<li>6 – General: The next card you play gets +2 strength.</li>
<li>5 – Wizard: Nullify your opponent’s special ability.</li>
<li>4 – Ambassador: If you win, it counts as 2 rounds.</li>
<li>3 – Assassin: The lower strength wins instead.</li>
<li>2 – Spy: Next round, you choose a card after your opponent reveals theirs.</li>
<li>1 – Princess: If your opponent plays the Prince you win the whole game.</li>
<li>0 – Musician: This round is on hold.</li>

There are a couple of clarifications that explain some of the interactions—for instance, the Prince’s ability (“win the round”) trumps the Assassin’s ability (“lower strength wins”). When a Musician is played, it means the winner of the next round gets both victories.

The game lasts until one player wins four rounds, or both players are out of cards—in which case it’s a draw.
"

Source: http://geekdad.com/2014/06/braverats/

This game is designed by <i>Seiji Kanai</i>

# Run Instruction

- Install Java and set Path (if it's not already in place)
  - example: `set PATH=C:\Program Files\Java\jdk1.8.0_161\bin`
  - example: `set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_161`
- Open cmd window, cd to project directory
  - example: `cd .\the-brave-rats-master`
- Build
  - example: `javac -d output\production\the-brave-rats-master src\com\north\application\*.java src\com\north\cardspack\*.java src\com\north\gamecore\*.java`
- Run
  - example: cd to output directory, `cd output\production\the-brave-rats-master`
  - example: `java -cp . com.north.application.PVP`
