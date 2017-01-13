package kz.greetgo.depinject.gen2.UsingBeanFactory.beans.bean_factory_big;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.gen2.UsingBeanFactory.beans.core.LocalBeanFactory;

@Bean
public class SmallBeanFactory extends LocalBeanFactory {

  private int windowNumber = 1;

  @Override
  protected int nextWindowNumber() {
    return windowNumber++;
  }

  private int computerNumber = 1;

  @Override
  protected int nextComputerNumber() {
    return computerNumber++;
  }
}