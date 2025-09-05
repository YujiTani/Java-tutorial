import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleExample {
    public static void main(String[] args) {
        System.out.println("=== 図書館の例で考えてみましょう ===");
        System.out.println("1. 図書館で本を借りる（ファイルを開く）");
        System.out.println("2. 本を読む（ファイルに書き込む）");
        System.out.println("3. 本を返す（ファイルを閉じる）");
        System.out.println("");
        
        System.out.println("もし本を返さなかったら？");
        System.out.println("→ 他の人が借りられなくなる");
        System.out.println("→ ファイルも同じ！");
    }
}
