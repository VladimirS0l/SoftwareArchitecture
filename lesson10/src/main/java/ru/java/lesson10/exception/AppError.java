package ru.java.lesson10.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сообщения ошибок сервисов", example = "Объект не найден")
public class AppError {
    private String statusCode;
    private String message;
}
