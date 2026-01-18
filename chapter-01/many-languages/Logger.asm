section .data
    filename db "application.log", 0
    message db "INFO: Operation completed successfully.", 0x0A
    msg_len equ $ - message

section .text
    global _start

_start:
    mov rax, 2
    lea rdi, [rel filename]
    mov rsi, 0o1002
    mov rdx, 0o644
    syscall
    mov rbx, rax

    mov rax, 1
    mov rdi, rbx
    lea rsi, [rel message]
    mov rdx, msg_len
    syscall

    mov rax, 3
    mov rdi, rbx
    syscall

    mov rax, 60
    xor rdi, rdi
    syscall