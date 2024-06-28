package org.example.workshopmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeParam(String str) {
        try {
            return URLDecoder.decode(str, "utf8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
