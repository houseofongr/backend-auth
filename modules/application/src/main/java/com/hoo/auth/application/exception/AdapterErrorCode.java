package com.hoo.auth.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

/**
 * <pre>
 * <h1>Error Code Index</h1>
 * <ul>
 *     <li>Bad Request(400) : 1 ~ 99</li>
 *     <li>Authentication(401) : 100 ~ 199</li>
 *     <li>Not Found(404) : 300 ~ 399</li>
 *     <li>Conflict(405) : 400 ~ 499</li>
 *     <li>Internal Server Error(500) : 500 ~ 599</li>
 *     <li>Etc : 600 ~</li>
 * </ul>
 * </pre>
 */
@Getter
@AllArgsConstructor
public enum AdapterErrorCode implements ErrorCode {

    NICKNAME_DUPLICATED("AUTH-PERSISTENCE-400", CONFLICT, "이미 등록된 email입니다.");

    private final String code;
    private final HttpStatus status;
    private final String message;

}
