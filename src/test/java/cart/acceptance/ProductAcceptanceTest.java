package cart.acceptance;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;
import static cart.acceptance.ProductSteps.상품_목록_요청;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DisplayName("상품 관련 기능 인수테스트")
class ProductAcceptanceTest {

    @Test
    @DisplayName("/products 로 접근할 경우 상품 목록 조회에 성공한다.")
    void getProductsTest() {
        ExtractableResponse<Response> response = 상품_목록_요청("/products");
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("/products 와 다른 path로 접근할 경우 상품 목록 조회에 실패한다.")
    void getProductsExceptionTest() {
        ExtractableResponse<Response> response = 상품_목록_요청("/peo");
        assertThat(response.statusCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

}