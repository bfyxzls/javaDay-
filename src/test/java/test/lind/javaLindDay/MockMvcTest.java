package test.lind.javaLindDay;

    import static org.hamcrest.Matchers.containsString;
    import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
    import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
    import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
    import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedRequestFields;
    import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
    import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
    import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
    import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.restdocs.payload.RequestFieldsSnippet;
    import org.springframework.restdocs.payload.ResponseFieldsSnippet;
    import org.springframework.restdocs.request.PathParametersSnippet;
    import org.springframework.test.context.ActiveProfiles;
    import org.springframework.test.context.junit4.SpringRunner;
    import org.springframework.test.web.servlet.MockMvc;
    import test.lind.javaLindDay.controller.DocController;

@ActiveProfiles("integTest")//指定profile环境
@RunWith(SpringRunner.class)
@WebMvcTest(DocController.class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
public class MockMvcTest {
  static final ResponseFieldsSnippet orderResponseFieldsParameters = relaxedResponseFields(
      fieldWithPath("name").description("账号"),
      fieldWithPath("buyer").description("购买者"),
      fieldWithPath("sex").description("性别")
  );
  static final RequestFieldsSnippet orderRequestFieldsParameters = relaxedRequestFields(
      fieldWithPath("code").description("凭证号"),
      fieldWithPath("word").description("凭证字"),
      fieldWithPath("batch").description("批次")
  );
  static final PathParametersSnippet orderRequestPathParameters = pathParameters(
      parameterWithName("name").description("购买者")
  );

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void get_orders() throws Exception {
    this.mockMvc.perform(
        get(DocController.DOC, "zzl"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello")))
        .andDo(document("doc-index", orderRequestPathParameters, orderResponseFieldsParameters));
  }

  @Test
  public void get_list() throws Exception {
    this.mockMvc.perform(
        get(DocController.DOC_LIST))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("doc-list", orderResponseFieldsParameters));
  }
}
