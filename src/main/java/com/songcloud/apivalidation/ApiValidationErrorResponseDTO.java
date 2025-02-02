package com.songcloud.apivalidation;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ApiValidationErrorResponseDTO(List<String> errors, HttpStatus status) {
}
