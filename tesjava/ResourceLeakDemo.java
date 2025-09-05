import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceLeakDemo {
    public static void main(String[] args) {
        System.out.println("リソースリークのデモを開始...");
        
        // 悪い例：リソースを閉じない
        for (int i = 0; i < 1000; i++) {
            try {
                // ファイルを開くが閉じない
                var writer = Files.newBufferedWriter(Paths.get("./temp" + i + ".log"));
                writer.write("データ " + i);
                // writer.close(); を忘れた！
                
                if (i % 100 == 0) {
                    System.out.println(i + "個のファイルを開きました");
                }
            } catch (IOException e) {
                System.err.println("エラーが発生しました（" + i + "回目）: " + e.getMessage());
                break;
            }
        }
        
        System.out.println("デモ終了");
    }
}
