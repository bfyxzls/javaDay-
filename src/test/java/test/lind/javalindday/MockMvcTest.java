package test.lind.javalindday;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedRequestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.restdocs.request.PathParametersSnippet;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import test.lind.javalindday.controller.DocController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integTest")//指定profile环境
@RunWith(SpringRunner.class)
public class MockMvcTest {
  static final ResponseFieldsSnippet orderResponseFieldsParameters = relaxedResponseFields(
      fieldWithPath("name").description("账号"),
      fieldWithPath("buyer").description("购买者"),
      fieldWithPath("sex").description("性别")
  );
  static final RequestFieldsSnippet orderRequestFieldsParameters = relaxedRequestFields(
      fieldWithPath("name").description("账号"),
      fieldWithPath("buyer").description("购买者"),
      fieldWithPath("sex").description("性别")
  );
  static final PathParametersSnippet orderRequestPathParameters = pathParameters(
      parameterWithName("name").description("购买者")
  );

  @Rule
  public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
  protected MockMvc mockMvc;
  @Autowired
  ObjectMapper objectMapper;
  @Autowired
  private WebApplicationContext context;

  @Before
  public void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(MockMvcRestDocumentation.documentationConfiguration(restDocumentation)
            .uris().withScheme("http").withHost("localhost").withPort(8080)
            .and()
            .operationPreprocessors().withResponseDefaults(prettyPrint()))
        .build();
  }


  @Test
  public void get_orders() throws Exception {
    this.mockMvc.perform(
        get(DocController.DOC, "zzl"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello")))
        .andDo(document("doc-index",
            orderRequestPathParameters,
            orderResponseFieldsParameters));
  }

  @Test
  public void get_list() throws Exception {
    this.mockMvc.perform(
        get(DocController.DOC_LIST))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("doc-list",
            orderResponseFieldsParameters));
  }

  @Test
  public void do_order() throws Exception {
    Map<String, String> maps = new HashMap<>();
    maps.put("name", "张三");
    maps.put("buyer", "张四");
    maps.put("sex", "男");
    this.mockMvc.perform(
        post(DocController.DOC_DO, "zzl")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(maps)))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("do-order",
            orderRequestPathParameters,
            orderRequestFieldsParameters,
            orderResponseFieldsParameters));
  }
}
