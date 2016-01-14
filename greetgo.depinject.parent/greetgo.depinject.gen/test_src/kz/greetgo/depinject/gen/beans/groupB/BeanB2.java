package kz.greetgo.depinject.gen.beans.groupB;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.gen.beans.groupA.FactoredBean3;
import kz.greetgo.depinject.gen.interfaces.IBeanB2;

@Bean
public class BeanB2 implements IBeanB2 {

  public BeanGetter<FactoredBean3> factoredBean3Bean;

  @Override
  public void goodDay() {
    System.out.println("Hello from " + BeanB2.class.getSimpleName());
    factoredBean3Bean.get().helloWorld();
  }
}