import java.util.List;
import java.util.ArrayList;

public class GenericsComparison {
    public static void main(String[] args) {
        System.out.println("=== ジェネリクスを使わない場合（古い方法） ===");
        
        // ジェネリクスなし - 何でも入る
        List oldList = new ArrayList();
        oldList.add("文字列");
        oldList.add(123);          // 数値
        oldList.add(true);         // boolean
        oldList.add(new Object()); // オブジェクト
        
        System.out.println("oldList: " + oldList);
        
        // 取り出すときに型キャストが必要 + 危険！
        try {
            String str1 = (String) oldList.get(0); // OK
            System.out.println("文字列: " + str1);
            
            String str2 = (String) oldList.get(1); // 実行時エラー！
            System.out.println("これは実行されない");
        } catch (ClassCastException e) {
            System.out.println("❌ エラー発生: " + e.getMessage());
        }
        
        System.out.println("\n=== ジェネリクスを使う場合（現在の方法） ===");
        
        // ジェネリクスあり - 型安全
        List<String> newList = new ArrayList<>();
        newList.add("文字列1");
        newList.add("文字列2");
        // newList.add(123);  // ← コンパイルエラーになる！
        
        System.out.println("newList: " + newList);
        
        // 型キャスト不要 + 安全！
        String str = newList.get(0); // 型キャスト不要
        System.out.println("文字列: " + str);
        
        // for-eachも型安全
        for (String s : newList) {
            System.out.println("要素: " + s.toUpperCase()); // String のメソッドが使える
        }
        
        System.out.println("\n=== ジェネリクスの利点 ===");
        demonstrateGenerics();
    }
    
    public static void demonstrateGenerics() {
        // 1. 型安全性
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        // numbers.add("文字列"); // コンパイルエラー！
        
        // 2. 型キャスト不要
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Integer -> int に自動変換
        }
        System.out.println("合計: " + sum);
        
        // 3. コードの意図が明確
        List<String> names = new ArrayList<>();     // 名前のリスト
        List<Integer> ages = new ArrayList<>();     // 年齢のリスト
        List<Boolean> flags = new ArrayList<>();    // フラグのリスト
        
        System.out.println("名前リスト用: " + names.getClass().getSimpleName());
        System.out.println("年齢リスト用: " + ages.getClass().getSimpleName());
        System.out.println("フラグリスト用: " + flags.getClass().getSimpleName());
    }
}
