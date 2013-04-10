package com.stackmob.example;

import com.stackmob.core.rest.ResponseToProcess;

import java.net.HttpURLConnection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sid
 * Date: 3/12/13
 * Time: 12:09 PM
 */

public class Util {

  static public Boolean strNullCheck(String str) {
    return (str == null || str.isEmpty());
  }

  static public Boolean checkForNulls(String... strings){
    for (String s : strings){
      if(strNullCheck(s)){
        return true;
      }
    }
    return false;
  }

  static public ResponseToProcess badRequestResponse(Map<String, String> map){
    map.put("error", "Please fill in all parameters correctly");
    return new ResponseToProcess(HttpURLConnection.HTTP_BAD_REQUEST, map);
  }

  static public ResponseToProcess badRequestResponse(Map<String, String> map, String message){
    map.put("error", message);
    return new ResponseToProcess(HttpURLConnection.HTTP_BAD_REQUEST, map);
  }

  static public ResponseToProcess internalErrorResponse(String message, Exception e, Map<String, String> map){
    map.put("error", message);
    map.put("detail", e.toString());
    return new ResponseToProcess(HttpURLConnection.HTTP_BAD_REQUEST, map);
  }

}
