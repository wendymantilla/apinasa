package com.wendymantilla.nasa.apinasa;

import com.wendymantilla.nasa.apinasa.domain.Apod;
import com.wendymantilla.nasa.apinasa.services.ApiNasaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ApiNasaFeignTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiNasaService apiNasaService;

    @Test
    public void shouldReturnNasaInfo() throws Exception {

        when(apiNasaService.getApod(anyString(), anyString()))
                .thenReturn(Apod.builder().date("2020-01-03").build());

        this.mockMvc.perform(get("/apinasa").queryParam("date", "2020-01-03"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2020-01-03")));
    }
}
