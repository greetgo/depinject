package kz.greetgo.depinject.gen.beans.groupA;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.gen.interfaces.IBeanA1;

@Bean
public class BeanA1 implements IBeanA1, Transactional {
  @Override
  public void hello() {
    System.out.println("hello from " + BeanA1.class);
  }

  @Bean
  public FactoredBean1 createFactoredBean1() {
    return new FactoredBean1();
  }

  @Bean(singleton = false)
  public FactoredBean2 createFactoredBean2() {
    return new FactoredBean2();
  }
}