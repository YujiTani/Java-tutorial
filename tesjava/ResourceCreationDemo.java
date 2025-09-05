import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceCreationDemo {
    public static void main(String[] args) {
        System.out.println("=== リソース作成の流れ ===");
        
        // この行で何が起きているか詳しく見てみましょう
        try(var writer = Files.newBufferedWriter(Paths.get("./demo.log"))) {
        //  ↑      ↑           ↑
        //  変数名   作成される   ファイルパス
        //          リソース
            
            System.out.println("1. Files.newBufferedWriter() が呼ばれました");
            System.out.println("   → demo.log ファイルを書き込み用に開いています");
            System.out.println("   → writerという変数にそのリソースを代入");
            System.out.println("");
            
            System.out.println("2. now writer can be used:");
            writer.write("Hello from inside try block!");
            writer.newLine();
            writer.write("This is line 2");
            
            System.out.println("3. tryブロックの終わりに到達しました");
            System.out.println("   → writer.close() が自動的に呼ばれます！");
            
        } catch (IOException e) {
            System.out.println("エラーが発生しました: " + e.getMessage());
            System.out.println("でも、writerは自動的に閉じられます！");
        }
        
        System.out.println("4. tryブロックを出ました");
        System.out.println("   → writerはもう使えません（閉じられたから）");
        
        // ここで writer を使おうとするとコンパイルエラー
        // writer.write("これはエラー!"); // 変数のスコープ外
    }
}
