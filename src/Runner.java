import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Runner extends PApplet {
	
	PImage knight;
	ArrayList<Square> sequence;
	Square x = new Square(2,3,0);
	Knight jawnathan = new Knight(x,8,8);
	
	int rows;
	int cols;
	final int scale = 100;
	int count;
	
	public void settings(){
		size(800,800);
	}

	public void setup(){
		knight = loadImage("knight.png");
		rows = height/scale;
		cols = width/scale;
		count = 0;
		frameRate(10);
		sequence = jawnathan.solve();
	}

	public void draw(){
		//stops draw to avoid looping out of bounds of sequence
		if(count == sequence.size()-1) noLoop();
		
		for(int x = 0; x < cols; x++){
		    for(int y = 0; y < cols; y++){
		    	fill(255);
		        rect(x*scale,y*scale,scale,scale);
		    }
		}
    	Square currentSquare;
    	for(int i = 0; i <= count; i++) {
    		currentSquare = sequence.get(i);
    		fill(255,0,0);
    		rect(currentSquare.getColumn()*scale, currentSquare.getRow()*scale,scale,scale);
    	}
    	currentSquare = sequence.get(count);
    	image(knight,currentSquare.getColumn()*scale,currentSquare.getRow()*scale, width/(width/scale), height/(height/scale));
    	count++;
	}
	
	public static void main(String[] args){
		PApplet.main("Runner");
	}
}
