package kz.greetgo.depinject.gen2.test_beans010;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.FactoredBy;

@Bean
@FactoredBy(BeanA3_beanFactory.class)
public interface BeanA3 extends BeanA2 {
}
