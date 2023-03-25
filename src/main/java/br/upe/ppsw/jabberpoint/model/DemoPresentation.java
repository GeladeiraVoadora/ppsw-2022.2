package br.upe.ppsw.jabberpoint.model;

import java.io.FileNotFoundException;
import org.springframework.util.ResourceUtils;

public class DemoPresentation extends Accessor {

  public void loadFile(Presentation presentation, String unusedFilename)
      throws FileNotFoundException {

    presentation.setTitle("Apresentação de Demonstração");

    Slide slide;
    slide = new Slide();

    slide.setTitle("JabberPoint");
    slide.textAppend(1, "Ferramenta de Apresentação de Slides");
    slide.textAppend(2, "Copyright (c) 1996-now: Ian Darwin");
    slide.textAppend(2, "Copyright (c) 2021-now:");
    slide.textAppend(2, "Helaine Barreiros");
    slide.textAppend(4, "JabberPoint execução de demonstração sem arquivos persistidos");
    slide.textAppend(4, "exibição de apresentação com dados apenas em memória");
    slide.textAppend(1, "Navegação:");
    slide.textAppend(3, "Próximo slide: PgDn ou Enter");
    slide.textAppend(3, "Slide Anterior: PgUp ou up-arrow");
    slide.textAppend(3, "Parar: q ou Q");
    presentation.slideAppend(slide);

    slide = new Slide();
    slide.setTitle("Demonstração dos níveis e estilos de uma apresentação");
    slide.textAppend(1, "Nível 1");
    slide.textAppend(2, "Nível 2");
    slide.textAppend(1, "Novamente um item de Nível 1");
    slide.textAppend(1, "Nível 1 tem Estilo número 1");
    slide.textAppend(2, "Nível 2 tem Estilo número 2");
    slide.textAppend(3, "Este é um ítem de Nível 3");
    slide.textAppend(4, "E este é um ítem de Nível 4");
    presentation.slideAppend(slide);

    slide = new Slide();
    slide.setTitle("Terceiro Slide");
    slide.textAppend(1, "Para abrir uma nova apresentação,");
    slide.textAppend(2, "utilize o menu File->Open.");
    slide.textAppend(1, " ");
    slide.textAppend(1, "Fim da Apresentação");
    slide.itemAppend(
        new BitmapItem(1, ResourceUtils.getFile("classpath:JabberPoint.jpg").getAbsolutePath()));
    presentation.slideAppend(slide);
  }

  public void saveFile(Presentation presentation, String unusedFilename) {
    throw new IllegalStateException("Não é possível salvar arquivo na versão demo!");
  }

}
