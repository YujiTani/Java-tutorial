#include <unistd.h>
#include <stdio.h>
#include <string.h>

int main() {
    char buffer[256];
    ssize_t bytes_read, bytes_written;
    const char* prompt = "文字を入力してください: ";
    const char* response = "あなたが入力したのは: ";
    
    // プロンプトを標準出力に書き込み
    // STDOUT_FILENO は標準出力のファイルディスクリプタ（通常は1）
    bytes_written = write(STDOUT_FILENO, prompt, strlen(prompt));
    if (bytes_written == -1) {
        perror("標準出力への書き込みエラー");
        return 1;
    }
    
    // 標準入力からデータを読み込み
    // STDIN_FILENO は標準入力のファイルディスクリプタ（通常は0）
    bytes_read = read(STDIN_FILENO, buffer, sizeof(buffer) - 1);
    if (bytes_read == -1) {
        perror("標準入力からの読み込みエラー");
        return 1;
    }
    
    // 読み込んだデータの末尾にヌル文字を追加
    buffer[bytes_read] = '\0';
    
    // レスポンスメッセージを出力
    write(STDOUT_FILENO, response, strlen(response));
    
    // 読み込んだデータを標準出力に書き込み
    write(STDOUT_FILENO, buffer, bytes_read);
    
    return 0;
}
