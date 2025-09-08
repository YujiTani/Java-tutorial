// 🎯 練習問題 1: 基本的なジェネリクス
//
// お題：学生の成績管理システム
//
// 以下の要件を満たすプログラムを作成してください：
//
// 1. 3つのリストを作成：
// •  List<String> studentNames - 学生名のリスト
// •  List<Integer> mathScores - 数学の点数のリスト  
// •  List<Double> averageScores - 平均点のリスト
// 2. データを追加：
// •  学生名: "田中", "佐藤", "鈴木"
// •  数学の点数: 85, 92, 78
// •  平均点: 87.5, 89.2, 81.0
// 3. 以下を出力：
// •  各学生の情報（名前、数学点数、平均点）
// •  数学の最高点
// •  平均点の合計
//
import java.util.List;
import java.util.ArrayList;


class Main {
  public static void main(String[] args) {
    var studentNames = new ArrayList<>(List.of("山田太郎", "都会花子", "土佐大津", "歌響", "海博市"));
    System.out.println("一回目のname 配列チェック:" + studentNames);
    var mathScores = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
    System.out.println("一回目のスコア配列チェック:" + mathScores);
    // 変数の型をチェック
    System.out.println(studentNames.getClass());
    System.out.println(studentNames.getClass().getSimpleName());

    if (studentNames instanceof ArrayList) {
      System.out.println("studentNamesはArrayListです");
    }

    if (mathScores instanceof ArrayList) {
      System.out.println("studentNamesはArrayListです");
    }

    studentNames.add("追加された男");
    System.out.println("二回目のname配列チェック:" + studentNames);

    mathScores.add(11);
    System.out.println("2回目のスコア配列チェック:" + mathScores);


    for(String s : studentNames) {
      System.out.println("名前:" + s);
    }

    for(Integer i : mathScores) {
      System.out.println("スコア:" + i);
    }

    // 逆から取得して表示
    var ite = studentNames.listIterator(studentNames.size());
    while(ite.hasPrevious()) {
      System.out.println(ite.previous());
    }


    while(ite.hasNext()) {
        ite.next();
        ite.remove();
    }
    System.out.println("3回目のnames配列チェック:" + studentNames);

  }

}
