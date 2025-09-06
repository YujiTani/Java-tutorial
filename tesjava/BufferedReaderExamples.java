import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BufferedReaderExamples {
    public static void main(String[] args) {
        System.out.println("=== BufferedReaderでできる処理例 ===\n");
        
        try {
            // 例1: 基本的なファイル読み込み
            example1_BasicReading();
            
            // 例2: 行数カウント
            example2_LineCount();
            
            // 例3: データ検索・フィルタリング
            example3_DataFiltering();
            
            // 例4: CSVデータの解析
            example4_CSVAnalysis();
            
            // 例5: ファイル変換処理
            example5_FileTransformation();
            
        } catch (IOException e) {
            System.out.println("エラー: " + e.getMessage());
        }
    }
    
    // 例1: 基本的なファイル読み込み
    private static void example1_BasicReading() throws IOException {
        System.out.println("【例1: 基本的なファイル読み込み】");
        
        try(var reader = Files.newBufferedReader(Paths.get("sample_data.txt"))) {
            String line;
            int lineNumber = 1;
            
            while((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        }
        System.out.println();
    }
    
    // 例2: 行数カウント
    private static void example2_LineCount() throws IOException {
        System.out.println("【例2: ファイルの行数をカウント】");
        
        try(var reader = Files.newBufferedReader(Paths.get("sample_data.txt"))) {
            long lineCount = reader.lines().count();
            System.out.println("ファイルの行数: " + lineCount + "行");
        }
        System.out.println();
    }
    
    // 例3: データ検索・フィルタリング
    private static void example3_DataFiltering() throws IOException {
        System.out.println("【例3: 特定条件でのデータ検索】");
        System.out.println("東京在住の人を検索:");
        
        try(var reader = Files.newBufferedReader(Paths.get("sample_data.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                if(line.contains("東京")) {
                    String[] parts = line.split(",");
                    System.out.println("名前: " + parts[0] + ", 年齢: " + parts[1] + ", 職種: " + parts[2]);
                }
            }
        }
        System.out.println();
    }
    
    // 例4: CSVデータの解析
    private static void example4_CSVAnalysis() throws IOException {
        System.out.println("【例4: データ解析（平均年齢計算）】");
        
        List<Integer> ages = new ArrayList<>();
        Map<String, Integer> jobCount = new HashMap<>();
        
        try(var reader = Files.newBufferedReader(Paths.get("sample_data.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                
                // 年齢を収集
                int age = Integer.parseInt(parts[1]);
                ages.add(age);
                
                // 職種の統計
                String job = parts[2];
                jobCount.put(job, jobCount.getOrDefault(job, 0) + 1);
            }
        }
        
        // 平均年齢計算
        double avgAge = ages.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("平均年齢: " + String.format("%.1f", avgAge) + "歳");
        
        // 職種別人数
        System.out.println("職種別人数:");
        jobCount.forEach((job, count) -> 
            System.out.println("  " + job + ": " + count + "人")
        );
        System.out.println();
    }
    
    // 例5: ファイル変換処理
    private static void example5_FileTransformation() throws IOException {
        System.out.println("【例5: データ変換してHTMLファイル作成】");
        
        try(var reader = Files.newBufferedReader(Paths.get("sample_data.txt"));
            var writer = Files.newBufferedWriter(Paths.get("employee_table.html"))) {
            
            // HTML開始
            writer.write("<html><body>\n");
            writer.write("<h2>従業員一覧</h2>\n");
            writer.write("<table border='1'>\n");
            writer.write("<tr><th>名前</th><th>年齢</th><th>職種</th><th>勤務地</th></tr>\n");
            
            // データ行を読んでHTMLテーブル行に変換
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                writer.write("<tr>");
                for(String part : parts) {
                    writer.write("<td>" + part + "</td>");
                }
                writer.write("</tr>\n");
            }
            
            // HTML終了
            writer.write("</table>\n");
            writer.write("</body></html>\n");
            
            System.out.println("HTMLファイル 'employee_table.html' を作成しました");
        }
        System.out.println();
    }
}
