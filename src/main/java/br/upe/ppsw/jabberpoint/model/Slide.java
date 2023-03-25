package br.upe.ppsw.jabberpoint.model;

import java.util.Vector;

public class Slide {
	
	//Coloquei as constantes com o tamanho dos slides no na classe Draw
	
  private TextItem title;
  protected Vector<SlideItem> items;

  public Slide() {
    items = new Vector<SlideItem>();
  }

  public void itemAppend(SlideItem anItem) {
    items.addElement(anItem);
  }

  public String getTitle() {
    return getTitleNotString().getText();
  }

  public void setTitle(String newTitle) {
    setTitleNotString(new TextItem(0, newTitle));
  }

  public void textAppend(int level, String message) {
    itemAppend(new TextItem(level, message));
  }

  public SlideItem getSlideItem(int number) {
    return (SlideItem) items.elementAt(number);
  }

  public Vector<SlideItem> getSlideItems() {
    return items;
  }


  public TextItem getTitleNotString() {
	return title;
}


  public void setTitleNotString(TextItem title) {
	this.title = title;
}

}
