package kz.roxy.tsoed.service;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
//
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);

        return new ServletRegistrationBean(servlet, "/*");
    }

    @Bean(name = "putreference")
    public Wsdl11Definition putReferenceWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/ServicePutReference.wsdl"));
        return wsdl11Definition;
    }

    @Bean(name = "getfile")
    public Wsdl11Definition getFileWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/ServiceGetFile.wsdl"));
        return wsdl11Definition;
    }


    /**
     * Publishing XML schema
     * @return The XSD definition
     */
    @Bean(name="soap-enc")
    public XsdSchema soapEncSchema() {
        SimpleXsdSchema xsdSchema = new SimpleXsdSchema();
        xsdSchema.setXsd(new ClassPathResource("/wsdl/soap-enc.xsd"));
        return xsdSchema;
    }
}
