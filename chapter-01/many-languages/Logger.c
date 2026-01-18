#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    FILE *file_ptr;
    time_t rawtime;
    struct tm *info;
    char timestamp[20];
    
    time(&rawtime);
    info = localtime(&rawtime);
    strftime(timestamp, sizeof(timestamp), "%Y-%m-%d %H:%M:%S", info);
    
    file_ptr = fopen("application.log", "a");
    if (file_ptr == NULL) {
        perror("Error opening log file");
        return EXIT_FAILURE;
    }
    
    fprintf(file_ptr, "[%s] INFO: Operation completed successfully.\n", timestamp);
    fclose(file_ptr);
    printf("Logged message to application.log\n");
    return EXIT_SUCCESS;
}