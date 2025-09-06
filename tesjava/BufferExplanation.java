import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BufferExplanation {
    public static void main(String[] args) throws IOException {
        System.out.println("=== バッファーとは何か？ ===\n");
        
        System.out.println("【日常の例】郵便配達");
        System.out.println("❌ 悪い例：手紙1通ずつ郵便局に持参");
        System.out.println("   → 時間がかかる、効率が悪い");
        System.out.println("");
        System.out.println("✅ 良い例：手紙をまとめてポストに投函");
        System.out.println("   → まとめて処理、効率的");
        System.out.println("   → ポスト = バッファー（一時保管場所）");
        System.out.println("");
        
        demonstrateBufferVsNonBuffer();
    }
    
    private static void demonstrateBufferVsNonBuffer() throws IOException {
        System.out.println("【プログラムでの比較】");
        
        // BufferedWriter使用（バッファーあり）
        System.out.println("\n✅ BufferedWriter（バッファーあり）:");
        long startTime = System.currentTimeMillis();
        
        try(var bufferedWriter = Files.newBufferedWriter(Paths.get("./buffered.txt"))) {
            System.out.println("1. メモリ内のバッファー（一時保管場所）を作成");
            
            for(int i = 0; i < 1000; i++) {
                bufferedWriter.write("データ行 " + i + "\n");
                if(i == 0) System.out.println("2. データをバッファーに書き込み中...");
                if(i == 500) System.out.println("3. まだバッファーに蓄積中...");
            }
            System.out.println("4. tryブロック終了時にバッファーの内容を一括でファイルに書き込み");
        }
        
        long bufferedTime = System.currentTimeMillis() - startTime;
        System.out.println("   処理時間: " + bufferedTime + "ms");
        
        // 通常のFileWriter（バッファーなし）- 比較用
        System.out.println("\n❌ FileWriter（バッファーなし）:");
        startTime = System.currentTimeMillis();
        
        try(var fileWriter = new FileWriter("./unbuffered.txt")) {
            System.out.println("1. ファイルに直接書き込み");
            
            for(int i = 0; i < 1000; i++) {
                fileWriter.write("データ行 " + i + "\n");
                if(i == 0) System.out.println("2. 1行書くたびにディスクアクセス");
                if(i == 500) System.out.println("3. まだ1行ずつディスクに書き込み中...");
            }
            System.out.println("4. 全ての行でディスクアクセスが発生");
        }
        
        long unbufferedTime = System.currentTimeMillis() - startTime;
        System.out.println("   処理時間: " + unbufferedTime + "ms");
        
        System.out.println("\n【結果】");
        System.out.println("バッファーあり: " + bufferedTime + "ms");
        System.out.println("バッファーなし: " + unbufferedTime + "ms");
        if(unbufferedTime > bufferedTime) {
            System.out.println("→ バッファーの方が " + (unbufferedTime - bufferedTime) + "ms 速い！");
        }
    }
}
