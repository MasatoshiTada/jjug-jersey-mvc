package com.example.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.beanvalidation.MvcBeanValidationFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

/**
 * JAX-RSを有効化するための設定クラスです。
 * クラスの登録が必要になるため、Jersey独自のApplicationサブクラスである
 * ResourceConfigを継承しています。
 * @author tada
 */
@ApplicationPath("api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        // Jersey MVCおよびビューとしてJSPを有効化する
        // TODO: 演習1-1. JspMvcFeatureクラスを登録する
        register(null);
        
        // Jersey MVCにおけるBean Validationを有効化する
        register(MvcBeanValidationFeature.class);
        
        // ビューを保存するフォルダを指定する
        // TODO: 演習1-2. JSPを保存するフォルダに"/WEB-INF/views/"を指定する
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "");
        
        // このクラスが入っているパッケージ以下の全パッケージ内のクラスを登録対象にする
        packages(true, this.getClass().getPackage().getName());
    }
}
