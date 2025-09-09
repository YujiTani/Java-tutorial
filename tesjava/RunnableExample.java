class MyTask implements Runnable {
    private String taskName;
    private int loopCount;

    public MyTask(String name, int count) {
        this.taskName = name;
        this.loopCount = count;
    }

    @Override
    public void run() {
        System.out.println(taskName + "を開始します");

        // 🔧 修正1: ループ条件を正しく変更
        for (int i = 1; i <= loopCount; i++) {
            String currentThread = Thread.currentThread().getName(); 
            System.out.println(taskName + " (実行スレッド: " + currentThread + "): " + i + "/" + loopCount);

            try {
                // 🔧 修正2: 現実的な待機時間に変更（500〜1500ミリ秒）
                int sleepTime = 500 + (int)(Math.random() * 1000);
                Thread.sleep(sleepTime);

            } catch(InterruptedException e) {
                // 🔧 修正3: 改行付きで出力
                System.out.println(taskName + "が割り込まれました");
                return;
            };
        }

        System.out.println(taskName + "が完了しました");
    }

    public static void main(String[] args) {
        System.out.println("===========Runnableの実装例===========");

        var task1 = new MyTask("データ処理タスク", 3);
        var task2 = new MyTask("ファイル読み込みタスク", 5);
        var task3 = new MyTask("ネット通信タスク", 2);

        var thread1 = new Thread(task1, "ワーカー1");
        var thread2 = new Thread(task2, "ワーカー2");
        var thread3 = new Thread(task3, "ワーカー3");

        System.out.println("3つの処理を並行実行します");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("メインスレッドは他の作業を続けます");

        try {
            thread1.join();
            System.out.println("スレッド1が完了しました");
            thread2.join();
            System.out.println("スレッド2が完了しました");
            thread3.join();
            System.out.println("スレッド3が完了しました");

        } catch(InterruptedException e) {
            e.printStackTrace();
        };
        System.out.println("全てのタスクが完了しました");
    }
}

