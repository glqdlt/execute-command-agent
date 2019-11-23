package com.glqdlt.pm6.agent;

import com.glqdlt.pm6.agent.health.CheckAllHardDrives;
import com.glqdlt.pm6.agent.health.DiskInfor;
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

import java.util.Collections;
import java.util.List;

@ActiveProfiles("test")
@WebMvcTest(controllers = {SystemHandleRestController.class})
@RunWith(SpringRunner.class)
public class SystemHandleRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${secret.key}")
    private String key;

    @MockBean
    private SimpleSystemHandler simpleSystemHandler;

    @MockBean
    private CheckAllHardDrives checkAllHardDrives;


    @Test
    public void getHealth() throws Exception {
        List<DiskInfor> stub = Collections.singletonList(new DiskInfor("c:/", 1000L, 100L));
        Mockito.when(checkAllHardDrives.getAlLDriveSpace()).thenReturn(stub);
        MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/system/health")
                .header(TokenMatchInterceptor.SECURITY_HEADER, key))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertEquals(200, res.getResponse().getStatus());
        Assert.assertEquals("[{\"name\":\"c:/\",\"diskSize\":{\"total\":1000,\"free\":100,\"used\":900}}]", res.getResponse().getContentAsString());
    }

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