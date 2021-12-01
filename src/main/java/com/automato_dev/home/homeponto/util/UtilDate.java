package com.automato_dev.home.homeponto.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class UtilDate {


    public static String convertTimestampDate(Long timestamp){
        
        return new SimpleDateFormat("dd-MM-YYY - HH:mm:ss", Locale.getDefault()).format(timestamp);

    }
    
}
