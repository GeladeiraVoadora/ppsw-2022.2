package br.upe.ppsw.jabberpoint.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.List;

import br.upe.ppsw.jabberpoint.model.TextItem;

public class DrawTextItem extends Draw{
	
	private TextItem textItem = new TextItem();
	
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
	    List<TextLayout> layouts = textItem.getLayouts(g, myStyle, scale);

	    int xsize = 0, ysize = (int) (myStyle.getLeading() * scale);

	    Iterator<TextLayout> iterator = layouts.iterator();

	    while (iterator.hasNext()) {
	      TextLayout layout = iterator.next();
	      Rectangle2D bounds = layout.getBounds();

	      if (bounds.getWidth() > xsize) {
	        xsize = (int) bounds.getWidth();
	      }

	      if (bounds.getHeight() > 0) {
	        ysize += bounds.getHeight();
	      }
	      ysize += layout.getLeading() + layout.getDescent();
	    }

	    return new Rectangle((int) (myStyle.getIndent() * scale), 0, xsize, ysize);
	  }

	public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) {
	    if (textItem.getText() == null || textItem.getText().length() == 0) {
	      return;
	    }
	    
	    List<TextLayout> layouts = textItem.getLayouts(g, myStyle, scale);
	    Point pen = new Point(x + (int) (myStyle.getIndent() * scale), y + (int) (myStyle.getLeading() * scale));

	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(myStyle.getColor());

	    Iterator<TextLayout> it = layouts.iterator();

	    while (it.hasNext()) {
	      TextLayout layout = it.next();

	      pen.y += layout.getAscent();
	      layout.draw(g2d, pen.x, pen.y);

	      pen.y += layout.getDescent();
	    }
	}
	
}
