package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.*;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Bean factory implementations should support the standard bean lifecycle interfaces as far as possible. The full set of initialization methods and their standard order is:
 *
 * BeanNameAware's setBeanName
 * BeanClassLoaderAware's setBeanClassLoader
 * BeanFactoryAware's setBeanFactory
 * EnvironmentAware's setEnvironment
 * EmbeddedValueResolverAware's setEmbeddedValueResolver
 * ResourceLoaderAware's setResourceLoader (only applicable when running in an application context)
 * ApplicationEventPublisherAware's setApplicationEventPublisher (only applicable when running in an application context)
 * MessageSourceAware's setMessageSource (only applicable when running in an application context)
 * ApplicationContextAware's setApplicationContext (only applicable when running in an application context)
 * ServletContextAware's setServletContext (only applicable when running in a web application context)
 * postProcessBeforeInitialization methods of BeanPostProcessors
 * InitializingBean's afterPropertiesSet
 * a custom init-method definition
 * postProcessAfterInitialization methods of BeanPostProcessors
 * On shutdown of a bean factory, the following lifecycle methods apply:
 *
 * postProcessBeforeDestruction methods of DestructionAwareBeanPostProcessors
 * DisposableBean's destroy
 * a custom destroy-method definition
 */
@Component
public class LifecycleBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware,
        EmbeddedValueResolverAware,ResourceLoaderAware,ApplicationEventPublisherAware, MessageSourceAware,
        ApplicationContextAware,
        InitializingBean,DisposableBean {
    public LifecycleBean() {
        System.out.println(">> I'm in the bean default constructor!");
    }

    public void beforeInit() {
        System.out.println(">> Called before init");
    }

    public void afterInit() {
        System.out.println(">> Called after init.");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("\t1. BeanNameAware's setBeanName - Set the name of the bean in the bean factory that created this bean.");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("\t2. BeanClassLoaderAware's setBeanClassLoader - Callback that supplies the bean class loader to a bean instance.");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("\t3. BeanFactoryAware's setBeanFactory - Callback that supplies the owning factory to a bean instance.");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("\t4. EnvironmentAware's setEnvironment - Set the Environment that this component runs in.");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        System.out.println("\t5. EmbeddedValueResolverAware's setEmbeddedValueResolver - Set the StringValueResolver to use for resolving embedded definition values.");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("\t6. ResourceLoaderAware's setResourceLoader (only applicable when running in an application context)");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("\t7. ApplicationEventPublisherAware's setApplicationEventPublisher (only applicable when running in an application context)");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("\t8. MessageSourceAware's setMessageSource (only applicable when running in an application context)");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("\t9. ApplicationContextAware's setApplicationContext (only applicable when running in an application context)");
    }
//
//    @Override
//    public void setServletContext(ServletContext servletContext) {
//        System.out.println("\t10. ServletContextAware's setServletContext (only applicable when running in a web application context)");
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\t12. InitializingBean's afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("\tshutdown >> 2. DisposableBean's destroy");
    }

    @PostConstruct
    private void customInit() {
        System.out.println(">> Custom init method - after dependency inject but before the bean is put in service.");
    }

    @PreDestroy
    private void customDestroy() {
        System.out.println(">> Custom destroy method - using @PreDestroy annotation");
    }
}
