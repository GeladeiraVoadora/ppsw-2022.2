package br.upe.ppsw.jabberpoint.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;

public class DrawSlide extends Draw {

	private Slide slide = new Slide();
	
	@Override
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {
		// TODO Auto-generated method stub
		
	}
	
	  public int getSize() {
		    return slide.getSlideItems().size();
		  }

		  public void draw(Graphics g, Rectangle area, ImageObserver view) {
		    float scale = getScale(area);

		    int y = area.y;

		    SlideItem slideItem = slide.getTitleNotString();
		    Style style = Style.getStyle(slideItem.getLevel());
		    draw(area.x, y, scale, g, style, view);

		    y += getBoundingBox(g, view, scale, style).height;

		    for (int number = 0; number < getSize(); number++) {
		      slideItem = slide.getSlideItem(number);

		      style = Style.getStyle(slideItem.getLevel());
		      draw(area.x, y, scale, g, style, view);

		      y += getBoundingBox(g, view, scale, style).height;
		    }
		  }

		  private float getScale(Rectangle area) {
		    return Math.min(((float) area.width) / ((float) WIDTH),
		        ((float) area.height) / ((float) HEIGHT));
		  }

}
