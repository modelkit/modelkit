package com.afantree.config;

public class Config {

    public static String getHost() {
        return env.host;
    }


    public static enum Env {
        SANDBOX_RDS("https://raw.githubusercontent.com/modelkit/modelkit/master/api/"),
        ;

        public final String host;

        Env(String host) {
            this.host = host;
        }

    }

    private static Env env = Env.SANDBOX_RDS;
}
