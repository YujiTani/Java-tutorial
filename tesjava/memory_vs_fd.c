#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    // 1. メモリ割り当て（ヒープメモリ）
    char* buffer = malloc(1024);  // メモリ割り当て
    if (buffer == NULL) {
        perror("メモリ割り当て失敗");
        return 1;
    }
    strcpy(buffer, "Hello, World!");
    
    // 2. ファイルディスクリプタ取得（OSリソース）
    int fd = open("sample.txt", O_WRONLY | O_CREAT, 0644);
    if (fd == -1) {
        perror("ファイル開けません");
        free(buffer);  // メモリ解放
        return 1;
    }
    
    // データをファイルに書き込み
    write(fd, buffer, strlen(buffer));
    
    printf("メモリアドレス: %p\n", (void*)buffer);
    printf("ファイルディスクリプタ: %d\n", fd);
    
    // リソースの解放
    free(buffer);    // ★ メモリ解放（ヒープメモリを返却）
    close(fd);       // ★ ファイルディスクリプタ解放（OSリソース返却）
    
    printf("リソースを解放しました\n");
    
    return 0;
}
