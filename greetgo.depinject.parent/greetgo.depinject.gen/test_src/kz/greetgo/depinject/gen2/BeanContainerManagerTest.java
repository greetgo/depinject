package kz.greetgo.depinject.gen2;

import kz.greetgo.depinject.core.BeanContainer;
import kz.greetgo.depinject.core.Include;
import kz.greetgo.depinject.gen.errors.ManyCandidates;
import kz.greetgo.depinject.gen.errors.NoCandidates;
import kz.greetgo.depinject.gen2.test_beans007.BeanConfig007;
import kz.greetgo.depinject.gen2.test_beans007.SomeBeanClass;
import kz.greetgo.depinject.gen2.test_beans008.BeanConfig008;
import kz.greetgo.depinject.gen2.test_beans008.BeanPreparation008_1;
import kz.greetgo.depinject.gen2.test_beans008.BeanPreparation008_2;
import kz.greetgo.depinject.gen2.test_beans009.BeanConfig009;
import kz.greetgo.depinject.gen2.test_beans009.BeanPreparation009_1;
import kz.greetgo.depinject.gen2.test_beans009.BeanPreparation009_1_a;
import kz.greetgo.depinject.gen2.test_beans009.BeanPreparation009_2;
import kz.greetgo.depinject.gen2.test_beans009.BeanPreparation009_3;
import kz.greetgo.depinject.gen2.test_beans011.BeanA3;
import kz.greetgo.depinject.gen2.test_beans011.BeanConfig011;
import kz.greetgo.depinject.gen2.test_beans011.ZGetters;
import kz.greetgo.depinject.gen2.test_beans015.BeanConfig015;
import kz.greetgo.depinject.gen2.test_beans015.SomeBean015;
import kz.greetgo.depinject.gen2.test_beans016.BeanConfig016;
import kz.greetgo.depinject.gen2.test_beans016.SomeBean016;
import kz.greetgo.depinject.gen2.test_beans016.SomeBeanFactory016;
import kz.greetgo.depinject.gen2.test_beans017.beans.core.UsingBeanFactoryRoom;
import kz.greetgo.depinject.gen2.test_beans017.util.BeanConfigUsingBigBeanFactory;
import kz.greetgo.depinject.gen2.test_beans017.util.BeanConfigUsingSmallBeanFactory;
import kz.greetgo.depinject.gen2.test_beans019.Bean019;
import kz.greetgo.depinject.gen2.test_beans019.BeanConfig019;
import kz.greetgo.depinject.gen2.test_beans020.Bean020;
import kz.greetgo.depinject.gen2.test_beans020.Bean020_free;
import kz.greetgo.depinject.gen2.test_beans020.BeanConfig020;
import kz.greetgo.depinject.gen2.test_beans021.Bean021;
import kz.greetgo.depinject.gen2.test_beans021.Bean021_free;
import kz.greetgo.depinject.gen2.test_beans021.BeanConfig021;
import kz.greetgo.depinject.gen2.test_beans022.Bean022;
import kz.greetgo.depinject.gen2.test_beans022.BeanConfig022;
import kz.greetgo.depinject.gen2.test_beans022.Iface022;
import kz.greetgo.depinject.gen2.test_beans023.Bean023;
import kz.greetgo.depinject.gen2.test_beans023.BeanConfig023;
import kz.greetgo.depinject.gen2.test_beans023.Iface023;
import kz.greetgo.depinject.gen2.test_beans024.Bean024;
import kz.greetgo.depinject.gen2.test_beans024.BeanConfig024;
import kz.greetgo.depinject.gen2.test_beans024.Iface024;
import kz.greetgo.depinject.gen2.test_beans025.Bean025;
import kz.greetgo.depinject.gen2.test_beans025.BeanConfig025;
import kz.greetgo.depinject.gen2.test_beans025.BeanWithRefToReplacer;
import kz.greetgo.depinject.gen2.test_beans026.Bean026;
import kz.greetgo.depinject.gen2.test_beans026.BeanConfig026;
import kz.greetgo.depinject.gen2.test_beans026.Replacer026_A;
import kz.greetgo.depinject.gen2.test_beans026.Replacer026_B;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;

public class BeanContainerManagerTest {

