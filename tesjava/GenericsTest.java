import java.util.List;
import java.util.ArrayList;

public class GenericsTest {
  public static void main(String[] args) {
    List<String> data = new ArrayList<>();
    data.add("あいうえお");
    System.out.println(data);
    
    // dataの型を出力
    System.out.println("dataの型: " + data.getClass().getName());
    System.out.println("dataの型 (簡易表示): " + data.getClass().getSimpleName());

    var arr = new ArrayList<>();
    arr.add("かきくけこ");
    System.out.println(arr);
    
    // arrの型を出力
    System.out.println("arrの型: " + arr.getClass().getName());
    System.out.println("arrの型 (簡易表示): " + arr.getClass().getSimpleName());
    
    // より詳細な型情報
    System.out.println("\n=== 詳細な型情報 ===");
    System.out.println("data - クラス名: " + data.getClass());
    System.out.println("arr - クラス名: " + arr.getClass());
    
    // 変数の実際の内容と型の関係を確認
    System.out.println("\n=== 変数の内容と型 ===");
    System.out.println("data = " + data + " (型: " + data.getClass().getSimpleName() + ")");
    System.out.println("arr = " + arr + " (型: " + arr.getClass().getSimpleName() + ")");
  }
}
