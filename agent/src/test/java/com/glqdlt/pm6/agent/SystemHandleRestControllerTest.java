package com.glqdlt.pm6.agent;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@ActiveProfiles("test")
@WebMvcTest()
@RunWith(SpringRunner.class)
public class SystemHandleRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${secret.key}")
    private String key;

    @MockBean
    private SimpleSystemHandler simpleSystemHandler;


    @Test
    public void getShutdown() throws Exception {
        Mockito.doNothing().when(simpleSystemHandler);
        MvcResult res = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/system/shutdown")
                .header(TokenMatchInterceptor.SECURITY_HEADER, key))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertEquals(200, res.getResponse().getStatus());
    }

    @Test()
    public void getShutdownNotToken() throws Exception {
        MvcResult zz = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/system/shutdown"))
                .andReturn();
        Assert.assertEquals(404, zz.getResponse().getStatus());
    }
}