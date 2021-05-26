package org.tnmk.practicespringgracefulshutdown.pro00webserver.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonUtils {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String toJson(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new IllegalStateException("Cannot convert object to JSON string " + object + ". Root cause: " + e.getMessage(), e);
    }
  }

  public static Map<String, String> toMap(String jsonString) {
    try {
      Map<String, String> map = objectMapper.readValue(jsonString, Map.class);
      return map;
    } catch (JsonProcessingException e) {
      throw new IllegalStateException("Cannot convert JSON string to Map. Root cause: " + e.getMessage(), e);
    }
  }

  public static <T> T toObject(String jsonString, Class<T> resultClass) {
    try {
      return objectMapper.readValue(jsonString, resultClass);
    } catch (JsonProcessingException e) {
      throw new IllegalStateException("Cannot parse json. Rootcause:" + e.getMessage() + ". Json: \n" + jsonString, e);
    }
  }

  public static <T> T toObject(String jsonString, JavaType resultType) {
    try {
      return objectMapper.readValue(jsonString, resultType);
    } catch (JsonProcessingException e) {
      throw new IllegalStateException("Cannot parse json. Rootcause:" + e.getMessage() + ". Json: \n" + jsonString, e);
    }
  }
}
