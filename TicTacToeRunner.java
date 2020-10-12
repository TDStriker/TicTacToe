package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JFrame;

public class TicTacToeRunner
{
	public static void main(String[] args) {
		graphical();
		
//		textBased();
	}
	
	public static void graphical() {
		JFrame frame = new JFrame("Tic Tac Toe");
//		TextArea console = new TextArea();
		
//		console.
//		console.
		
		frame.setBounds(0,0,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(console,BorderLayout.SOUTH);
		
		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Object source = e.getSource();
				
				System.out.println("Mouse Click at (" + e.getPoint().x + "," + e.getPoint().y + ")");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Enter");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Exit");
			}
			
		});
		
		frame.setVisible(true);
		
	}
	
    public static void textBased()
    {
        Scanner reply = new Scanner(System.in);
        Scanner replyI = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        String p1;
        String p2;
        
        System.out.println(" _______  _______   _____   	 _______      __       _____       _______   _______   _______             \n"
        				 + "|__   __||__   __| /  __ \\ 	|__   __|    /  \\     / ___ \\	  |__   __| /  ___  \\ |  _____|    \n"
        				 + "   | |      | |    | |  \\_|	   | |      / /\\ \\    | |  \\_|       | |    | |   | | | |_____          \n"
        				 + "   | |      | |    | |   _  	   | |     / /__\\ \\   | |   _        | |    | |   | | |  _____|         \n"
        				 + "   | |    __| |__  | |__/ | 	   | |    / /    \\ \\  | |__/ |       | |    | |___| | | |_____          \n"
        				 + "   |_|   |_______| \\_____/ 	   |_|   /_/      \\_\\ \\_____/        |_|    \\_______/ |_______|                \n");
        
        System.out.println("Would you like to play a round of TicTacToe (y or n)");
        String play = reply.nextLine();
        while(play.equalsIgnoreCase("y")) {
        	game.reset();
        	
        	System.out.println("Is player 1 (X) human or computer (h or c)");
        	p1 = reply.nextLine();
        	System.out.println("Is player 2 (O) human or computer (h or c)");
        	p2 = reply.nextLine();
        	
        	while(!game.gameOver()){
            	if(game.getTurn() % 2 == 0) {
            		game.printBoard();
            		if(p1.equalsIgnoreCase("h")) {
	    	            System.out.println("Where would you like to place your letter?");   
	    	            System.out.println("Row?");
	    	            int row = replyI.nextInt();
	    	            System.out.println("Column?");
	    	            int col = replyI.nextInt();
	    	            if(game.spaceValid(row,col)){
	    	                game.takeTurn(row,col);
	    	            }else{
	    	                System.out.println("Invalid option, pick again");
	    	            }
            		}else {
                		TicTacToeAI.takeTurn(game);
            		}
            	}else {
            		game.printBoard();
            		if(p2.equalsIgnoreCase("h")) {
	    	            System.out.println("Where would you like to place your letter?");   
	    	            System.out.println("Row?");
	    	            int row = replyI.nextInt();
	    	            System.out.println("Column?");
	    	            int col = replyI.nextInt();
	    	            if(game.spaceValid(row,col)){
	    	                game.takeTurn(row,col);
	    	            }else{
	    	                System.out.println("Invalid option, pick again");
	    	            }
            		}else {
                		TicTacToeAI.takeTurn(game);
            		}
            	}
            }
            game.printBoard();
            if(game.checkWin()){
                System.out.println(((game.getTurn() % 2 == 1) ? "X":"O") + " Wins!");
            }else{
                System.out.println("TIE");
            }
            
            System.out.println("Would you like to play another round (y or n)");
            play = reply.nextLine();
        }
        System.out.println("Thank you for playing");
        reply.close();
        replyI.close();
    }
}
