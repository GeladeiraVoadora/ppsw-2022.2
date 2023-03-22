package br.upe.ppsw.jabberpoint.model;

public abstract class SlideItem {

  private int level = 0;

  public SlideItem(int lev) {
    level = lev;
  }

  public SlideItem() {
    this(0);
  }

  public int getLevel() {
    return level;
  }
  
  // Métodos abstrados de desenhar tela passado para a classe Draw em view
}
