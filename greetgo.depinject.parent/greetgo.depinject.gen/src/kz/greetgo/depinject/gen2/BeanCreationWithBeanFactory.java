package kz.greetgo.depinject.gen2;

import kz.greetgo.depinject.core.BeanFactory;

import java.io.PrintStream;

import static kz.greetgo.depinject.gen2.Tab.tab;
import static kz.greetgo.depinject.gen2.Utils.asStr;

public class BeanCreationWithBeanFactory extends BeanCreation {
  public final BeanReference beanFactorySource;

  public BeanCreationWithBeanFactory(Class<?> beanClass, boolean singleton, BeanReference beanFactorySource) {
    super(beanClass, singleton);
    if (!BeanFactory.class.isAssignableFrom(beanFactorySource.targetClass)) {
      throw new RuntimeException(beanFactorySource.targetClass + " is not bean factory; " + beanFactorySource.place);
    }
    this.beanFactorySource = beanFactorySource;
  }

  @Override
  public String toString() {
    return (use ? '{' : '(')
      + asStr(beanClass) + (singleton ? ":SINGLE" : "MULT")
      + " created by " + beanFactorySource.firstBeanToString()
      + preparationInfo()
      + (use ? '}' : ')');
  }

  @Override
  protected void markToUseAdditions() {
    beanFactorySource.markToUse();
  }

  @Override
  protected void writeCreateBeanCode(int tab, PrintStream out, String variableName) {
    out.println(tab(tab) + beanClass.getName() + ' ' + variableName
      + " = " + beanFactorySource.getBeanGetterVarName() + ".get().createBean(" + beanClass.getName() + ".class);");
  }
}
