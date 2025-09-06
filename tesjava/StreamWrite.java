import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.nio.file.StandardOpenOption;

// ファイルの書き込みをするクラス
public class StreamWrite {
  public static void main(String[] args) {
    try(var writer = Files.newBufferedWriter(Paths.get("./data.log"), StandardOpenOption.APPEND)) {
      writer.write(LocalDateTime.now().toString());
      writer.newLine();
      writer.write("日本語を書き込み");
      writer.newLine();
      writer.write("改行後にさらに追記");
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}

