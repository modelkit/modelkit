package com.afantree.model;

import com.afantree.model.common.GoodItem;

import java.util.ArrayList;
import java.util.List;


/*
 * 
 * This file was automatically generated by ModelKit. It must not be modified manually!
 */

public class SearchIndex {
    public static class Input {

        /**
         * @return String 请求的URL
         */
        public static final String URL = "search/index";

     
        public String toString() {
            StringBuilder builder = new StringBuilder(); 
            return builder.toString();
        }
    
        private Input() {
        
        }
    
        public static String getUrlWithParam() {
            Input input = new Input();
            return input.toString();
        }
    }

    /**
     * 
     */
    public List<GoodItem> list = new ArrayList<GoodItem>();

    
}

