package jammazwan.xao;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;


public class XaoRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:xao").marshal().jacksonxml().to("file:.");
    }
}
