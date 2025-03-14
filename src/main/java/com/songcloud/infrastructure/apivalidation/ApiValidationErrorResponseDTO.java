package com.songcloud.infrastructure.apivalidation;

import org.springframework.http.HttpStatus;

import java.util.List;

record ApiValidationErrorResponseDTO(List<String> errors, HttpStatus status) {
}
