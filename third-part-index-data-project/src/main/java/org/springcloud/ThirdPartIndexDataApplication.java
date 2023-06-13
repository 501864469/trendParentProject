package org.springcloud;

import brave.sampler.Sampler;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class ThirdPartIndexDataApplication {
    public static void main(String[] args){
        int port=8090;
        int eurekaServerPort=8761;

        if(NetUtil.isUsableLocalPort(eurekaServerPort)){
            System.err.printf("检测到端口%d 未启用，判断eureka服务器没有启动，本服务无法使用，故推出%n",eurekaServerPort);
            System.exit(1);
        }
        if(null!=args&&0!=args.length){
            for(String arg:args){
                if(arg.startsWith("port=")){
                    String strPort=StrUtil.subAfter(arg,"port=",true);
                    if(NumberUtil.isNumber(strPort)){
                        port=Convert.toInt(strPort);
                    }
                }
            }
        }
        if(!NetUtil.isUsableLocalPort(port)){
            System.err.printf("端口%n被占用了，无法启动%n",port);
            System.exit(1);
        }
        new SpringApplicationBuilder(ThirdPartIndexDataApplication.class).properties("server.port=" + port).run(args);
    }
    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
