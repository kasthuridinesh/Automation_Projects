package com.atmecs.qa.utils;
// Importing Libraries
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum StatusCode {
    OK(200, "OK"), CREATE(201, "CREATE"),
    NOCONTENT(204, "NO CONTENT"),
    BADREQUEST(400, "BAD REQUEST"), NOTFOUND(404, "NOT FOUND"),
    INTERNALSERVERERROR(500, "INTERNAL SERVER ERROR");

    private int statusCode;
    private String messageCode;


}
