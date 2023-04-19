package br.upe.ppsw.jabberpoint.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.model.BitmapItem;

public class DrawBitmapItem extends Draw {
	
	private BitmapItem bitmapitem = new BitmapItem();

	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
		    return new Rectangle((int) (myStyle.getIndent() * scale), 0,
		        (int) (bitmapitem.getBufferedImage().getWidth(observer) * scale),
		        ((int) (myStyle.getLeading() * scale)) + (int) (bitmapitem.getBufferedImage().getHeight(observer) * scale));
		  }

	public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
		    int width = x + (int) (myStyle.getIndent() * scale);
		    int height = y + (int) (myStyle.getLeading() * scale);

		    g.drawImage(bitmapitem.getBufferedImage(), width, height, (int) (bitmapitem.getBufferedImage().getWidth(observer) * scale),
		        (int) (bitmapitem.getBufferedImage().getHeight(observer) * scale), observer);
		  }

}