  @Include(BeanConfig007.class)
  interface For_prepareToWrite_ManyCandidates extends BeanContainer {
    @SuppressWarnings("unused")
    SomeBeanClass asd();
  }

  @Test(expectedExceptions = ManyCandidates.class)
  public void prepareToWrite_ManyCandidates() throws Exception {

    BeanContainerManager bcm = new BeanContainerManager(For_prepareToWrite_ManyCandidates.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

  }

  class SomeLeftClass {
  }

  @Include(BeanConfig007.class)
  interface For_prepareToWrite_NoCandidates extends BeanContainer {
    @SuppressWarnings("unused")
    SomeLeftClass asd();
  }

  @Test(expectedExceptions = NoCandidates.class)
  public void prepareToWrite_NoCandidates() throws Exception {

    BeanContainerManager bcm = new BeanContainerManager(For_prepareToWrite_NoCandidates.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

  }

  @Include(BeanConfig007.class)
  interface For_prepareToWrite_NoDuplicateBeansBecauseTheseClassesNotUsed extends BeanContainer {
  }

  @Test
  public void prepareToWrite_NoDuplicateBeansBecauseTheseClassesNotUsed() throws Exception {

    BeanContainerManager bcm = new BeanContainerManager(For_prepareToWrite_NoDuplicateBeansBecauseTheseClassesNotUsed.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

  }

  @Include(BeanConfig008.class)
  interface For_prepareToWrite_preparations_1 extends BeanContainer {
  }

  @Test
  public void prepareToWrite_preparations_1() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(For_prepareToWrite_preparations_1.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    System.out.println("---> BEGIN Preparations:");
    bcm.preparations.forEach(System.out::println);
    System.out.println("---> END   Preparations:\n");

    Collections.reverse(bcm.beanCreationList);
    System.out.println("---> BEGIN BeanCreationList");
    bcm.beanCreationList.forEach(System.out::println);
    System.out.println("---> END   BeanCreationList");

    System.out.println();

    bcm.beanCreationList.get(0).beanGetterDotList.forEach(System.out::println);


    BeanGetterDot bean1 = bcm.beanCreationList.get(0).beanGetterDotList.get(0);

    assertThat(bean1.beanReference.getterCreations).hasSize(2);

    assertThat(bean1.beanReference.getterCreations.get(0).preparations).hasSize(1);
    assertThat(bean1.beanReference.getterCreations.get(0).preparations.get(0).beanClass.getName())
      .isEqualTo(BeanPreparation008_1.class.getName());

    assertThat(bean1.beanReference.getterCreations.get(1).preparations).hasSize(2);
    assertThat(bean1.beanReference.getterCreations.get(1).preparations.get(0).beanClass.getName())
      .isEqualTo(BeanPreparation008_2.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(1).preparations.get(1).beanClass.getName())
      .isEqualTo(BeanPreparation008_1.class.getName());


    BeanGetterDot bean1impl = bcm.beanCreationList.get(0).beanGetterDotList.get(1);

    assertThat(bean1impl.beanReference.getterCreations).hasSize(1);
    assertThat(bean1impl.beanReference.getterCreations.get(0).preparations).isEmpty();


    BeanGetterDot bean2 = bcm.beanCreationList.get(0).beanGetterDotList.get(2);
    assertThat(bean2.beanReference.getterCreations).hasSize(1);

    assertThat(bean2.beanReference.getterCreations.get(0).preparations).hasSize(1);
    assertThat(bean2.beanReference.getterCreations.get(0).preparations.get(0).beanClass.getName())
      .isEqualTo(BeanPreparation008_2.class.getName());


    BeanGetterDot bean2impl = bcm.beanCreationList.get(0).beanGetterDotList.get(3);

    assertThat(bean2impl.beanReference.getterCreations).hasSize(1);
    assertThat(bean2impl.beanReference.getterCreations.get(0).preparations).isEmpty();
  }


  @Include(BeanConfig009.class)
  interface For_prepareToWrite_preparations_2 extends BeanContainer {
  }

  @Test
  public void prepareToWrite_preparations_2() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(For_prepareToWrite_preparations_2.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    System.out.println("---> BEGIN Preparations:");
    bcm.preparations.forEach(System.out::println);
    System.out.println("---> END   Preparations:\n");

    Collections.reverse(bcm.beanCreationList);

    System.out.println("---> BEGIN BeanCreationList");
    bcm.beanCreationList.forEach(System.out::println);
    System.out.println("---> END   BeanCreationList");

    System.out.println();

    List<BeanGetterDot> beanGetterDotList = bcm.beanCreationList.get(0).beanGetterDotList;

    beanGetterDotList.forEach(System.out::println);


    BeanGetterDot bean1 = beanGetterDotList.get(0);

    assertThat(bean1.beanReference.getterCreations).hasSize(3);

    assertThat(bean1.beanReference.getterCreations.get(0).preparations.get(0).beanClass.getName())
      .isEqualTo(BeanPreparation009_1.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(0).preparations.get(1).beanClass.getName())
      .isEqualTo(BeanPreparation009_1_a.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(0).preparations).hasSize(2);

    assertThat(bean1.beanReference.getterCreations.get(1).preparations.get(0).beanClass.getName())
      .isEqualTo(BeanPreparation009_2.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(1).preparations.get(1).beanClass.getName())
      .isEqualTo(BeanPreparation009_1.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(1).preparations.get(2).beanClass.getName())
      .isEqualTo(BeanPreparation009_1_a.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(1).preparations).hasSize(3);

    assertThat(bean1.beanReference.getterCreations.get(2).preparations.get(0).beanClass.getName())
      .isEqualTo(BeanPreparation009_3.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(2).preparations.get(1).beanClass.getName())
      .isEqualTo(BeanPreparation009_2.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(2).preparations.get(2).beanClass.getName())
      .isEqualTo(BeanPreparation009_1.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(2).preparations.get(3).beanClass.getName())
      .isEqualTo(BeanPreparation009_1_a.class.getName());
    assertThat(bean1.beanReference.getterCreations.get(2).preparations).hasSize(4);


    BeanGetterDot bean1impl = beanGetterDotList.get(1);

    assertThat(bean1impl.beanReference.getterCreations.get(0).preparations).isEmpty();
    assertThat(bean1impl.beanReference.getterCreations).hasSize(1);


    BeanGetterDot bean2 = beanGetterDotList.get(2);

    assertThat(bean2.beanReference.getterCreations).hasSize(2);

    assertThat(bean2.beanReference.getterCreations.get(0).preparations.get(0).beanClass.getName())
      .isEqualTo(BeanPreparation009_2.class.getName());
    assertThat(bean2.beanReference.getterCreations.get(0).preparations).hasSize(1);

    assertThat(bean2.beanReference.getterCreations.get(1).preparations.get(0).beanClass.getName())
      .isEqualTo(BeanPreparation009_3.class.getName());
    assertThat(bean2.beanReference.getterCreations.get(1).preparations.get(1).beanClass.getName())
      .isEqualTo(BeanPreparation009_2.class.getName());
    assertThat(bean2.beanReference.getterCreations.get(1).preparations).hasSize(2);
  }

  @SuppressWarnings("unused")
  @Include(BeanConfig011.class)
  interface BeanContainer011 extends BeanContainer {
    ZGetters getZ_Getters();
  }

  @Test
  public void prepareToWrite_BeanFactories() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer011.class);
    //
    //
    bcm.prepareToWrite();
    //
    //

    Map<String, BeanCreation> map = bcm.usingBeanCreationList
      .stream().collect(Collectors.toMap(a -> a.beanClass.getSimpleName(), a -> a));

    System.out.println(map);

    assertThat(map.get(BeanA3.class.getSimpleName())).isInstanceOf(BeanCreationWithBeanFactory.class);

    BeanCreationWithBeanFactory bean3creation = (BeanCreationWithBeanFactory) map.get(BeanA3.class.getSimpleName());
    assertThat(bean3creation.beanFactorySource.getterCreations).hasSize(1);
  }

  @Include(BeanConfig015.class)
  interface BeanContainer_TwoBeanConfigPaths_defaultConstructor extends BeanContainer {
    SomeBean015 get();
  }

  @Test
  public void prepareToWrite_TwoBeanConfigPaths_defaultConstructor() throws Exception {

    BeanContainerManager bcm = new BeanContainerManager(BeanContainer_TwoBeanConfigPaths_defaultConstructor.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    assertThat(bcm.usingBeanCreationList).hasSize(1);

  }

  @Include(BeanConfig016.class)
  interface BeanContainer_TwoBeanConfigPaths_factoryMethod extends BeanContainer {
    List<SomeBean016> get();
  }

  @Test
  public void prepareToWrite_TwoBeanConfigPaths_factoryMethod() throws Exception {

    BeanContainerManager bcm = new BeanContainerManager(BeanContainer_TwoBeanConfigPaths_factoryMethod.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    int factoryCount = 0, someBean016_count = 0;

    for (BeanCreation bc : bcm.usingBeanCreationList) {
      if (SomeBean016.class.isAssignableFrom(bc.beanClass)) someBean016_count++;
      if (SomeBeanFactory016.class.isAssignableFrom(bc.beanClass)) factoryCount++;
    }

    assertThat(factoryCount).isEqualTo(1);
    assertThat(someBean016_count).describedAs("If SomeBean016 is 6 " +
      "then error in method BeanCreationWithFactoryMethod.equals()").isEqualTo(3);
  }

  @Include(BeanConfigUsingSmallBeanFactory.class)
  interface BeanContainer_BeanConfigUsingSmallBeanFactory extends BeanContainer {
    UsingBeanFactoryRoom get();
  }

  @Include(BeanConfigUsingBigBeanFactory.class)
  interface BeanContainer_BeanConfigUsingBigBeanFactory extends BeanContainer {
    UsingBeanFactoryRoom get();
  }

  @Test
  public void prepareToWrite_BeanConfigUsingSmallBeanFactory() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer_BeanConfigUsingSmallBeanFactory.class);
    bcm.prepareToWrite();
  }

  @Test
  public void prepareToWrite_BeanConfigUsingBigBeanFactory() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer_BeanConfigUsingBigBeanFactory.class);
    bcm.prepareToWrite();
  }

  @Include(BeanConfig019.class)
  interface BeanContainer_019 extends BeanContainer {
    Bean019 get();
  }

  @Test
  public void prepareToWrite_019() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer_019.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    assertThat(bcm.beanContainerMethodList).describedAs("beanContainerMethodList.size must be 1").hasSize(1);
    assertThat(bcm.allBeanReferences).describedAs("allBeanReferences.size must be 1").hasSize(1);
    assertThat(bcm.writingBeanReferences).describedAs("writingBeanReferences.size must be absent").isEmpty();
  }

  @SuppressWarnings("unused")
  @Include(BeanConfig020.class)
  interface BeanContainer020 extends BeanContainer {
    Bean020 bean020();

    Bean020_free bean020_free();
  }

  @Test
  public void prepareToWrite_replacer_iface() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer020.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    assertThat(bcm.replacers).hasSize(1);

    assertThat(bcm.writingGetterCreations).hasSize(1);
    assertThat(bcm.writingGetterCreations.get(0).replacers).hasSize(1);
    assertThat(bcm.writingGetterCreations.get(0).beanCreation.beanClass.getName()).isEqualTo(Bean020.class.getName());
    assertThat(bcm.beanCreationList).hasSize(3);
    assertThat(bcm.usingBeanCreationList).hasSize(3);
  }


  @SuppressWarnings("unused")
  @Include(BeanConfig021.class)
  interface BeanContainer021 extends BeanContainer {
    Bean021 bean021();

    Bean021_free bean021_free();
  }

  @Test
  public void prepareToWrite_replacer_ann() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer021.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    assertThat(bcm.replacers).hasSize(1);

    assertThat(bcm.writingGetterCreations).hasSize(1);
    assertThat(bcm.writingGetterCreations.get(0).replacers).hasSize(1);
    assertThat(bcm.writingGetterCreations.get(0).beanCreation.beanClass.getName()).isEqualTo(Bean021.class.getName());
    assertThat(bcm.beanCreationList).hasSize(3);
    assertThat(bcm.usingBeanCreationList).hasSize(3);
  }

  @SuppressWarnings("unused")
  @Include(BeanConfig022.class)
  interface BeanContainer022 extends BeanContainer {
    Iface022 iface022();

    Bean022 bean022();

    Bean022 bean022_more();

    Iface022 iface022_more();
  }

  @Test
  public void prepareToWrite_replacer_returnClass() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer022.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    bcm.beanContainerMethodList.forEach(System.out::println);

    assertThat(bcm.beanContainerMethodList).hasSize(4);
    assertThat(bcm.replacers).hasSize(1);
    assertThat(bcm.usingBeanCreationList).hasSize(2);
    assertThat(bcm.writingGetterCreations).hasSize(2);

    assertThat(bcm.writingGetterCreations.get(0).replacers).hasSize(1);
    assertThat(bcm.writingGetterCreations.get(1).replacers).hasSize(1);

  }

  @SuppressWarnings("unused")
  @Include(BeanConfig023.class)
  interface BeanContainer023 extends BeanContainer {
    Iface023 iface023();

    Bean023 bean023();

    Bean023 bean023_more();

    Iface023 iface023_more();
  }

  @Test
  public void prepareToWrite_distinctGetterCreation() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer023.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    assertThat(bcm.beanContainerMethodList).hasSize(4);
    assertThat(bcm.replacers).isEmpty();
    assertThat(bcm.usingBeanCreationList).hasSize(2);
    assertThat(bcm.writingGetterCreations).hasSize(1);
    assertThat(bcm.writingBeanReferences).isEmpty();
  }

  @SuppressWarnings("unused")
  @Include(BeanConfig024.class)
  interface BeanContainer024 extends BeanContainer {
    Iface024 iface024();

    Bean024 bean024();

    Bean024 bean024_more();

    Iface024 iface024_more();
  }

  @Test
  public void prepareToWrite_noGetterCreation() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer024.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    assertThat(bcm.beanContainerMethodList).hasSize(4);
    assertThat(bcm.replacers).isEmpty();
    assertThat(bcm.usingBeanCreationList).hasSize(1);
    assertThat(bcm.writingGetterCreations).isEmpty();
    assertThat(bcm.writingBeanReferences).isEmpty();
  }

  @SuppressWarnings("unused")
  @Include(BeanConfig025.class)
  interface BeanContainer025 extends BeanContainer {
    Bean025 bean025();

    BeanWithRefToReplacer bean_with_ref_to_replacer();
  }

  @Test
  public void prepareToWrite_replacerForItself() throws Exception {

    BeanContainerManager bcm = new BeanContainerManager(BeanContainer025.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    assertThat(bcm.replacers).hasSize(2);

//    bcm.allBeanReferences.forEach(a -> System.out.println(a.toFullString()));

    Map<String, BeanReference> map = new HashMap<>();
    bcm.allBeanReferences.forEach(r -> map.put(r.sourceClass.getSimpleName(), r));
//    map.keySet().forEach(System.out::println);

    BeanReference beanRef = map.get("Bean025");
    assertThat(beanRef.getterCreations).hasSize(1);
    assertThat(beanRef.getterCreations.get(0).replacers).hasSize(2);

    BeanReference replaceBR = map.get("Replacer025");
    assertThat(replaceBR.getterCreations).hasSize(1);
    assertThat(replaceBR.getterCreations.get(0).replacers).describedAs("replacer cannot be replaced").isEmpty();

    BeanReference replaceBR_more = map.get("Replacer025_more");
    assertThat(replaceBR_more.getterCreations).hasSize(1);
    assertThat(replaceBR_more.getterCreations.get(0).replacers).describedAs("replacer cannot be replaced").isEmpty();
  }


  @SuppressWarnings("unused")
  @Include(BeanConfig026.class)
  interface BeanContainer026 extends BeanContainer {
    Bean026 bean026();
  }

  @Test
  public void prepareToWrite_replacePriority() throws Exception {
    BeanContainerManager bcm = new BeanContainerManager(BeanContainer026.class);

    //
    //
    bcm.prepareToWrite();
    //
    //

    assertThat(bcm.replacers).hasSize(2);
    assertThat(bcm.replacers.get(0).beanClass.getName()).isEqualTo(Replacer026_B.class.getName());
    assertThat(bcm.replacers.get(1).beanClass.getName()).isEqualTo(Replacer026_A.class.getName());
  }
}
