class ArrayBug {
  public static void main(String[] args) {
    String[] names = new String[4];

    names[0] = "櫻井";
    names[1] = "谷";
    names[2] = "山田";
    names[3] = "太田";
    System.out.println("配列の長さ: " + names.length);

    for(int i = 0; i < names.length; i++) {
      System.out.println(names[i]);
    } 

    }
  }

