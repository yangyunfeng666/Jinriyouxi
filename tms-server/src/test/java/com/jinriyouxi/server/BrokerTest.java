package com.jinriyouxi.server;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest()
//@WebMvcTest(BrokerController.class)
@ContextConfiguration(initializers = {TestApplicationContextInitializer.class})
@WebAppConfiguration
public class BrokerTest {

  private MockMvc mockMvc;

  @Autowired
  WebApplicationContext webApplicationContext;

  @Autowired
  private FilterChainProxy springSecurityFilterChain;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilters(springSecurityFilterChain).build();
  }


  final static String CLIENT_ID = "broker_h5";
  //clientSecret
  final static String CLIENT_SECRET = "112233xyz";
  //用户名
  final static String USERNAME = "J080601623528090:BROKER";
  //密码
  final static String PASSWORD = "A4BCD0383919C696B4B5D7A58C849B3C";

  private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

  public String obtainAccessToken() throws Exception {
    final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("grant_type", "password");
    params.add("client_id", CLIENT_ID);
    params.add("username", USERNAME);
    params.add("password", PASSWORD);

    // @formatter:off

    ResultActions result = mockMvc.perform(post("/oauth/token")
        .params(params)
        .header("Authorization","Basic YnJva2VyX2g1OjExMjIzM3h5eg==")
//        .with(httpBasic(CLIENT_ID, CLIENT_SECRET))
        .accept(CONTENT_TYPE))
        .andExpect(status().isOk());

    // @formatter:on

    String resultString = result.andReturn().getResponse().getContentAsString();

    JacksonJsonParser jsonParser = new JacksonJsonParser();
//        System.out.println(jsonParser.parseMap(resultString).get("access_token").toString());
    return jsonParser.parseMap(resultString).get("access_token").toString();
  }

  @Test
  public void test() throws Exception {
    String token = "Bearer 35969b04-7e90-4a1d-9649-b117d7360d51";
    //数据
//    BrokerNextBrokerReq req = new BrokerNextBrokerReq();
    Object req = new Object();
    //组装层数据

    MvcResult result = mockMvc.perform(
        post("/user/queryMenu").header("Authorization", token)
            .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(req))
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
        .andReturn();
    int re = result.getResponse().getStatus();
    System.out.println(re);
    String r = result.getResponse().getContentAsString();
    System.out.println(r);
  }

}
