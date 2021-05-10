import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {

        File games = new File("E://Games");
        creatorDirectory(games);
        File src = new File("E://Games//src");
        creatorDirectory(src);
        File res = new File("E://Games//res");
        creatorDirectory(res);
        File savegames = new File("E://Games//savegames");
        creatorDirectory(savegames);
        File temp = new File("E://Games//temp");
        creatorDirectory(temp);
        File srcMain = new File("E://Games//src//main");
        creatorDirectory(srcMain);
        File test = new File("E://Games//src//test");
        creatorDirectory(test);
        File srcMainJava = new File(srcMain, "Main.java");
        creatorFile(srcMainJava);
        File srcUtilsJava = new File(srcMain, "Utils.java");
        creatorFile(srcUtilsJava);
        File drawables = new File(res, "drawables");
        creatorDirectory(drawables);
        File vectors = new File(res, "vectors");
        creatorDirectory(vectors);
        File icons = new File(res, "icons");
        creatorDirectory(icons);

        try (FileOutputStream fos = new FileOutputStream("E://Games//temp//temp.txt")) {
            log.append("Файл temp.txt создан\n");
            // перевод в массив байтов
            byte[] bytes = log.toString().getBytes();
            // запись байтов в файл
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void creatorDirectory(File file) {
        if (file.mkdir()) {
            log.append("Директория  ").append(file.getName()).append(" создана\n");
        }
    }

    public static void creatorFile(File file) {
        try {
            if (file.createNewFile())
                log.append("Файл  ").append(file.getName()).append(" создан\n");
        } catch (IOException ex) {
            log.append(ex.getMessage());
        }
    }
}
