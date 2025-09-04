#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    int fd1, fd2, fd3;
    
    printf("標準的なファイルディスクリプタ:\n");
    printf("STDIN_FILENO = %d (標準入力)\n", STDIN_FILENO);
    printf("STDOUT_FILENO = %d (標準出力)\n", STDOUT_FILENO);
    printf("STDERR_FILENO = %d (標準エラー)\n", STDERR_FILENO);
    
    // ファイルを開くとファイルディスクリプタが返される
    fd1 = open("test1.txt", O_WRONLY | O_CREAT, 0644);
    fd2 = open("test2.txt", O_WRONLY | O_CREAT, 0644);
    fd3 = open("test3.txt", O_WRONLY | O_CREAT, 0644);
    
    printf("\n新しく開いたファイルのディスクリプタ:\n");
    printf("test1.txt のfd = %d\n", fd1);
    printf("test2.txt のfd = %d\n", fd2);
    printf("test3.txt のfd = %d\n", fd3);
    
    // ファイルディスクリプタを閉じる
    // これはメモリ解放ではなく、OSリソースの解放
    close(fd1);
    close(fd2);
    close(fd3);
    
    printf("\nファイルディスクリプタを閉じました\n");
    
    return 0;
}
