class ContinueWithLabelDemo {
  public static void main (String[] args) {
    if (args.length == 0) {
      System.err.println("引数を入力してください");
      return;
    }

    String searchMe = args[0];
    String substring = args[1];
    boolean foundIt = false;

    int max = searchMe.length() - substring.length();
    if (max < 0) {
      System.err.println("引数1は引数2よりも長い文字列を入力してください");
      return;
    }

    test:
      for(int i = 0; i < max; i++) {
      int n = substring.length();
      int j = i;
      int k = 0;

      while(n-- != 0) {
      // System.out.println("n" + n);
       if (searchMe.charAt(j++) != substring.charAt(k++)) {
          continue test;
        }
      }

      foundIt = true;
      break test;
    }

    System.out.println(foundIt ? "Found It" : "Didn't find it");

  }
}
