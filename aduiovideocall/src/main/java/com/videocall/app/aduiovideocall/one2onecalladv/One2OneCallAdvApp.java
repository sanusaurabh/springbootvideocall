/*
 * (C) Copyright 2014 Kurento (http://kurento.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.videocall.app.aduiovideocall.one2onecalladv;

import org.kurento.client.KurentoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Video call 1 to 1 demo (main).
 *
 * @author Boni Garcia (bgarcia@gsyc.es)
 * @author Micael Gallego (micael.gallego@gmail.com)
 * @since 5.0.0
 */

@Component
@EnableWebSocket
public class One2OneCallAdvApp implements WebSocketConfigurer {

  static final String DEFAULT_APP_SERVER_URL = "https://localhost:8443";

//  @Bean
//  public CallHandler callHandler() {
//    return new CallHandler();
//  }
  @Autowired
  private CallHandler callHandler;

//  @Bean
//  public UserRegistry registry() {
//    return new UserRegistry();
//  }

  @Bean
  public KurentoClient kurentoClient() {
     org.kurento.client.Properties  prop = new org.kurento.client.Properties(); 
	  prop.add("kms.url", "ws://18.219.2.46:8888/kurento");
    return KurentoClient.create(prop);
  }

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(callHandler, "/call");
  }

//  public static void main(String[] args) throws Exception {
//    SpringApplication.run(One2OneCallAdvApp.class, args);
//  }
}
