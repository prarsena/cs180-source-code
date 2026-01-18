#include <fstream>
#include <iostream>
#include <string>
#include <chrono>
#include <iomanip>

int main() {
    std::ofstream output_file("application.log", std::ios::app);
    if (!output_file.is_open()) {
        std::cerr << "Error: Could not open log file application.log\n";
        return 1;
    }

    auto now = std::chrono::system_clock::now();
    auto in_time_t = std::chrono::system_clock::to_time_t(now);

    output_file << "[" << std::put_time(std::localtime(&in_time_t), "%Y-%m-%d %H:%M:%S") << "] INFO: Operation completed successfully." << std::endl;
    output_file.close();
    std::cout << "Logged message to application.log\n";
    return 0;
}