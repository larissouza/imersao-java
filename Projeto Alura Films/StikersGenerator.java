import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;


import javax.imageio.ImageIO;

public class StikersGenerator {
    

    public void criar() throws Exception {
        //fazer a leitura da imagem
        InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_9.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar img nova em memoria com tranparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getWidth();
        int novaAltura = altura + 1300;
        BufferedImage novaImagem = new BufferedImage (largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar imagem original para nova imagem em memoria
        Graphics2D graphics =(Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

          // configurar a fonte
          var fonte = new Font(Font.MONOSPACED, Font.TYPE1_FONT, 200);
          graphics.setColor(Color.yellow);
          graphics.setFont(fonte);
        
        //escreve uma frase na nova imagem
        graphics.drawString("PRECIOOOOOSO", 300, novaAltura - 150);
        
        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/filme.jpg"));
    }

    public static void main(String[] args) throws Exception {
       var geradora = new StikersGenerator();
       geradora.criar();

    }
}
