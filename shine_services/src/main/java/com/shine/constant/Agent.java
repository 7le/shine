package com.shine.constant;

/**
 * Created by hq on 2016/11/04.
 */
public interface Agent {


    interface URL {
        String BASE = "/agent";

        interface LOGIN{
            String LOGIN =  BASE +"";
            String LOGIN_VIEW = "/loginView";
            String DO_LOGIN = "/doLogin";
        }
    }

    interface PATH {
        String BASE = "/agent";

        interface LOGIN{
            String LOGIN =  BASE +"";
            String LOGIN_VIEW =LOGIN + "/loginView";
        }
    }
}
