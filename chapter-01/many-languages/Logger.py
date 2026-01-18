import datetime

file_name = "application.log"
log_message = "INFO: Operation completed successfully."

current_time = datetime.datetime.now()
timestamp = current_time.strftime("%Y-%m-%d %H:%M:%S")

try:
    with open(file_name, "a") as file:
        file.write(f"[{timestamp}] {log_message}\n")
    print(f"Logged message to {file_name}")
except IOError as e:
    print(f"Error writing to log file {file_name}: {e}")