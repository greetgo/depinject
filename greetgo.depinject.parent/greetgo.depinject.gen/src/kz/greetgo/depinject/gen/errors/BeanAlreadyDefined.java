package kz.greetgo.depinject.gen.errors;

import kz.greetgo.depinject.gen.BeanDefinition;

public class BeanAlreadyDefined extends RuntimeException {
  public final BeanDefinition beanDefinition;
  public final BeanDefinition existsBeanDefinition;

  public BeanAlreadyDefined(BeanDefinition beanDefinition, BeanDefinition existsBeanDefinition) {
    super(createMessage(beanDefinition, existsBeanDefinition));
    this.beanDefinition = beanDefinition;
    this.existsBeanDefinition = existsBeanDefinition;
  }

  private static String createMessage(BeanDefinition beanDefinition, BeanDefinition existsBeanDefinition) {
    return "Adding " + beanDefinition + "; already existing " + existsBeanDefinition;
  }
}
