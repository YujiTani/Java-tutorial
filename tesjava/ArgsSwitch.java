public class ArgsSwitch {
  public static void main(String[] args) {
    processValue("テスト");
    processValue(100);
    processValue(1);
    processValue(true);
  }

  public static <T> void processValue(T val) {
    System.out.println(switch (val) {
      case Integer atai when 15 >= atai -> "15より大きい引数を受け取りました";
      case Integer atai -> "int型の引数が渡されました。";
      case String ace -> "String型の引数が渡されました。";
      case Boolean nanuka -> "Boolean型の引数が渡されました。";
      default -> "想定外の値が入力されています";
    });
  }

}
