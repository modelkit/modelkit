package com.afantree.model;

import com.afantree.model.common.GoodItem;
import com.afantree.model.common.Utils;

import java.util.ArrayList;
import java.util.List;


/*
 * 
 * This file was automatically generated by ModelKit. It must not be modified manually!
 */

public class FindIndex {
    public static class Input {

        /**
         * @return String 请求的URL
         */
        public static final String URL = "find/index";


        /**
         * 啊哈哈
         */
        private String sex;


        public String getSex() {
            return this.sex;
        }


        public Input setSex(String sex) {
            this.sex = sex;
            return this;
        }

     
        public String toString() {
            StringBuilder builder = new StringBuilder(); 
            return builder.append("sex=").append(Utils.encode(sex)).toString();
        }
    
        private Input(String sex) {
                this.sex = sex;

        }
    
        public static String getUrlWithParam(String sex) {
            Input input = new Input(sex);
            return input.toString();
        }
    }

    /**
     * 
     */
    public List<GoodItem> list = new ArrayList<GoodItem>();

    
}

