package com.tts;

import java.util.Scanner;

public class TicTacToeRunner
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);

        char p = 'X';
        TicTacToeClass game = new TicTacToeClass();
        int r, c;

        while ( ! ( game.isWinner('X') || game.isWinner('O') || game.isFull() ) )
        {
            game.displayBoard();
            System.out.print( "'" + p + "', choose your location (row, column): " );
            r = keyboard.nextInt();
            c = keyboard.nextInt();

            while ( game.isValid(r,c) == false || game.playerAt(r,c) != ' ' )
            {
                if ( game.isValid(r,c) == false )
                    System.out.println("That is not a valid location. Try again.");
                else if ( game.playerAt(r,c) != ' ' )
                    System.out.println("That location is already full. Try again.");

                System.out.print( "Choose your location. The caveat is that  hit 'enter' after each number (row, column): " );
                r = keyboard.nextInt();
                c = keyboard.nextInt();
            }

            game.playMove( p, r, c );

            if ( p == 'X' )
                p = 'O';
            else
                p = 'X';

        }

        game.displayBoard();

        if ( game.isWinner('X') )
            System.out.println("X is the winner!");
        if ( game.isWinner('O') )
            System.out.println("O is the winner!");
        if ( game.isCat() )
            System.out.println("The game is a tie.");

    }
}