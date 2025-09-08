class MyThread extends Thread {
  private String threadName; // スレッドの名前
  public MyThread(String name) {
    this.threadName = name;
  }

  @Override
  public void run() {
    // 0から4まで繰り返す
    for (i=0; i < 5; i++) {
      System.out.println(threadName + ": " + i);
      try {
        Thread.sleep();
      } catch(InterrunptedExceptioin e) {
        e.printStackTrace();
    }
    }
  }
  
}

public class ThreadExample {
  public static void main(String[] args) {
    System.out.println("=== Threadクラス継承の例 ===");

    thread1 = new MyThread("スレッド1");
    thread2 = new MyThread("スレッド2");

    System.out.println("スレッドを開始");

    thread1.start();
    thread2.start();

    System.out.println("メインスレッドの処理を続行中");

    try {
      thread1.join();
      thread2.join();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    
    System.out.println("全てのスレッド処理が完了しました");
  }
}
