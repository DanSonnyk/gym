package fundamentals.chalengers.leetcode.various;
/*
Objective

You make wooden toys in your woodworking shop for the enjoyment of your grandchildren. You have planned a series of
small puzzles, and you would like to automate the writing of their solutions.

Rules

 - Each puzzle is a grid, on which wooden blocks are placed. These blocks must be taken out of the game,
one after the other, without colliding. You have to determine their movement sequence.

Each block is numbered with a value between 0 and 9. When you enter te number of a block and a direction,
it will be moved until it is off the grid.

if more than one block can be taken out at the same time, you can choose which one you would like to remove first.

if a block can be taken out to many directions, you can choose any one of them.

Implementation:

Implement the method solve(width, height, nbBlocks, gird). This method is executed at each round of the game and
should return the number of the next block to move, and it's direction.

Input data of the method:

width: width of the puzzle, in number of cells.
height: height of the puzzle, in number of cells.
nb_blocks: number of blocks initially present in the puzzle.
grid: a list of height elements, each of which is a string with a size equal to width.

The parameters width, height and nb_blocks do not change during the whole game.

The grid parameter represents the current situation of the puzzle.
Each of its characters can take one of the following values:

. (a dot): an empty square.
    X: a wall. They are placed on the first and last line, as well as on the first character of each line,
    to show that the only possible exit is to the right. You cannot move these walls.
    an integer between 0 and nb_blocks-1: a square occupied by a block. The same number can be present several
    times in the grid, representing a single block that extends over several squares. All cells with the same
    block number are connected (they are never separated into several isolated groups).
    Output data of the method
    An integer, between 0 and nb_blocks-1, representing the number of the block you want to output to the right.
    You can only move one block at a time, and each move must always be to the right. A move is made until the end:
     either until the block is completely out, or until one block collides with another.
    Victory conditions
    All blocks are out of the game.
    (There is at least one possible block removal order that will yield a solution.)
    Defeat conditions
    A collision occurs between the block you moved and a block on the grid.
    Constraints
    1 < width < 15
    1 < height < 15
    1 ≤ nb_blocks < 10
*/

public class BoxPuzzle {
    public static void main(String[] args) {
        String[] grid = {"X", ".","8","3","4", "X"};
        String result = solve(6, 6, 5, grid);
    }

    public static String solve(int width, int height, int nbBlocks, String[] grid){
        String[][] puzzle = new String[width][height];
        String name = "DanielSimiaodaSilva";

        return "";
    }
}
