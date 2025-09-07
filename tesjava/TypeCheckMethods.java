import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeCheckMethods {
    // フィールド（ジェネリクス情報取得用）
    private List<String> stringList = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=== Javaの型チェック方法一覧 ===\n");
        
        // サンプルオブジェクト
        String str = "Hello";
        Integer num = 123;
        List<String> list = new ArrayList<>();
        list.add("テスト");
        
        // 1. getClass()メソッド
        System.out.println("【1. getClass()メソッド】");
        System.out.println("str.getClass(): " + str.getClass());
        System.out.println("num.getClass(): " + num.getClass());
        System.out.println("list.getClass(): " + list.getClass());
        System.out.println();
        
        // 2. getSimpleName()（クラス名のみ）
        System.out.println("【2. getSimpleName()】");
        System.out.println("str型: " + str.getClass().getSimpleName());
        System.out.println("num型: " + num.getClass().getSimpleName());
        System.out.println("list型: " + list.getClass().getSimpleName());
        System.out.println();
        
        // 3. instanceof演算子
        System.out.println("【3. instanceof演算子】");
        System.out.println("str instanceof String: " + (str instanceof String));
        System.out.println("num instanceof Integer: " + (num instanceof Integer));
        System.out.println("list instanceof List: " + (list instanceof List));
        System.out.println("list instanceof ArrayList: " + (list instanceof ArrayList));
        System.out.println();
        
        // 4. isInstance()メソッド
        System.out.println("【4. isInstance()メソッド】");
        System.out.println("String.class.isInstance(str): " + String.class.isInstance(str));
        System.out.println("Integer.class.isInstance(str): " + Integer.class.isInstance(str));
        System.out.println();
        
        // 5. Class.forName()で型比較
        System.out.println("【5. Class.forName()で型比較】");
        try {
            Class<?> stringClass = Class.forName("java.lang.String");
            System.out.println("str.getClass() == stringClass: " + (str.getClass() == stringClass));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
        
        // 6. プリミティブ型のチェック
        System.out.println("【6. プリミティブ型のチェック】");
        System.out.println("int.class: " + int.class);
        System.out.println("Integer.TYPE: " + Integer.TYPE);
        System.out.println("int.class == Integer.TYPE: " + (int.class == Integer.TYPE));
        System.out.println();
        
        // 7. 配列型のチェック
        System.out.println("【7. 配列型のチェック】");
        String[] strArray = {"a", "b"};
        System.out.println("strArray型: " + strArray.getClass());
        System.out.println("strArray.getClass().isArray(): " + strArray.getClass().isArray());
        System.out.println("配列の要素型: " + strArray.getClass().getComponentType());
        System.out.println();
        
        // 8. ジェネリクス情報の取得（リフレクション）
        System.out.println("【8. ジェネリクス情報の取得】");
        try {
            TypeCheckMethods instance = new TypeCheckMethods();
            instance.checkGenericType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        
        // 9. 実用的な型チェック関数
        System.out.println("【9. 実用的な型チェック関数】");
        checkType("文字列", str);
        checkType("数値", num);
        checkType("リスト", list);
        System.out.println();
        
        // 10. var推論の型確認
        System.out.println("【10. var推論の型確認】");
        var autoStr = "自動推論";
        var autoList = new ArrayList<Integer>();
        System.out.println("var autoStr の型: " + autoStr.getClass().getSimpleName());
        System.out.println("var autoList の型: " + autoList.getClass().getSimpleName());
    }
    
    // ジェネリクス情報をリフレクションで取得
    public void checkGenericType() throws Exception {
        System.out.println("リフレクションでジェネリクス情報を取得:");
        Type fieldType = this.getClass().getDeclaredField("stringList").getGenericType();
        System.out.println("stringList フィールドの型: " + fieldType);
        
        if (fieldType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) fieldType;
            System.out.println("型パラメータ: " + pt.getActualTypeArguments()[0]);
        }
    }
    
    // 実用的な型チェック関数
    public static void checkType(String name, Object obj) {
        System.out.println(name + ":");
        System.out.println("  - クラス: " + obj.getClass().getName());
        System.out.println("  - 簡易名: " + obj.getClass().getSimpleName());
        System.out.println("  - 値: " + obj);
        
        // よく使われる型のチェック
        if (obj instanceof String) {
            System.out.println("  - 文字列です");
        } else if (obj instanceof Number) {
            System.out.println("  - 数値型です");
        } else if (obj instanceof List) {
            System.out.println("  - リスト型です");
        }
    }
}
