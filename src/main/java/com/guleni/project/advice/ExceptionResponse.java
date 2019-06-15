package com.guleni.project.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/*

Bu class excepton objemizin propertylerini içeriyor şimdilik sadece date ve exception mesajımız var.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse
{
    private Date date;
    private String message;
}
