// スレッドクラスを継承したカスタムクラス
class MyThread extends Thread {
  private String threadName; // スレッドの名前
  public MyThread(String name) {
    this.threadName = name;
  }

  @Override
  public void run() {
    // 0から4まで繰り返す
    for (int i = 0; i < 5; i++) {
      System.out.println(threadName + ": " + i);
      try {
        Thread.sleep(1000);
      } catch(InterruptedException e) {
        e.printStackTrace();
    }
    }
  }
  
}

public class ThreadExample {
  public static void main(String[] args) {
    System.out.println("=== Threadクラス継承の例 ===");

    MyThread thread1 = new MyThread("スレッド1");
    MyThread thread2 = new MyThread("スレッド2");
    MyThread thread3 = new MyThread("スレッド3");
    MyThread thread4 = new MyThread("スレッド4");

    System.out.println("スレッドを開始");

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    System.out.println("メインスレッドの処理を続行中");

    try {
      thread1.join();
      thread2.join();
      thread3.join();
      thread4.join();
      System.out.println("===========================");
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    
    System.out.println("全てのスレッド処理が完了しました");
  }
}
