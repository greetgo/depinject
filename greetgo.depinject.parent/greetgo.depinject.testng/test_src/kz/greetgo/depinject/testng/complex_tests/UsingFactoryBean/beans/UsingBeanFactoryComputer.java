package kz.greetgo.depinject.testng.complex_tests.UsingFactoryBean.beans;

import kz.greetgo.depinject.core.Bean;

@Bean(singleton = false)
public interface UsingBeanFactoryComputer {
  void turnOn();
}
