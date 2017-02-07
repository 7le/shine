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
            String DOREGISTERVIEW = REGISTER + "/doRegister";
        }

        /**
         * 登陆
         */
        interface LOGIN {
            String LOGIN = BASE;
            String LOGINVIEW = LOGIN + "/login";
            String LOCKSCREEN = LOGIN + "/lockscreen";
            String DOLOGIN = LOGIN + "/doLogin";
        }

        /**
         * 权限
         */
        interface ROLE {
            String ROLE = BASE + "/role";
            String ROLETREE = ROLE + "/tree";
        }
    }

    interface PATH {
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
            String LOCKSCREEN = LOGIN + "/lockscreen";
        }
    }
}
