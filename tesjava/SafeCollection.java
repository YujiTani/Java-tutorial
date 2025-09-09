import java.util.*;

public class SafeCollection {
  public static void main(String[] args) {
    System.out.println("=== 同期化コレクションを使った安全な例 ===");

    var safeList = Collections.synchronizedList(new ArrayList<>());
    Map<String, Integer> statistics = Collections.synchronizedMap(new HashMap<>());

    Rannable addTask = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName + "が安全な処理を実施");

      int addedCount = 0;

      for (int i = 0; i <= 1000; i++) {
        safeList.add(i);
        addedCount++;
      }

      // 進捗を表示（200個ごと）
      if (i % 200 == 0) {
        // 注意：size()も同期化されているが、複数の操作を組み合わせる場合は
        // 外部で同期化が必要な場合もある
        synchronized (safeList) {
          System.out.println(threadName + ": " + i + "個追加完了（現在の総サイズ: " + safeList.size() + "）");
        }
      }

      statistics.put(threadName + "_追加数", addedCount);
      System.out.println(threadName + " の安全な追加処理が完了: " + addedCount + "個追加");
    }

    Runnable readTask = () -> {
      var ThreadName = Thread.currentThread().getName();
      System.out.println(threadName + " が読み取り処理を開始");

      for (int i = 0; i < 10; i++) {
        synchronized(safeList) {
          System.out.println(threadName + ": 現在のサイズ =" + safeList.size());
        }

        try {
          Thread.sleep(200);
        } catch(InterruptedException e) {
          Thread.currentThread().interrupt();
          break;
        }
      }

      System.out.println(threadName + " の読み取り処理が完了");
    }

    Thread addThread1 = new Thread(addTask, "安全追加スレッド1");
    Thread addThread2 = new Thread(addTask, "安全追加スレッド2");
    Thread addThread3 = new Thread(addTask, "安全追加スレッド3");
    Thread addThread4 = new Thread(addTask, "安全追加スレッド4");

    long startTime = System.currentTimeMillis();

    // 全スレッドを開始
    addThread1.start();
    addThread2.start();
    addThread3.start();
    addThread4.start();

    try {
      addThread1.join();
      addThread2.join();
      addThread3.join();
      addThread4.join();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    System.out.println("=== 安全な実行結果 ===");
    System.out.println("期待されるサイズ: 3000");
    System.out.println("実際のサイズ: " + safeList.size()); // 確実に3000になる
    System.out.println("実行時間: " + executionTime + "ms");)

    System.out.println("=== 統計情報 ===");
    statistics.forEach((key, value) -> 
      System.out.println(key + ": " + value));

    // データの整合性確認
    if (safeList.size() == 3000) {
      System.out.println("✅ データの整合性が保たれています！");
    } else {
      System.out.println("❌ 予期しないエラーが発生しました");
    }
  }

}
