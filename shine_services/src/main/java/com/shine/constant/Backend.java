package com.shine.constant;

/**
 * Created by hq on 2017/1/19.
 */
public interface Backend {
    interface URL {
        String BASE = "/backend";

        /**
         * 主页
         */
        interface INDEX {
            String INDEX = BASE;
            String INDEXVIEW = INDEX + "/index";
            String INDEX_V5 = INDEX + "/index_v5";
        }

        /**
         * 注册
         */
        interface REGISTER {
            String REGISTER = BASE;
            String REGISTERVIEW = REGISTER + "/register";
        }

        /**
         * 登陆
         */
        interface LOGIN {
            String LOGIN = BASE;
            String LOGINVIEW = LOGIN + "/login";
            String LOGINVIEWS = LOGIN + "/login_s";
            String LOCKSCREEN = LOGIN + "/lockscreen";
        }
    }

    interface PATH {
        String BASE = "/backend";

        /**
         * 主页
         */
        interface INDEX {
            String INDEXVIEW = BASE + "/index";
            String INDEX_V5 = BASE + "/index_v5";
        }

        /**
         * 注册
         */
        interface REGISTER {
            String REGISTER = BASE + "/common";
            String REGISTERVIEW = REGISTER + "/register";
        }

        /**
         * 登陆
         */
        interface LOGIN {
            String LOGIN = BASE + "/common";
            String LOGINVIEW = LOGIN + "/login";
            String LOGINVIEWS = LOGIN + "/login_s";
            String LOCKSCREEN = LOGIN + "/lockscreen";
        }
    }
}
