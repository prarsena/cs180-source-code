const fs = require('fs');

const fileName = 'application.log';
const logMessage = 'INFO: Operation completed successfully.';

const now = new Date();
const timestamp = now.getFullYear() + '-' +
                  String(now.getMonth() + 1).padStart(2, '0') + '-' +
                  String(now.getDate()).padStart(2, '0') + ' ' +
                  String(now.getHours()).padStart(2, '0') + ':' +
                  String(now.getMinutes()).padStart(2, '0') + ':' +
                  String(now.getSeconds()).padStart(2, '0');

const logEntry = `[${timestamp}] ${logMessage}\n`;

fs.appendFile(fileName, logEntry, (err) => {
    if (err) {
        console.error('Error writing to log file:', err);
    } else {
        console.log(`Logged message to ${fileName}`);
    }
});