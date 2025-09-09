import java.util.*;

public class UnsafeCollectionExample {
  public static void main(String[] args) {
    System.out.println("=======非同期コレクションの問題例=======");

    var unsafeList = new ArrayList<>();
    Runnable addTask = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName + "が要素を追加");

      for(int i = 0; i < 1000; i++) {
        unsafeList.add(i);
        
        if (i % 100 == 0) {
          System.out.println(i + "個のスレッドを追加完了");
        }
      }

      System.out.println(threadName + " の追加処理が完了");
    };

  var thread1 = new Thread(addTask, "追加スレッド1");
  var thread2 = new Thread(addTask, "追加スレッド2");
  var thread3 = new Thread(addTask, "追加スレッド3");

  var startTime = System.currentTimeMillis();

  thread1.start();
  thread2.start();
  thread3.start();

  try {
  thread1.join();
  thread2.join();
  thread3.join();
  } catch (InterruptedException e) {
    e.printStackTrace();
  }

          // 実行時間を計算
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        // 結果を表示
        System.out.println("=== 実行結果 ===");
        System.out.println("期待されるサイズ: 3000");
        System.out.println("実際のサイズ: " + unsafeList.size()); // 3000より少ない場合が多い
        System.out.println("実行時間: " + executionTime + "ms");
        
        // データの整合性をチェック
        if (unsafeList.size() != 3000) {
            System.out.println("⚠️ データロストが発生しました！");
            System.out.println("失われたデータ数: " + (3000 - unsafeList.size()));
        } else {
            System.out.println("✅ データは正常です（稀なケース）");
        }

}
}
