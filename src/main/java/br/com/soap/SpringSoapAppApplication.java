package br.com.soap;

import br.com.soap.util.SOAPConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@SpringBootApplication
@EnableWs
public class SpringSoapAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapAppApplication.class, args);
	}

	@Bean
	public static ServletRegistrationBean messageDispatcherServlet(final ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setTransformWsdlLocations(true);
		servlet.setApplicationContext(applicationContext);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "CountryWS")
	public static DefaultWsdl11Definition countryWSDefinition(final XsdSchema countryWSSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("CountryWS");
		definition.setTargetNamespace(SOAPConstants.NAMESPACE);
		definition.setLocationUri("/ws");
		definition.setSchema(countryWSSchema);
		return definition;
	}

	@Bean
	public static XsdSchema countryWSSchema() {
		return new SimpleXsdSchema(new ClassPathResource("CountryWS.xsd"));
	}
}
