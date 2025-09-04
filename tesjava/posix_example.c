#include <unistd.h>    // read(), write(), close()
#include <fcntl.h>     // open(), O_RDONLY, O_WRONLY, O_CREAT
#include <sys/stat.h>  // ファイルモード定数
#include <stdio.h>     // printf(), perror()
#include <stdlib.h>    // exit()

int main() {
    int fd_read, fd_write;
    char buffer[1024];
    ssize_t bytes_read, bytes_written;
    
    // ファイルを読み込み用で開く
    fd_read = open("input.txt", O_RDONLY);
    if (fd_read == -1) {
        perror("input.txtを開けませんでした");
        exit(1);
    }
    
    // ファイルを書き込み用で作成/開く
    fd_write = open("output.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);
    if (fd_write == -1) {
        perror("output.txtを作成できませんでした");
        close(fd_read);
        exit(1);
    }
    
    // ファイルからデータを読み込み
    bytes_read = read(fd_read, buffer, sizeof(buffer) - 1);
    if (bytes_read == -1) {
        perror("ファイル読み込みエラー");
        close(fd_read);
        close(fd_write);
        exit(1);
    }
    
    // 読み込んだデータを別のファイルに書き込み
    if (bytes_read > 0) {
        bytes_written = write(fd_write, buffer, bytes_read);
        if (bytes_written == -1) {
            perror("ファイル書き込みエラー");
        } else {
            printf("%ld バイト読み込み、%ld バイト書き込みしました\n", 
                   bytes_read, bytes_written);
        }
    }
    
    // ファイルを閉じる
    close(fd_read);
    close(fd_write);
    
    return 0;
}
