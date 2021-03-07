package com.ajitesh.thread.jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.*;

import static org.openjdk.jcstress.annotations.Expect.*;


@JCStressTest
@State
@Outcome(id = "1, 2", expect = ACCEPTABLE, desc = "T1 updated, then T2 updated.")
@Outcome(id = "2, 1", expect = ACCEPTABLE, desc = "T2 updated, then T1 updated.")
@Outcome(id = "1, 1", expect = ACCEPTABLE, desc = "Both T1 and T2 updated concurrently.")
class VolatileIncrementAtomicityTest {
  volatile int v;

  @Actor
  void actor1(II_Result  r) {
    r.r1 = ++v;
  }

  @Actor
  void actor2(II_Result  r) {
    r.r2 = ++v;
  }
}
