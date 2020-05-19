//package org.kekee.controller;
//
//import org.apache.catalina.Context;
//import org.apache.catalina.connector.Connector;
//import org.apache.tomcat.util.descriptor.web.SecurityCollection;
//import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * TomcatConfig class
// * IntelliJ IDEA: TODO
// *
// * @author <a href="https://github.com/kekee0724">可可</a>
// * @date 2020/05/05
// */
//@Configuration
//public class TomcatConfig {
//    @Bean
//    TomcatServletWebServerFactory tomcatServletWebServerFactory() {
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint constraint = new SecurityConstraint();
//                constraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                constraint.addCollection(collection);
//                context.addConstraint(constraint);
//            }
//        };
//        factory.addAdditionalTomcatConnectors(createTomcatConnector());
//        return factory;
//    }
//
//    private Connector createTomcatConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        //http端口
//        connector.setPort(723);
//        //这个坑，网上普遍为false重定向容易出错，我这里设置为true
//        connector.setSecure(true);
//        connector.setRedirectPort(724);
//        return connector;
//    }
//}