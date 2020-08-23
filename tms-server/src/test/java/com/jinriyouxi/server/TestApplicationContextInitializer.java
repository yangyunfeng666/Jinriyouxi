package com.jinriyouxi.server;


import com.jinriyouxi.common.propertity.Property;
import java.io.IOException;
import java.util.Properties;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.CollectionUtils;


/**
 *
 *
 * @author zengfan
 * @version $Id: TestApplicationContextInitializer.java 2017年6月12日 下午9:30:46 $
 */
public class TestApplicationContextInitializer implements ApplicationContextInitializer<GenericApplicationContext> {
	private Properties props = null;
	
	/** 
	 * @see ApplicationContextInitializer#initialize(org.springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void initialize(GenericApplicationContext context) {
		if (null != props) {
			return;
		}
		
		props = new Properties();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    	Resource[] resources = null;
		try {
			resources = resolver.getResources("classpath:properties/*.properties");
			for (Resource res : resources) {
				Properties properties = PropertiesLoaderUtils.loadProperties(res);
				CollectionUtils.mergePropertiesIntoMap(properties, props);
			}
			Property.init(props);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
