package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanProcessor implements BeanPostProcessor, DestructionAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleBean) {
            LifecycleBean lifecycleBean = (LifecycleBean) bean;
            lifecycleBean.beforeInit();
            System.out.println("\t11. postProcessBeforeInitialization methods of BeanPostProcessors");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleBean) {
            LifecycleBean lifecycleBean = (LifecycleBean) bean;
            lifecycleBean.afterInit();
            System.out.println("\t14. postProcessAfterInitialization methods of BeanPostProcessors");
        }
        return bean;
    }

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleBean) {
            LifecycleBean li = (LifecycleBean) bean;
            System.out.println("\tshutdown >> 1. postProcessBeforeDestruction methods of DestructionAwareBeanPostProcessors");
        }
    }
}
